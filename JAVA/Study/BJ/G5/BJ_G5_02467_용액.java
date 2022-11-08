import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author kyulee
 * @link https://www.acmicpc.net/problem/2467
 * @performance 31792	292
 * @category 이분 탐색 + 투포인트
 * @memo
 *
 */

public class BJ_G5_02467_용액 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());

		int[] numbers = new int[N];

		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		for (int n = 0; n < N; n++) {
			numbers[n] = Integer.parseInt(tokens.nextToken());
		}
		int result[] = new int[2];
		int minValue = Integer.MAX_VALUE;
		
		int head = 0;
		int tail = N - 1;
		while (numbers[head] < numbers[tail]) {
			int minus = numbers[head] * -1;
			int idx = Arrays.binarySearch(numbers, head + 1, tail, minus);
			if (idx >= 0) {
				result[0] = numbers[head];
				result[1] = minus;
				minValue = 0;
				break;
			}
			int iidx = Math.abs(idx) - 1;
			int pre = (iidx == 0 || iidx - 1 == head) ? Integer.MAX_VALUE : Math.abs(numbers[head] + numbers[iidx - 1]);
			int post = Math.abs(numbers[iidx] + numbers[head]);
			if (pre > post) {
				tail = iidx;
				if (minValue > post) {
					minValue = post;
					result[0] = numbers[head];
					result[1] = numbers[tail];
				}
			} else {
				tail = iidx - 1;
				if (minValue > pre) {
					minValue = pre;
					result[0] = numbers[head];
					result[1] = numbers[tail];
				}
			}
			head++;
		}
		System.out.println(String.format("%d %d", result[0], result[1]));
	}
}
