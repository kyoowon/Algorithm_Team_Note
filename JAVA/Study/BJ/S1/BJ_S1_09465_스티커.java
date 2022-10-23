import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author kyulee
 * @link https://www.acmicpc.net/problem/9465
 * @performace	147544	748
 * @category
 * @memo
 */
public class BJ_S1_09465_스티커 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(reader.readLine());
			
			int[][] sticker = new int[N][2];
			
			for (int r = 0; r < 2; r++) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for (int c = 0; c < N; c++) {					
					sticker[c][r] = Integer.parseInt(tokens.nextToken()); 
				}
			}
			
			int[][] dp = new int[N][2];
			
			dp[0][0] = sticker[0][0];
			dp[0][1] = sticker[0][1];
			
			for (int k = 1; k < N; k++) {
				if (k == 1) {
					dp[k][0] = dp[k - 1][1] + sticker[k][0];
					dp[k][1] = dp[k - 1][0] + sticker[k][1];
				}else {
					dp[k][0] = Math.max(Math.max(dp[k - 2][0], dp[k - 1][1]), dp[k - 2][1]) + sticker[k][0];
					dp[k][1] = Math.max(Math.max(dp[k - 2][1], dp[k - 1][0]), dp[k - 2][0]) + sticker[k][1];
				}
			}
			
			output.append(Math.max(dp[N - 1][0], dp[N - 1][1])).append('\n');
		}
		System.out.print(output);
	}
	static String str = "2\r\n" + 
			"5\r\n" + 
			"50 10 100 20 40\r\n" + 
			"30 50 70 10 60\r\n" + 
			"7\r\n" + 
			"10 30 10 50 100 20 40\r\n" + 
			"20 40 30 50 60 20 80";
}

// 스티커의 인접한 스티커는 사용할 수 없다.
// 점수의 합이 최대가 될 수 있도록 하는 스티커 때기해라.
