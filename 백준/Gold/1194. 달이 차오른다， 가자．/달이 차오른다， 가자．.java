import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int x;
		int y;
		int cnt;
		int key;
		public Node(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + ", key=" + key + "]";
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static char[][] graph;
	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new char[N][M];
		Node start = null;
		for (int i = 0; i < N; i++) {
			String input = reader.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = input.charAt(j);
				if (graph[i][j] == '0') {
					start = new Node(i, j, 0, 0);
				}
			}
		}
		System.out.println(bfs(start));
	}
	
	static int[][] deltas = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	private static int bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		boolean[][][] visited = new boolean[N][M][(int) Math.pow(2, 6)];
		visited[start.x][start.y][0] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny) && graph[nx][ny] != '#' && !visited[nx][ny][node.key]) {
					if (graph[nx][ny] == '1')
						return node.cnt + 1;
					int isKey = "abcdef".indexOf(graph[nx][ny]);
					if (isKey >= 0) {
						visited[nx][ny][node.key] = true;				
						q.add(new Node(nx, ny, node.cnt + 1, node.key | 1 << isKey));
					}
					int isDoor = "ABCDEF".indexOf(graph[nx][ny]);
					if (isDoor >= 0 && (node.key & 1 << isDoor) > 0) {
						visited[nx][ny][node.key] = true;
						q.add(new Node(nx, ny, node.cnt + 1, node.key));
					} 
					if (graph[nx][ny] == '.' || graph[nx][ny] == '0'){
						visited[nx][ny][node.key] = true;
						q.add(new Node(nx, ny, node.cnt + 1, node.key));
					}
				}
			}
		}
		return -1;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "3 6\r\n" + 
			"###...\r\n" + 
			"#0A.1a\r\n" + 
			"###...";
}