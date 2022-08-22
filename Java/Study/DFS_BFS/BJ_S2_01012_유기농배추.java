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
 * @link https://www.acmicpc.net/problem/1012
 * @performance 13708	116
 * @category BFS
 * @memo
 */

public class BJ_S2_01012_유기농배추 {
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
	static int N;
	static int M;
	static boolean[][] graph = new boolean[50][50];
	public static void main(String[] args) throws IOException {
//		reader = new BufferedReader(new StringReader(str));

		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			int K = Integer.parseInt(tokens.nextToken());
			
			
			for (int k = 0; k < K; k++) {
				tokens = new StringTokenizer(reader.readLine());
				int y = Integer.parseInt(tokens.nextToken());
				int x = Integer.parseInt(tokens.nextToken());
				graph[x][y] = true;
			}
			
//			for (boolean[] row : graph)
//				System.out.println(Arrays.toString(row));
//			System.out.println();
			// input
			
			int result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (graph[r][c]) {
						BFS(r, c);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
	
	static int[][] deltas = {{0, 1},{0, -1},{1, 0},{-1, 0}};
	private static void BFS(int r, int c) {
		graph[r][c] = false;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		while(!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny) && graph[nx][ny]) {
					graph[nx][ny] = false;
					q.add(new Node(nx, ny));
				}
			}
		}
	}

	static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}
	
	static String str = "2\r\n" + 
			"10 8 17\r\n" + 
			"0 0\r\n" + 
			"1 0\r\n" + 
			"1 1\r\n" + 
			"4 2\r\n" + 
			"4 3\r\n" + 
			"4 5\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"7 4\r\n" + 
			"8 4\r\n" + 
			"9 4\r\n" + 
			"7 5\r\n" + 
			"8 5\r\n" + 
			"9 5\r\n" + 
			"7 6\r\n" + 
			"8 6\r\n" + 
			"9 6\r\n" + 
			"10 10 1\r\n" + 
			"5 5";
}

// 4방 탐색으로 인접한 배추를 확인
// 몇마리의 지렁이가 필요한지 최소 마리 수 출력
// 테스트 케이스, 가로, 세로, 배추가 심어져 있는 개수 k, x, y좌표입력
// solution
// BFS를 통해 해당 좌표를 방문했는지 확인