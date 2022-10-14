package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_02206_벽부수고이동하기 {
	static class Node{
		int x;
		int y;
		int cnt;
		int isBorken;
		public Node(int x, int y, int cnt, int isBorken) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.isBorken = isBorken;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", isBorken=" + isBorken + "]";
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int K;
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		int[][] graph = new int[N][M];
		visited = new boolean[N][M][K + 1];
		
		for (int r = 0; r < N; r++) {
			String inputs = reader.readLine();
			for (int c = 0; c < M; c++) {
				graph[r][c] = inputs.charAt(c) - '0';
			}
		}
		
		if (N == 1 && M == 1) {
			System.out.println(1);
		}else {			
			System.out.println(bfs(graph));
		}
	}
	
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[][][] visited;
	static int bfs(int[][] graph) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, 0));
		
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny)) {
					if (nx == N - 1 && ny == M - 1) {
						return node.cnt + 1;
					}if (graph[nx][ny] == 0 && !visited[nx][ny][node.isBorken]) {
						visited[nx][ny][node.isBorken] = true;
						q.add(new Node(nx, ny, node.cnt + 1, node.isBorken));
					} else if (node.isBorken < K && graph[nx][ny] == 1  && !visited[nx][ny][node.isBorken + 1]) {
						if (node.cnt % 2 == 1) {
							visited[nx][ny][node.isBorken + 1] = true;
							q.add(new Node(nx, ny, node.cnt + 1, node.isBorken + 1));
						} else {
							q.add(new Node(node.x, node.y, node.cnt + 1, node.isBorken));
						}
					}
				}
			}
		}
		return -1;
	}
	
	
	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "1 4 1\r\n" + 
			"0010";
}
