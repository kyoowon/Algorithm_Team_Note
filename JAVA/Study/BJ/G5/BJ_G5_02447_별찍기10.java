package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kyulee
 * @link
 * @performace
 * @category 분할 정복
 * @memo 분할 정복 문제를 풀 때에는 가장 작은 일이 무엇인지를 보고 점차 어떻게 커지는지를 확인해서 작은일이 어떻게 합쳐지는지를 확인!!
 */

public class BJ_G5_02447_별찍기10 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static char[][] maps;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		maps = new char[N][N];
		
		divideAndConquer(N / 3, 0, 0);
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (maps[r][c] == '*') {
					output.append('*');
				}else {
					output.append(' ');
				}
			}
			output.append('\n');
		}
		System.out.print(output);
		
	}
	private static void divideAndConquer(int level, int x, int y) {
		if (level == 1) {
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					if (r != 1 || c != 1) {
						maps[x + r][y + c] = '*';
					}
				}
			}
			return;
		}
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (r != 1 || c != 1) {
					divideAndConquer(level / 3, x + level * r, y + level * c);
				}
			}
		}
	}
}
