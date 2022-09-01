import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1427
 * @performance
 * @category 문자열
 * @memo 제출 x
 */

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		char[] input = reader.readLine().toCharArray();
		Arrays.sort(input);
		for (int n = input.length - 1; n >= 0; n--) {
			output.append(input[n]);
		}
		System.out.println(output);
	}
}