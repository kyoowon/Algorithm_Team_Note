import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B3_02523_별찍기13 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		for (int n = N; n > 0; n--) {
			for (int c = 0; c <= N - n; c++) {
				output.append('*');
			}
			output.append('\n');
		}
		for (int n = 1; n < N; n++) {
			for (int c = 0; c < N - n; c++) {
				output.append('*');
			}
			output.append('\n');
		}
		System.out.print(output);
		
	}
}
