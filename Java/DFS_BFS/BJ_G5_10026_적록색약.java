import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_G5_10026_적록색약 {
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static char[][] graph;
	static boolean[][][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		N = Integer.parseInt(reader.readLine());
		
		graph = new char[N][];
		visited = new boolean[N][N][2];
		
		for (int r = 0; r < N; r++) {
			graph[r] = reader.readLine().toCharArray();
		}
		
		int[] result = new int[2];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c][0]) {
					BFS(r, c, 0);
					result[0]++;
				}
				if (!visited[r][c][1]) {
					BFS(r, c, 1);
					result[1]++;
				}
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
	
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static void BFS(int r, int c, int type) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[r][c][type] = true;
		char color = graph[r][c];
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				
				if (isIn(nx, ny) && !visited[nx][ny][type]) {
					if (type == 0 && graph[nx][ny] == color) {
						visited[nx][ny][type] = true;
						q.add(new Node(nx, ny));
					}
					if (type == 1) {
						if (color == 'R' || color == 'G') {
							if ((graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
								visited[nx][ny][type] = true;
								q.add(new Node(nx, ny));
							}
						} else {
							if (graph[nx][ny] == 'B') {
								visited[nx][ny][type] = true;
								q.add(new Node(nx, ny));
							}
						}
					}
				}
			}
		}
	}
	
	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	static String str = "5\r\n" + 
			"RRRBB\r\n" + 
			"GGBBB\r\n" + 
			"BBBRR\r\n" + 
			"BBRRR\r\n" + 
			"RRRRR";
}


// solution
// BFS 탐색으로 4방으로 시행하는데 
// 이때 R / G / B 따로 1개
// R - G / B로 1개 BFS 탐색을 실시한다.