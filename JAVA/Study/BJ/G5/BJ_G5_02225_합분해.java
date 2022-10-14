package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_02225_합분해 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		int[][] dp = new int[N + 1][N + 1];
		
		for (int n = 1; n <= N; n++) {
			dp[n][n] = 1;
		}
		
		System.out.println(Arrays.toString(dp[1]));
		for (int n = 2; n <= N; n++) {
			for (int k = 1; k <= n; k++) {
				if (n > k) {					
					for (int num = 0; num <= N; num++) {					
						dp[n][k] += dp[n - k][num];
					}
				}
			}
			System.out.println(Arrays.toString(dp[n]));
		}
	}
}
