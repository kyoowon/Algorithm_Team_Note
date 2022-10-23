import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_16198_에너지모으기 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] beads;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		beads = new int[N];
		
		for (int n = 0; n < N; n++) {
			beads[n] = Integer.parseInt(tokens.nextToken());
		}
		
		Permutation(0, new int[N - 2], new boolean[N]);
		System.out.println(result);
	}
	
	static int result = 0;
	private static void Permutation(int cnt, int[] choosed, boolean[] visited) {
		if (cnt == N - 2) {
			result = Math.max(result, cul(choosed));
			return;
		}
		for (int i = 1; i < N - 1; i++) {
			if (!visited[i]) {
				choosed[cnt] = i;
				visited[i] = true;
				Permutation(cnt + 1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	private static int cul(int[] choosed) {
		
		int result = 0;
		boolean[] visited = new boolean[N];
		
		for (int choose : choosed) {
			visited[choose] = true;
			int pre = 0;
			int post = 0;
			for (int i = choose; i >= 0; i--) {
				if (!visited[i]) {
					pre = beads[i];
					break;
				}
			}
			for (int i = choose; i < N; i++) {
				if (!visited[i]) {
					post = beads[i];
					break;
				}
			}
			result += pre * post;
		}
		return result;
	}
}
