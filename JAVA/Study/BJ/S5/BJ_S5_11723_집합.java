package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_11723_집합 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		
		int N = Integer.parseInt(reader.readLine());
		
		int S = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			String op = tokens.nextToken();
			int x = 0;
			if(tokens.hasMoreTokens())
				x = Integer.parseInt(tokens.nextToken());
			if("add".equals(op)) {
				S |= 1 << x;
			}else if("remove".equals(op)) {
				S &= ~(1 << x);				
			}else if("check".equals(op)) {
				output.append((S & 1 << x) > 0? 1 : 0).append("\n");
			}else if("toggle".equals(op)) {
				S ^= 1 << x;
			}else if("all".equals(op)) {
				S = (int) Math.pow(2, 21) - 1;
			}else if("empty".equals(op)) {
				S = 0;
			}
		}
		System.out.print(output);
	}
	
	static String str = "26\r\n" + 
			"add 1\r\n" + 
			"add 2\r\n" + 
			"check 1\r\n" + 
			"check 2\r\n" + 
			"check 3\r\n" + 
			"remove 2\r\n" + 
			"check 1\r\n" + 
			"check 2\r\n" + 
			"toggle 3\r\n" + 
			"check 1\r\n" + 
			"check 2\r\n" + 
			"check 3\r\n" + 
			"check 4\r\n" + 
			"all\r\n" + 
			"check 10\r\n" + 
			"check 20\r\n" + 
			"toggle 10\r\n" + 
			"remove 20\r\n" + 
			"check 10\r\n" + 
			"check 20\r\n" + 
			"empty\r\n" + 
			"check 1\r\n" + 
			"toggle 1\r\n" + 
			"check 1\r\n" + 
			"toggle 1\r\n" + 
			"check 1";
}
