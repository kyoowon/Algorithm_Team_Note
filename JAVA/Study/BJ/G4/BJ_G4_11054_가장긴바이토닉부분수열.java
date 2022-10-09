import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/11054
 * @performance
 * @category LIS + DP
 * @memo
 */

public class BJ_G4_11054_가장긴바이토닉부분수열 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		
		int N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int[] nums = new int[N];
		int[][] dp = new int[N][2];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
			Arrays.fill(dp[i], 1);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i][0] < dp[j][0] + 1) {
					dp[i][0] = dp[j][0] + 1;
				}
			}
			int k = N - 1 - i;
			for (int j = N - 1; j > k; j--) {
				if (nums[k] > nums[j] && dp[k][1] < dp[j][1] + 1) {
					dp[k][1] = dp[j][1] + 1;
				}
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i][0] + dp[i][1] - 1);
		}
		System.out.println(max);
	}
	static String str = "5\r\n" + 
			"1 5 2 1 4";
}
