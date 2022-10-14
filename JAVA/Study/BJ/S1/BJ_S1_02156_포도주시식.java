package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_S1_02156_포도주시식 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(reader.readLine());
		
		int[] dp = new int[T + 1];
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			if (t == 1 || t == 2) {
				dp[t] = N;
			}else {
				dp[t] = Math.max(dp[t - 2] + dp[t - 3], dp[t - 1] + N);
			}
		}
		System.out.println(Arrays.toString(dp));
	}
}
