import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1654
 * @performance 15404	148
 * @category
 * @memos
 */

public class BJ_S2_01654_랜선자르기 {
	static int K;
	static int N;
	static int[] lines;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		K = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());

		lines = new int[K];

		for (int n = 0; n < K; n++) {
			lines[n] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(lines);

		cutLines(0, lines[K - 1]);
		System.out.println(result);
	}

	static long result = 0;

	private static void cutLines(long start, long end) {
		long mid = (start + end) / 2;
		int count = 0;
		if (mid == 0) {
			result = 1;
			return;
		}
		if (start <= end) {			
			for (int l = 0; l < K; l++) {
				count += lines[l] / mid;
			}
			if (count >= N) {
				result = Math.max(result, mid);
				cutLines(mid + 1, end);
			} else {
				cutLines(start, mid - 1);
			}
		}
	}
}
