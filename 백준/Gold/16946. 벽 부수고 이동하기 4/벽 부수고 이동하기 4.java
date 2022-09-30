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
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int[][] graph;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new int[N][M];
		for (int r = 0; r < N; r++) {
			String inputs = reader.readLine();
			for (int c = 0; c < M; c++) {
				graph[r][c] = inputs.charAt(c) - '0';
			}
		}
		
		int[] groups = new int[1_000_001];
		int cnt = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (graph[r][c] == 0) {
					groups[cnt] = bfs(r, c, cnt++);
				}
			}
		}
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (graph[r][c] == 1) {
					int sum = 1;
					int[] visited = new int[4];
					for (int d = 0; d < deltas.length; d++) {
						int nx = r + deltas[d][0];
						int ny = c + deltas[d][1];
						
						if (isIn(nx, ny) && graph[nx][ny] != 1) {
							boolean flag = false;
							for (int v = 0; v < d; v++) {
								if (visited[v] == graph[nx][ny]) {
									flag = true;
									break;
								}
							}
							if (!flag) {
								visited[d] = graph[nx][ny];
								sum += groups[graph[nx][ny]];
							}
							
						}
					}
					output.append(sum % 10);
				}else {
					output.append(0);
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	static int[][] deltas = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	private static int bfs(int r, int c, int nbr) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		graph[r][c] = nbr;
		int cnt = 1;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny) && graph[nx][ny] == 0) {
					graph[nx][ny] = nbr;
					q.add(new Node(nx, ny));
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "3 3\r\n" + 
			"101\r\n" + 
			"010\r\n" + 
			"101";
}

// solution
// 빈 공간에 해당하는 부분을 먼저 찾아서 갯수를 파악
// 이에 대한 정보를 배열로 만들어 저장
// 다시 순회하면서 벽인 위치의 4면을 확인해서 해당 값들을 더함.