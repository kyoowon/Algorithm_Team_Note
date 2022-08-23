package 순열조합부분집합;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/6603
 * @performance 11600	76
 * @category 조합
 * @memo
 */

public class BJ_S2_06603_로또 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[] numbers = new int[13];
	static int K;
	public static void main(String[] args) throws IOException {
//		reader = new BufferedReader(new StringReader(str));
		boolean flag = false;
		while (true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			K = Integer.parseInt(tokens.nextToken());
			if (K == 0) break;
			
			if (flag)
				output.append("\n");
			flag = true;
			for (int i = 0; i < K; i++) {
				numbers[i] = Integer.parseInt(tokens.nextToken());
			}
//			System.out.println(Arrays.toString(numbers));
			// input
			

			combinations(0, new int[6], 0);
		}
		System.out.print(output);
	}
	static StringBuilder output = new StringBuilder();
	private static void combinations(int cnt, int[] select, int start) {
		if (cnt == select.length) {
			for (int i = 0; i < select.length; i++) {
				output.append(select[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		for (int i = start; i < K; i++) {
			select[cnt] = numbers[i];
			combinations(cnt + 1, select, i + 1);
		}
	}

	static String str = "7 1 2 3 4 5 6 7\r\n" + 
			"8 1 2 3 5 8 13 21 34\r\n" + 
			"0";
}
