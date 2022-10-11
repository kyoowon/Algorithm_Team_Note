import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1261
 * @performance 12412	112
 * @category 다익스트라
 * @memo distance 배열에 초기값 설정할 때 시작점도 초기화!!
 */

public class BJ_G4_01261_알고스팟 {
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
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = reader.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = input.charAt(j) - '0';
			}
		}
		System.out.println(dijkstra());
	}
	
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int dijkstra() {
		
		int[][] distance = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				distance[i][j] = 100_000;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(0, 0, 0));
		distance[0][0] = 0; // 요부분 실수!!
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if (distance[node.x][node.y] < node.cost) {
				continue;
			}
			
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny)) {
					int costs = node.cost + graph[nx][ny];
					if (distance[nx][ny] > costs) {
						distance[nx][ny] = costs;
						pq.add(new Node(nx, ny, costs));
					}
				}
			}
		}
		return distance[N - 1][M - 1];
	}
	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "1 1\r\n" + 
			"0\r\n";
}
