import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/11055
 * @performace 12324	96
 * @category DP + LIS
 * @memo
 */

public class BJ_S2_11055_가장큰증가부분수열 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));
		
		int N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int[] dp = new int[N];
		int[] nums = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
			dp[i] = nums[i];
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < nums[i] + dp[j]) {
					dp[i] = nums[i] + dp[j];
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	static String str = "10\r\n" + 
			"1 100 2 50 60 3 5 6 7 8";
}
