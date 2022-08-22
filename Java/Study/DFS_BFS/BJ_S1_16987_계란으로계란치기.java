

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/16987
 * @performance 15296	216
 * @category DFS 구현
 * @memo
 */

public class BJ_S1_16987_계란으로계란치기 {
	static class Egg {
		int S;
		int W;
		public Egg(int s, int w) {
			super();
			S = s;
			W = w;
		}
		@Override
		public String toString() {
			return "Egg [S=" + S + ", W=" + W + "]";
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Egg[] eggs;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		N = Integer.parseInt(reader.readLine());
		
		eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			eggs[i] = new Egg(s, w);
		}
		DFS(0);
		System.out.println(result);
	}
	
	static int result = 0;
	static void DFS(int cnt) {
		if (cnt == N) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i].S <= 0) {
					count++;
				}
			}
			result = Math.max(result, count);
			return;
		}
		if (eggs[cnt].S <= 0) {
			DFS(cnt + 1);
		}else {
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				if (eggs[i].S > 0 && i != cnt) {
					flag = true;
					eggs[i].S -= eggs[cnt].W;
					eggs[cnt].S -= eggs[i].W;
					DFS(cnt + 1);
					eggs[i].S += eggs[cnt].W;
					eggs[cnt].S += eggs[i].W;
				}
			}
			if (!flag) DFS(cnt + 1);
		}
	}
	
	static String str = "6\n" + 
			"100 1\n" + 
			"100 1\n" + 
			"100 1\n" + 
			"100 1\n" + 
			"100 1\n" + 
			"100 1";
}
