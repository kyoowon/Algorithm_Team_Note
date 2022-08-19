package 순열조합부분집합;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1182
 * @performance 
 * @category 부분집합
 * @memo 백트레킹을 위해서 만든 조건이 해당 문제에서 도움이 되지 못하고 fail... 0에 대한 값을 처리하기 위해서는 완탐이 필요했음.
 */
public class BJ_S2_01182_부분수열의합 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int S;
	static int[] nbrs;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		nbrs = new int[N];

		tokens = new StringTokenizer(reader.readLine());
		for (int n = 0; n < N; n++) {
			nbrs[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nbrs);
		subSet(0, 0);
		if (S == 0)
			System.out.println(result - 1);
		else
			System.out.println(result);
	}

	static int result = 0;

	static void subSet(int idx, int bitmask) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if ((bitmask & 1 << i) > 0)
					sum += nbrs[i];
			}
			if (sum == S)
				result++;
			return;
		}
		subSet(idx + 1, bitmask | 1 << idx);
		subSet(idx + 1, bitmask);
	}

	static String str = "5 0\r\n" + "0 0 0 0 0";
}
