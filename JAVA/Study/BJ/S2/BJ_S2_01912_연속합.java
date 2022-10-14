package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_01912_연속합 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		
		int N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int result = Integer.MIN_VALUE;
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(tokens.nextToken());
			
			if (!flag) {
				result = Math.max(result, sum);				
			}
			if (sum < 0) {
				sum = 0;
			}else {
				flag = true;
				result = Math.max(result, sum);
			}
			
		}
		System.out.println(result);
		
	}
	static String str = "5\r\n" + 
			"-12 -2 -3 -4 -1";
}
