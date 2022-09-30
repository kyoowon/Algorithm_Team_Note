import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author kyulee
 * @link https://www.acmicpc.net/problem/2206
 * @performance 159840 752
 * @category BFS + 3중 배열
 * @memo 너무 어렵따... 인덱스를 관리하기가 너무어렵고 생각하기가 쉽지 않은 문제였던 것 같다. 정말 고민을 많이했는데,,,
 *       다익스트라라고 생각하고 시작을 했는데.. 되지 않았다.
 */

public class Main {
	static class Node {
		int x;
		int y;
		int k;
		int cnt;

		public Node(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][][] visited;
	static char[][] graph;

	static int BFS(int k) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int nx = node.x;
			int ny = node.y;
			if (nx == graph.length - 1 && ny == graph[0].length - 1) {
				return node.cnt;
			}
			for (int d = 0; d < deltas.length; d++) {
				int dx = nx + deltas[d][0];
				int dy = ny + deltas[d][1];
				if (isIn(dx, dy)) {
					if (graph[dx][dy] == '0') {
						if (!visited[dx][dy][node.k]) {
							visited[dx][dy][node.k] = true;
							q.add(new Node(dx, dy, node.cnt + 1, node.k));
						}
					} else if (graph[dx][dy] == '1' && node.k + 1 <= k && !visited[dx][dy][node.k + 1]) {
						visited[dx][dy][node.k + 1] = true;
						q.add(new Node(dx, dy, node.cnt + 1, node.k + 1));
					}
				}
			}
		}
		return -1;
	}

	static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		graph = new char[N][];
		for (int n = 0; n < N; n++) {
			graph[n] = reader.readLine().toCharArray();
		}

		visited = new boolean[N][M][K + 1];

		System.out.println(BFS(K));

	}

}