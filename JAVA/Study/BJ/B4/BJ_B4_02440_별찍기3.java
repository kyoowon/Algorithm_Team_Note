package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B4_02440_별찍기3 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		for (int n = N; n > 0; n--) {
			for (int c = 0; c < n; c++) {
				output.append('*');
			}
			output.append('\n');
		}
		System.out.print(output);  
	}
}
