import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;


/**
 * @author kyulee
 * @link
 * @performance 11960	188
 * @category
 * @memo
 */
public class BJ_G4_01062_가르침{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static final int DEF = 532741;
	static int N;
	static int K;
	static int[] words;
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		words = new int[N];
		int type = DEF;
		for (int n = 0; n < N; n++) {
			String input = reader.readLine();
			int num = DEF; // a / n / t / i / c
			for (int k = 4; k < input.length() - 4; k++) {
				char c = input.charAt(k);
				num |= 1 << c - 'a';
				type |= 1 << c - 'a';
			}
			words[n] = num;
		}
		if (K >= 5) {
			combination(5, DEF, 0, type);			
			System.out.println(result);
		}
		else
			System.out.println(0);
	}
	
	static int result = 0;
	private static void combination(int cnt, int selected , int start, final int type) {
		result = Math.max(result, countAlpa(selected));
		if (cnt == K) {
			return;
		}
		for (int a = start; a <= 26; a++) {
			if ((type & 1 << a) > 0 && (selected & 1 << a) == 0) {
				combination(cnt + 1, selected | 1 << a, a + 1, type);
			}
		}
	}
	
	
	private static int countAlpa(int selected) {
		int count = 0;
		for(int word : words) {
			if ((word & selected) == word) count++;
		}
		
		return count;
	}

	static String str = "1 7\r\n" + 
			"antabbtica";
}
