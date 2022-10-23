import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_15658_연산자끼워넣기2 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] nums;
	static int[] ops = new int[4];
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		
		N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(reader.readLine());
		
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Permutation(0, new int[N - 1], new int[4]);
		System.out.println(resultMax);
		System.out.println(resultMin);
	}
	
	static int resultMax = Integer.MIN_VALUE;
	static int resultMin = Integer.MAX_VALUE;
	private static void Permutation(int cnt, int[] choosed, int[] visited) {
		if (cnt == N - 1) {
			int result = cul(choosed, cnt);
			resultMax = Math.max(resultMax, result);
			resultMin = Math.min(resultMin, result);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if (visited[i] < ops[i]) {
				choosed[cnt] = i;
				visited[i]++;
				Permutation(cnt + 1, choosed, visited);
				visited[i]--;
			}
		}
		
	}
	
	
	private static int cul(int[] choosed, int cnt) {
		int result = nums[0];
		for (int i = 0; i < cnt; i++) {
			if (choosed[i] == 0) {
				result += nums[i + 1];
			}else if (choosed[i] == 1) {
				result -= nums[i + 1];				
			}else if (choosed[i] == 2) {
				result *= nums[i + 1];								
			}else if (choosed[i] == 3) {
				result /= nums[i + 1];	
			}
		}
		return result;
	}
	static String str = "6\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"3 2 1 1";
}
