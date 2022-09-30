import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// File f = new File("./input.txt");
		// reader = new BufferedReader(new FileReader(f));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			int[][] graph = new int[N][N];
			for (int r = 0; r < N; r++) {
				String inputs = reader.readLine();
				for (int c = 0; c < N; c++) {
					graph[r][c] = inputs.charAt(c) - '0';
				}
			}
			output.append(String.format("#%d %d\n", t, dijkstra(graph, N)));
		}
		System.out.print(output);
	}
	
	static int[][] deltas = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	private static int dijkstra(final int[][] graph, final int n) {
		int[][] distance = new int[n][n];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if (distance[node.x][node.y] < node.cost)
				continue;
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny, n)) {
					int costs = node.cost + graph[nx][ny];
					if (distance[nx][ny] > costs) {
						distance[nx][ny] = costs;
						pq.add(new Node(nx, ny, costs));
					}
				}
			}
		}
		return distance[n - 1][n - 1];
	}
	private static boolean isIn(int nx, int ny, int N) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}