import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1806
 * @performance 22504	212
 * @category 부분합 + 투 포인트
 * @memo
 */

public class BJ_G4_01806_부분합 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(reader.readLine());
		int sum = 0;
		int head = 0;
		int tail = 0;
		int result = Integer.MAX_VALUE;
		int[] nums = new int[N];
		for (tail = 0; tail < N; tail++) {
			nums[tail] = Integer.parseInt(tokens.nextToken());
			sum += nums[tail];
			if (sum >= M) {
				while (head < tail) {
					if ((sum - nums[head]) >= M) {
						sum -= nums[head++];
					}else {						
						break;
					}
				}
				result = Math.min(result, tail - head + 1);
			}
		}
		if (result == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
	}
}
