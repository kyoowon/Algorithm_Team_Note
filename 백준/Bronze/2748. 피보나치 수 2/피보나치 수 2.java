import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		fi = new long[N + 1];
		System.out.println(fibonacci(N));
//		System.out.println(Arrays.toString(fi));
	}

	static long[] fi;

	private static long fibonacci(int n) {
		if (n <= 0)
			return 0;
		if (n == 1 || n == 2) {
			fi[n] = 1;
			return 1;
		}
		if (fi[n] != 0)
			return fi[n];
		fi[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return fi[n];
	}
}
