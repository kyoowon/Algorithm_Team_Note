import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		long[][] dp = new long[N + 1][10];
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		
		for (int n = 2; n <= N; n++) {
			for (int i = 0; i <= 9; i++) {
				if (i < 9)
					dp[n][i] = dp[n - 1][i + 1];
				if (i > 0)
					dp[n][i] += dp[n - 1][i - 1];
				
				dp[n][i] %= 1_000_000_000;
			}
		}
		
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result += dp[N][i];
			result %= 1_000_000_000;
		}
		System.out.println(result);
	}
}
