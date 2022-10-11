import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/15961
 * @performance 	180384	508
 * @category 슬라이딩윈도우
 * @memo 
 */

public class BJ_G4_15961_회전초밥 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int D = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int C = Integer.parseInt(tokens.nextToken());
		
		int[] sushi = new int[N * 2];		
		int[] kinds = new int[D + 1];
		int result = 0;
		for (int i = 0; i < N; i++) {
			sushi[N + i] = sushi[i] = Integer.parseInt(reader.readLine());
			if(i < K) {
				kinds[sushi[i]]++;
				if (kinds[sushi[i]] == 1) {
					result++;
				}
			}
		}
		int maxValue = result;
		if (kinds[C] == 0) maxValue++;		
		for (int i = K; i < N + K; i++) {
			if (++kinds[sushi[i]] == 1) {
				result++;
			}
			if (--kinds[sushi[i - K]] == 0) {
				result--;
			}
			if (kinds[C] == 0)
				maxValue = Math.max(maxValue, result + 1);
			else
				maxValue = Math.max(maxValue, result);
		}
		System.out.println(maxValue);
	}
	static String str = "8 50 4 7\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30";
}
