import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_02583_영역구하기 {
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int M;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		boolean[][] graph = new boolean[M][N];
		for (int k = 0; k < K; k++) {
			tokens = new StringTokenizer(reader.readLine());
			int lx = Integer.parseInt(tokens.nextToken());
			int ly = Integer.parseInt(tokens.nextToken());
			int rx = Integer.parseInt(tokens.nextToken());
			int ry = Integer.parseInt(tokens.nextToken());
			for (int r = lx; r < rx; r++) {
				for (int c = ly; c < ry; c++) {
					graph[c][r] = true;
				}
			}
		}
		// input
		List<Integer> result = new ArrayList<Integer>();
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (!graph[r][c]) {
					result.add(BFS(r, c, graph));
				}
			}
		}
		Collections.sort(result);
		output.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			output.append(result.get(i)).append(" ");
		}
		System.out.println(output);
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int BFS(int r, int c, boolean[][] graph) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		int count = 1;
		graph[r][c] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny) && !graph[nx][ny]) {
					graph[nx][ny] = true;
					q.add(new Node(nx, ny));
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < M && 0 <= ny && ny < N;
	}

	static String str = "5 7 3\r\n" + 
			"0 2 4 4\r\n" + 
			"1 1 2 5\r\n" + 
			"4 0 6 2";
}
