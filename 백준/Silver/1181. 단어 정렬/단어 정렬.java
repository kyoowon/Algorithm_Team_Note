import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1181
 * @performance
 * @category 문자열
 * @memo 제출 x 
 */

public class Main {
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// reader = new BufferedReader(new StringReader(str));
		int N = Integer.parseInt(reader.readLine());
		
		String[] input = new String[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = reader.readLine();
		}
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return Integer.compare(o1.length(), o2.length());
			}
		});
		String tmp = "";
		for (String st : input) {
			if (!tmp.equals(st)) {
				output.append(st).append("\n");
				tmp = st;
			}
		}
		System.out.print(output);
	}
	static String str = "13\r\n" + 
			"but\r\n" + 
			"i\r\n" + 
			"wont\r\n" + 
			"hesitate\r\n" + 
			"no\r\n" + 
			"more\r\n" + 
			"no\r\n" + 
			"more\r\n" + 
			"it\r\n" + 
			"cannot\r\n" + 
			"wait\r\n" + 
			"im\r\n" + 
			"yours";
}