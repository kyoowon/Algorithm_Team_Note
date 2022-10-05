import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			String inputs = reader.readLine();
			for (int c = 0; c < M; c++) {
				graph[r][c] = inputs.charAt(c) - '0';
			}
		}
		
		dfs(0, 0);
		System.out.println(result);
	}
	
	static int result = 0;
	private static void dfs(int cnt, int bitmask) {
		if (cnt == N * M) {
			result = Math.max(result, getResult(bitmask));
			return;
		}
		dfs(cnt + 1, bitmask | 1 << cnt); // 가로로
		dfs(cnt + 1, bitmask); // 세로로
	}
	
	static int getResult(int bitmask) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int nbr = 0;
			for (int j = 0; j < M; j++) {
				if ((bitmask & 1 << (i * M + j)) > 0) {
					nbr = nbr * 10 + graph[i][j];
				} else {
					sum += nbr;
					nbr = 0;
				}
			}
			sum += nbr;
		}
		
		for (int j = 0; j < M; j++) {
			int nbr = 0;
			for (int i = 0; i < N; i++) {
				if ((bitmask & 1 << (i * M + j)) == 0) {
					nbr = nbr * 10 + graph[i][j];
				} else {
					sum += nbr;
					nbr = 0;
				}
			}
			sum += nbr;
		}
		return sum;
	}
	

	static String str = "1 1\r\n" + 
			"8";
}