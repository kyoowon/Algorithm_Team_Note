package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_17070_파이프옮기기1 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[][] graph;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		N = Integer.parseInt(reader.readLine());
		
		graph = new int[N][N];
		dp = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for (int[] row : graph) {
//			System.out.println(Arrays.toString(row));
//		}
		dfs(0, 1, 0);
		System.out.println(result);
	}
	
	static int[][] dp;
	static int[][][] deltas = {{{0, 1}, {1, 1}}, {{1, 0}, {1, 1}}, {{0, 1}, {1, 0}, {1, 1}}};
	static int result = 0;
	private static void dfs(int i, int j, int del) {
		if (i == N - 1 && j == N - 1) {
			result++;
			return;
		}
		for (int d = 0, size = deltas[del].length; d < size; d++) {
			int nx = i + deltas[del][d][0];
			int ny = j + deltas[del][d][1];
			if (d == size - 1 && isIn(nx, ny)) {
				if (graph[nx][ny] == 0 && graph[i + 1][j] == 0 && graph[i][j + 1] == 0) {
					dfs(nx, ny, 2);
				}
			}else {
				if (isIn(nx, ny) && graph[nx][ny] == 0) {
					if (del == 0)
						dfs(nx, ny, 0);					
					else if (del == 1)
						dfs(nx, ny, 1);
					else
						dfs(nx, ny, d);
					
				}
			}
		}
	}


	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	static String str = "3\r\n" + 
			"0 0 0\r\n" + 
			"0 0 0\r\n" + 
			"0 0 0";
}
