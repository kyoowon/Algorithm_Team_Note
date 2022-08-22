import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1759
 * @performance 13464	92
 * @category 순열
 * @memo
 */

public class BJ_G5_01759_암호만들기 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int L;
	static int C;
	static char[] passwords;
	public static void main(String[] args) throws IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		passwords = new char[C];
		
		tokens = new StringTokenizer(reader.readLine());
		for (int i = 0; i < C; i++) {
			passwords[i] = tokens.nextToken().charAt(0);
		}
		// input
		Arrays.sort(passwords);
		permutation(0, 0, new char[L], 0);
		System.out.print(output);
	}
	static StringBuilder output = new StringBuilder();
	static void permutation(int cnt, int vCnt, char[] seleted, int bitmask) {
		if (cnt == L) {
			if (vCnt > 0 && cnt - vCnt > 1) {
//				System.out.println(Arrays.toString(seleted));
				for (int i = 0; i < seleted.length; i++) {
					output.append(seleted[i]);
				}
				output.append("\n");
			}
			return;
		}
		
		for (int i = 0; i < C; i++) {
			if ((bitmask & 1 << i) == 0) {
				seleted[cnt] = passwords[i];
				if (cnt == 0 || cnt > 0 && seleted[cnt] > seleted[cnt - 1]) {
					if (isVowel(seleted[cnt])) {
						permutation(cnt + 1, vCnt + 1, seleted, bitmask | 1 << i);
					} else {
						permutation(cnt + 1, vCnt, seleted, bitmask | 1 << i);
					}
				}
				
			}
		}
	}
	
	static boolean isVowel (char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	static String str = "3 6\r\n" + 
			"a t c i s w";
}


// 조합으로 모든 경우의 수를 찾는다
// 모음의 수를 체크
// 자음의 수를 체크?
// 들어가면서 최소의 수 이상이 될 수 있도록!!