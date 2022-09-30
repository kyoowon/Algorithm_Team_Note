import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		int N = Integer.parseInt(reader.readLine());

		int[][] maps = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int c = 1; c <= N; c++) {
				maps[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		for (int[] row : maps) {
//			System.out.println(Arrays.toString(row));
//		}

		long[][][] dp = new long[N + 1][N + 1][3];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (r == 1 && c == 2) {
					dp[1][2][0] = 1; // 첫 파이프 설정
					continue;
				}
				if (maps[r][c] == 0) { // 벽이 아니라면
					
					dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][1]; // ㅡ 파이프인 경우, 직전의 발생할 수 있는 경우의 수  -, \
					
					dp[r][c][2] = dp[r - 1][c][2] + dp[r - 1][c][1]; // | 파이프인 경우, 직전의 발생할 수 있는 경우의 수 |, \
					
					if (maps[r - 1][c] == 0 && maps[r][c - 1] == 0) {
						dp[r][c][1] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2]; // \ 파이프인 경우, 직전의 발생할 수 있는 경우의 수 |, \, ㅡ
					}
				}
			}
		}

//		for (long[][] row : dp) {
//			for (long[] e : row) {
//				System.out.print(e[0] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		for (long[][] row : dp) {
//			for (long[] e : row) {
//				System.out.print(e[1] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		for (long[][] row : dp) {
//			for (long[] e : row) {
//				System.out.print(e[2] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		
	}

	static String str = "3\r\n" + 
			"0 0 0\r\n" + 
			"0 0 0\r\n" + 
			"0 0 0";
}