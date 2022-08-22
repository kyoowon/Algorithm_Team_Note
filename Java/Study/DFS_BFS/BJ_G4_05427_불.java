import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/05427
 * @performance 118972	556
 * @category BFS + BFS
 * @memo 불에 대한 BFS 실행, 다음 BFS를 통해서 해당 좌표를 갈 수 있는지 확인!! 댑스가 깊어지면 그만큼 시간이 오래걸리기 때문에 이러한 연산을 미리 해두고
 * 이를 활용할 수 있는 방안으로 고민해봐야한다.
 */

public class BJ_G4_05427_불 {
	static class Node {
		int x;
		int y;
		int time;

		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", time=" + time + "]";
		}
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int R;
	static int C;
	static char[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			graph = new char[R][C];
			fireVisited = new int[R][C];
			Queue<Node> fires = new LinkedList<>();
			Node start = null;
			for (int r = 0; r < R; r++) {
				String input = reader.readLine();
				for (int c = 0; c < C; c++) {
					graph[r][c] = input.charAt(c);
					if (graph[r][c] == '@') {
						start = new Node(r, c, 1);
					}
					if (graph[r][c] == '*') {
						fireVisited[r][c] = 1;
						fires.add(new Node(r, c, 1));
					}
				}
			}
			
			FireBFS(fires);
			int result = PersonBFS(start, fires);
			if (result == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
		}
	}

	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] fireVisited;
	private static void FireBFS(Queue<Node> fires) {
		while (!fires.isEmpty()) {
			Node node = fires.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny)) {
					if (fireVisited[nx][ny] == 0 && graph[nx][ny] == '.') {
						fireVisited[nx][ny] = node.time + 1;
						fires.add(new Node(nx, ny, node.time + 1));
					}
				}
			}
		}
	}
	
	private static int PersonBFS(Node start, Queue<Node> fires) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		boolean[][] visited = new boolean[R][C];
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (fireVisited[node.x][node.y] == 0 || fireVisited[node.x][node.y] > node.time) {
				if (node.x == 0 || node.y == 0 || node.x == R - 1 || node.y == C - 1) {
					return node.time;
				}
				for (int d = 0; d < deltas.length; d++) {
					int nx = node.x + deltas[d][0];
					int ny = node.y + deltas[d][1];
					
					if (isIn(nx, ny)) {
						if (!visited[nx][ny] && graph[nx][ny] == '.') {
							q.add(new Node(nx, ny, node.time + 1));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		return -1;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < R && 0 <= ny && ny < C;
	}

	static String str = "5\r\n" + 
			"4 3\r\n" + 
			"####\r\n" + 
			"#*@.\r\n" + 
			"####\r\n" + 
			"7 6\r\n" + 
			"###.###\r\n" + 
			"#*#.#*#\r\n" + 
			"#.....#\r\n" + 
			"#.....#\r\n" + 
			"#..@..#\r\n" + 
			"#######\r\n" + 
			"7 4\r\n" + 
			"###.###\r\n" + 
			"#....*#\r\n" + 
			"#@....#\r\n" + 
			".######\r\n" + 
			"5 5\r\n" + 
			".....\r\n" + 
			".***.\r\n" + 
			".*@*.\r\n" + 
			".***.\r\n" + 
			".....\r\n" + 
			"3 3\r\n" + 
			"###\r\n" + 
			"#@#\r\n" + 
			"###";
}

// 미로를 탈출하자 - 탈출은 맨 끝 우리가 체크하는 isIn를 벗어나는 순간 탈출한다.
// 불과 벽이 있는 공간은 탈출하지 못한다.
// 불은 4방으로 확장
// 지훈이도 4방으로 이동

// solution
// BFS를 불과 지훈이를 동시에 시도
// 탈출을 한다면 시간을 출력 // 안된다면  IMPOSSIBLE 출력