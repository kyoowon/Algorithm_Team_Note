import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B3_02522_별찍기12 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		
		for (int n = 1; n <= N; n++) {
			for (int c = 1; c <= N - n; c++) {
				output.append(' ');
			}
			for (int c = 1; c <= n; c++) {
				output.append('*');
			}
			output.append('\n');
		}
		for (int n = N - 1; n > 0; n--) {
			for (int c = 1; c <= N - n; c++) {
				output.append(' ');
			}
			for (int c = 1; c <= n; c++) {
				output.append('*');
			}
			output.append('\n');
		}
		System.out.println(output);
		
	}
}
