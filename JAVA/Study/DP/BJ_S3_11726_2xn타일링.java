package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/11726
 * @performance 11604	80
 * @category DP
 * @memo
 */
public class BJ_S3_11726_2xn타일링 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		memo = new int[N + 1];
		System.out.println(DP(N));
	}
	static int[] memo;
	static int DP(int n){
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (memo[n] != 0)
			return memo[n];
		memo[n] = DP(n - 1) + DP(n - 2);
		return memo[n] % 10_007;
	}
}
