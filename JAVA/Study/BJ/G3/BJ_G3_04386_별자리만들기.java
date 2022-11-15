import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_04386_별자리만들기 {
	static class Point{
		float x;
		float y;
		public Point(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node implements Comparable<Node>{
		int A;
		int B;
		float cost;
		public Node(int a, int b, float cost) {
			super();
			A = a;
			B = b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Float.compare(this.cost, o.cost);
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		Point[] nodes = new Point[N];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			float X = Float.parseFloat(tokens.nextToken());
			float Y = Float.parseFloat(tokens.nextToken());
			nodes[n] = new Point(X, Y);
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				float len = (float) Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2)); 
				q.add(new Node(i, j, len));
			}
		}
		
		int[] parent = new int[N];
		for(int n = 0; n < N; n++) {
			parent[n] = n;
		}
		
		float result = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			if (cnt == N - 1)
				break;
			Node node = q.poll();
			if(unionParent(node.A, node.B, parent)) {
				result += node.cost;
			}
		}
		System.out.printf("%.2f\n", result);
	}
	private static boolean unionParent(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		
		if (a == b)
			return false;
		
		if(a > b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
		return true;
	}
	private static int findParent(int a, int[] parent) {
		if (a != parent[a])
			parent[a] = findParent(parent[a], parent);
		return parent[a];
	}
}
