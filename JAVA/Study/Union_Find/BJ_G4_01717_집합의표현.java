import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1717
 * @performance 	53196	384
 * @category union find
 * @memo
 */

public class BJ_G4_01717_집합의표현 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int[] parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(reader.readLine());
			int o = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			if(o == 0) {
				unionParent(a, b, parent);
			}else {
				if(findParent(a, parent) != findParent(b, parent)) {
					output.append("NO").append("\n");
				}else {
					output.append("YES").append("\n");
				}
			}
		}
		System.out.print(output);
	}
	
	static int findParent(int a, int[] parent) {
		if(a != parent[a])
			parent[a] = findParent(parent[a], parent);
		return parent[a];
	}
	
	static boolean unionParent(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		
		if (a == b)
			return false;
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
		return true;
	}
	
	static String str = "7 8\r\n" + 
			"0 1 3\r\n" + 
			"1 1 7\r\n" + 
			"0 7 6\r\n" + 
			"1 7 1\r\n" + 
			"0 3 7\r\n" + 
			"0 4 2\r\n" + 
			"0 1 1\r\n" + 
			"1 1 1";
}
