import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_16953_A_B {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		dfs(1, N, M);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	
	static int result = Integer.MAX_VALUE;
	private static void dfs(int cnt, long start, long target) {
		if (start > target) return;
		if (start == target) {
			result = Math.min(result, cnt);
		}
		dfs(cnt + 1, start * 2, target);
		dfs(cnt + 1, start * 10 + 1, target);
	}
}
