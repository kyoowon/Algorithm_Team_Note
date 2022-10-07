import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));

		int T = Integer.parseInt(reader.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine()); // 학생의 수
			int M = Integer.parseInt(reader.readLine()); // 간선의 갯수

			int[][] graph = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = 1_000_000_000;
					if (i == j)
						graph[i][j] = 0;
				}
			}

			for (int m = 0; m < M; m++) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int a = Integer.parseInt(tokens.nextToken()) - 1;
				int b = Integer.parseInt(tokens.nextToken()) - 1;
				graph[a][b] = 1;
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (graph[i][j] != 1_000_000_000 || graph[j][i] != 1_000_000_000)
						cnt++;
				}
				if (cnt == N)
					count++;
			}
			output.append(String.format("#%d %d\n", t, count));
		}
		System.out.print(output);
	}

	static String str = "1\r\n" + "6\r\n" + "6\r\n" + "1 5\r\n" + "3 4\r\n" + "5 4\r\n" + "4 2\r\n" + "4 6\r\n"
			+ "5 2\r\n" + "";
}