package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/9095
 * @performance 11480	80
 * @category DP
 * @memo
 */

public class BJ_S3_09095_123더하기 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[] memo = new int[11];
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(reader.readLine());
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			System.out.println(DP(N));
		}
	}
	private static int DP(int n) {
		if (memo[n] != 0)
			return memo[n];
		memo[n] = DP(n - 1) + DP(n - 2) + DP(n - 3);
		return memo[n];
	}
	static String str = "3\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"10";
}
