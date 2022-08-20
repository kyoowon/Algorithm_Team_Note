import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link
 * @performance 42484	388
 * @category BFS
 * @memo
 */

public class BJ_S1_01926_그림 {
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[][] graph;
	static boolean[][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < M; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for (int[] row : graph)
//			System.out.println(Arrays.toString(row));
//		
		int resultArea = 0;
		int resultCount = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (graph[r][c] == 1 && !visited[r][c]) {
					resultArea = Math.max(resultArea, BFS(r, c));
					resultCount++;
				}
			}
		}
		
		System.out.println(resultCount);
		System.out.println(resultArea);
	}
	
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private static int BFS(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[r][c] = true;
		int Area = 1;
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];

				if(isIn(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
					q.add(new Node(nx, ny));
					visited[nx][ny] = true;
					Area++;
				}
			}
		}
		return Area;
	}
	
	static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}
	
	static String str = "6 5\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0";
}

// 그림의 개수와 그림 중 넓이가 가장 넓은 것을 출력
// 그림은 1로 연결된 그림 - 4방 탐색으로 연결된 것만
// 출력은 그림의 개수, 넓이를 출력, 그림이 없는 경우 넓이는 0이다.
// solutions
// x, y를 보면서 방문하지 않는 좌표를 방문에 탐색을 시작.