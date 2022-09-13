import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// reader = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int M = Integer.parseInt(tokens.nextToken());
			int N = Integer.parseInt(tokens.nextToken());
			int X = Integer.parseInt(tokens.nextToken());
			int Y = Integer.parseInt(tokens.nextToken());
			
			int MaxValue = 0;
			int result = 0;
			if (M > N) {
				MaxValue = lcm(M, N);
				result = Calender(M, N, X, Y, MaxValue);
			}else {
				MaxValue = lcm(N, M);
				result = Calender(N, M, Y, X, MaxValue);
			}
			output.append(result).append("\n");
		}
		System.out.print(output);
	}
	
	static int Calender(int m, int n, int x, int y, int l) {
		int result = 0;
		int cnt = 0;
		while (result <= l) {
			result = m * cnt++;
			result += x;
			int div = result % n;
			if (div == 0) div = n;
			if (div == y) {
				return result;
			}
		}
		return -1;
	}
	
	// 뉴클리드 호제법 - 최대 공약
	static int gcd(int bn, int sn) {
		int r = bn % sn;
		if (r == 0) {
			return sn;
		}else {
			return gcd(sn, r);
		}
	}
	
	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	static String str = "3\n"
			+ "10 12 10 12\n"
			+ "10 12 7 2\n"
			+ "13 11 5 6";
}