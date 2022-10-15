import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/14888
 * @performance 	131584	360
 * @category subSet
 * @memo
 */

public class BJ_S1_14225_부분수열의합 {
	static int N;
	static int nums[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// reader = new BufferedReader(new StringReader(str));
		N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		nums = new int[N];
		
		int sum = 0;
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(tokens.nextToken());
			sum += nums[n];
		}
		
		boolean[] visited = new boolean[sum + 2];
		System.out.println(subSet(visited));
	}
	
	private static int subSet(boolean[] visited) {
		
		for (int i = 1; i < 1 << N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) > 0) {
					sum += nums[j];
				}
			}
			visited[sum] = true;
		}
		
		int i = 1;
		while (visited[i]) i++;
		return i;
	}

	static String str = "4\r\n" + 
			"2 1 2 7";
}
