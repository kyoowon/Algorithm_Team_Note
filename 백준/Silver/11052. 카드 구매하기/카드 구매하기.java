import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		int N = Integer.parseInt(reader.readLine());
		
		
		int[] cards = new int[N + 1];
		
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(tokens.nextToken());
		}
		
//		System.out.println(Arrays.toString(cards));
		
		int[] dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int k = i; k <= N; k++) {
				dp[k] = Math.max(dp[k], dp[k - i] + cards[i]);
			}
		}
		
		System.out.println(dp[N]);
		
	}
	
	static String str = "4\r\n" + 
			"3 5 15 16";
}