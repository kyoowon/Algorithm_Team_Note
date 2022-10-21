import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B3_10992_별찍기17 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		for (int n = 1; n <= N; n++) {
			for (int c = N - 1; c >= n; c--) {
				output.append(' ');
			}
			for (int c = 1; c <= 2*n - 1; c++) {
				if (c == 1 || c == 2*n - 1 || n == N)
					output.append('*');
				else
					output.append(' ');
			}
			output.append('\n');
		}
		System.out.println(output);
	}
}
