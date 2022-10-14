package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B3_02443_별찍기6 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		for (int n = N; n > 0; n--) {
			for (int c = N; c > n; c--) {
				output.append(' ');
			}
			for (int c = 0; c < 2 * n - 1; c++) {
				output.append('*');
			}
			output.append('\n');
		}
		System.out.println(output);
	}
}
