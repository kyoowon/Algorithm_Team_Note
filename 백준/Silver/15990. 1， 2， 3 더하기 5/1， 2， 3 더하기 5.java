import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(reader.readLine());
		int[][] dp = new int[100001][3];
		
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[1][2] = 0;
		dp[2][0] = 0;
		dp[2][1] = 1;
		dp[2][2] = 0;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		
		for (int i = 4; i <= 100000; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1_000_000_009;
			dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1_000_000_009;
			dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1_000_000_009;
		}
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			int sum = 0;
			for(int i = 0; i <= 2; i++) {
				sum += dp[N][i];
				sum %= 1_000_000_009;
			}
			output.append(sum).append("\n");
		}
		System.out.print(output);
	}
}