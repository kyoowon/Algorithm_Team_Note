import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/2638
 * @performace 	44364	236
 * @category bfs + implements
 * @memo
 */
public class BJ_G3_02638_치즈 {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}

	static int N;
	static int M;
	static boolean[][] cheeses;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		cheeses = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int m = 0; m < M; m++) {
				String c = tokens.nextToken();
				if (c.equals("1")) {
					cheeses[n][m] = true;
				}
			}
		}

		System.out.println(melting());
	}

	private static int melting() {
		int time = 0;
		while (true) {
			List<Node> edges = dfs();
			if (edges.isEmpty())
				break;

			time++;
			for (Node edge : edges) {
				cheeses[edge.x][edge.y] = false;
			}
		}
		return time;
	}

	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static List<Node> dfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		int[][] visited = new int[N][M];
		visited[0][0] = 2;
		List<Node> result = new ArrayList<>();
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];

				if (isIn(nx, ny) && visited[nx][ny] < 2) {
					if (cheeses[nx][ny]) {
						if (++visited[nx][ny] >= 2) {
							result.add(new Node(nx, ny));
						}
					} else {
						visited[nx][ny] = 2;
						q.add(new Node(nx, ny));
					}
				}
			}

		}

		return result;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && 0 <= ny && nx < N && ny < M;
	}
}

// 공기중에 접촉한 면이 최소 2개 이상이면 녹는다.
// 갇힌 공간이 중간에 있으면 이는 공기중에 접촉한 면이 아니다.