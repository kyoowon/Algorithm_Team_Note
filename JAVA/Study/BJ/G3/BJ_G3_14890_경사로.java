import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/14890
 * @performace 	13004	108
 * @category implements
 * @memo
 */

public class BJ_G3_14890_경사로 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));

		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int X = Integer.parseInt(tokens.nextToken());

		int[][] rows = new int[N][N];
		int[][] cols = new int[N][N];

		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < N; c++) {
				cols[c][r] = rows[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		int count = 0;
		for (int n = 0; n < N; n++) {
			if (setRunway(rows[n], X, N))
				count++;
			if (setRunway(cols[n], X, N))
				count++;
		}
		System.out.print(count);
	}

	private static boolean setRunway(int[] is, final int X, final int N) {
		Stack<Integer> stack = new Stack<>();

		boolean flag = false;
		stack.add(is[0]);
		int tmp = -2;
		for (int i = 1; i < N; i++) {
			int top = stack.isEmpty() ? tmp : stack.peek();
			if (top == is[i]) {
				stack.add(is[i]);
			} else {
				if (top + 1 == is[i] && !flag) {
					if (stack.size() < X) {
						return false;
					}
				} else if (top == is[i] + 1 && !flag) {
					flag = true;
				} else {
					return false;
				}
				stack.clear();
				stack.add(is[i]);
			}
			if (!stack.isEmpty()) {
				tmp = -2;
			}
			if (flag && stack.size() >= X) {
				tmp = is[i];
				stack.clear();
				flag = false;
			}
		}
		if (!flag)
			return true;
		return false;
	}
	
	static String str = "6 1\r\n" + 
			"3 2 1 1 2 3\r\n" + 
			"3 2 2 1 2 3\r\n" + 
			"3 2 2 2 3 3\r\n" + 
			"3 3 3 3 3 3\r\n" + 
			"3 3 3 3 2 2\r\n" + 
			"3 3 3 3 2 2";
}
