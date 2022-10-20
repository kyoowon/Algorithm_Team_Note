import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/3067
 * @performance 	19052	120
 * @category DP - 배낭문제
 * @memo
 */

public class BJ_G5_03067_Coins {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int[][] dp;
	static int[] coins;
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			
			coins = new int[N + 1];
			
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int n = 1; n <= N; n++) {
				coins[n] = Integer.parseInt(tokens.nextToken());
			}
			
			int K = Integer.parseInt(reader.readLine());
			
			dp = new int[N + 1][K + 1];
			
			for (int i = 1; i <= N; i++) {
				for (int k = 0; k <= K; k++) {
					if (k == 0)
						dp[i][k] = 1;
					else if (coins[i] <= k) {
						dp[i][k] = dp[i - 1][k] + dp[i][k - coins[i]];						
					}else {
						dp[i][k] = dp[i - 1][k];
					}
				}
			}
			output.append(dp[N][K]).append('\n');
		}
		System.out.print(output);
	}
	static String str = "3\r\n" + 
			"2\r\n" + 
			"1 2\r\n" + 
			"1000\r\n" + 
			"3\r\n" + 
			"1 5 10\r\n" + 
			"100\r\n" + 
			"2\r\n" + 
			"5 7\r\n" + 
			"22";
}
