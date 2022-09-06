import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		int[][] dp = new int[N + 1][3];
		
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}
//		for(int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		System.out.println(dp[N][0]);
	}
}
