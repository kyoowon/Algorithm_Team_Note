import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int[][] dp = new int[N + 1][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int n = 2; n <= N; n++) {
			for (int i = 0; i < 10; i++) {
				for (int k = 0; k <= i; k++) {
					dp[n][i] += dp[n - 1][k];
					dp[n][i] %= 10_007;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
			result %= 10_007;
		}
		System.out.println(result);
	}
}
