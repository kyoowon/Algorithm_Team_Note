import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_02580_스도쿠 {
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

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static final int N = 9;
	static int[][] maps;

	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));

		maps = new int[N][N];

		List<Node> zeros = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < N; c++) {
				maps[r][c] = Integer.parseInt(tokens.nextToken());
				if (maps[r][c] == 0)
					zeros.add(new Node(r, c));
			}
		}

		DFS(0, zeros);
		System.out.println(output);
	}

	static boolean flag = false;

	private static void DFS(int cnt, List<Node> zeros) {
		if (flag)
			return;
		if (cnt == zeros.size()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					output.append(maps[i][j]).append(' ');
				}
				output.append('\n');
			}
			flag = true;
			return;
		}
		Node node = zeros.get(cnt);
		for (int i = 1; i <= 9; i++) {
			if (validate(node, i)) {
				maps[node.x][node.y] = i;
				DFS(cnt + 1, zeros);
				if (flag)
					return;
				maps[node.x][node.y] = 0;
			}
		}
	}

	private static boolean validate(Node node, int nbr) {
		for (int i = 0; i < N; i++) {
			if (maps[node.x][i] == nbr)
				return false;
			if (maps[i][node.y] == nbr)
				return false;
		}
		for (int x = 0, nx = (node.x / 3) * 3; x < 3; x++) {
			for (int y = 0, ny = (node.y / 3) * 3; y < 3; y++) {
				if (maps[x + nx][y + ny] == nbr)
					return false;
			}
		}
		return true;
	}

	static String str = "0 3 5 4 6 9 2 7 8\r\n" + "7 8 2 1 0 5 6 0 9\r\n" + "0 6 0 2 7 8 1 3 5\r\n"
			+ "3 2 1 0 4 6 8 9 7\r\n" + "8 0 4 9 1 3 5 0 6\r\n" + "5 9 6 8 2 0 4 1 3\r\n" + "9 1 7 6 5 2 0 8 0\r\n"
			+ "6 0 3 7 0 1 9 5 2\r\n" + "2 5 8 3 9 4 7 6 0";
}
