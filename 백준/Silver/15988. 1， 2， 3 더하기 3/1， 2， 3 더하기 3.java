import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		long[] dp = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 1_000_000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
		}
		
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			output.append(dp[N]).append("\n");
		}
		System.out.print(output);
	}
}