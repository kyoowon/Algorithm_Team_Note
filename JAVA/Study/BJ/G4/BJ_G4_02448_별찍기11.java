import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_02448_별찍기11 {
	static char[][] maps;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		maps = new char[N][N * 2 - 1];
		
		divideAndConquer(N, 0, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				if (maps[i][j] == '*')
					output.append('*');
				else
					output.append(' ');
			}
			output.append('\n');
		}
		System.out.println(output);
	}

	private static void divideAndConquer(int n, int x, int y) {
		if (n == 3) {
			maps[x][y + 2] = '*';
			maps[x + 1][y + 1] = '*';
			maps[x + 1][y + 3] = '*';
			for (int i = 0; i < 5; i++) {
				maps[x + 2][y + i] = '*';
			}
			return;
		}
		divideAndConquer(n / 2, x, y +  (n / 2));
		divideAndConquer(n / 2, x + (n / 2), y);
		divideAndConquer(n / 2, x + (n / 2), y + n);
	}
}
