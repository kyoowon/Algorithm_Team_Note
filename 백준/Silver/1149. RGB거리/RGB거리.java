import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));
		int N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[][] dp = new int[N + 1][3];
		
		int R = Integer.parseInt(tokens.nextToken());
		int G = Integer.parseInt(tokens.nextToken());
		int B = Integer.parseInt(tokens.nextToken());
		
		dp[1][0] = R;
		dp[1][1] = G;
		dp[1][2] = B;
		
		for (int i = 2; i <= N; i++) {
			tokens = new StringTokenizer(reader.readLine());
			R = Integer.parseInt(tokens.nextToken());
			G = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			dp[i][0] = Math.min(dp[i - 1][1] + R, dp[i - 1][2] + R);
			dp[i][1] = Math.min(dp[i - 1][0] + G, dp[i - 1][2] + G);
			dp[i][2] = Math.min(dp[i - 1][0] + B, dp[i - 1][1] + B);
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
	
	static String str = "3\r\n" + 
			"26 40 83\r\n" + 
			"49 60 57\r\n" + 
			"13 89 99";
}
