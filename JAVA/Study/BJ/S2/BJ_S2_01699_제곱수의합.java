package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S2_01699_제곱수의합 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		int[] dp = new int[N + 1];
		
		for (int i = 1; i * i <= N; i++) {
			for (int k = i * i; k <= N; k++) {
				if (i == 1) {
					dp[k] = dp[k - 1] + 1;
					continue;
				}
				dp[k] = Math.min(dp[k], dp[k - i * i] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
