import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1647
 * @performance 324776	1424
 * @category 크루스칼
 * @memo 양방향
 */

public class BJ_G4_01647_도시분할계획 {
	static class Node implements Comparable<Node>{
		int a;
		int b;
		int cost;
		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int V;
	static int E;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		ArrayList<Node> paths = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			tokens = new StringTokenizer(reader.readLine());
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			int C = Integer.parseInt(tokens.nextToken());
			paths.add(new Node(A, B, C));
		}
		
		Collections.sort(paths);
		
		int[] parent = new int[V + 1];
		for (int v = 1; v <= V; v++) {
			parent[v] = v;
		}
		
		int cnt = 0;
		int costs = 0;
		
		for(Node path : paths) {
			if (cnt == V - 2) break;
			if(UnionParent(path.a, path.b, parent)) {
				costs += path.cost;
				cnt++;
			}
		}
		System.out.println(costs);
	}
	
	static int findParent(int a, int[] parent) {
		if (a != parent[a]) {
			parent[a] = findParent(parent[a], parent);
		}
		return parent[a];
	}
	
	static boolean UnionParent(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		
		if (a == b) return false;
		if(a > b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
		return true;
	}
}
