import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[][] graph;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));
		
		N = Integer.parseInt(reader.readLine());
		
		graph = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		combination(0, 0, 0);
		System.out.println(result);
	}
	static int result = Integer.MAX_VALUE;
	private static void combination(int cnt, int start, int bitmask) {
		if(cnt <= N / 2) {
			int aSum = 0;
			int bSum = 0;
			for (int i = 0; i < N; i++) {
				if((bitmask & 1 << i) > 0) {
					for (int j = 0; j < N; j++) {
						if((bitmask & 1 << j) > 0 && i != j) {
							aSum += graph[i][j];
						}
					}
				}else {
					for (int j = 0; j < N; j++) {
						if((bitmask & 1 << j) == 0 && i != j) {
							bSum += graph[i][j];
						}
					}
				}
			}
			result = Math.min(result, Math.abs(aSum - bSum));
		}else {
			return;
		}
		for(int i = start; i < N; i++) {
			if((bitmask & 1 << i) == 0) {
				combination(cnt + 1, i + 1, bitmask | 1 << i);
			}
		}
	}
	static String str = "6\n"
			+ "0 1 2 3 4 5\n"
			+ "1 0 2 3 4 5\n"
			+ "1 2 0 3 4 5\n"
			+ "1 2 3 0 4 5\n"
			+ "1 2 3 4 0 5\n"
			+ "1 2 3 4 5 0";
}