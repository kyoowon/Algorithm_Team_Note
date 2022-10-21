import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/1978
 * @performance 	11580	80
 * @category 에라스토테네스의 체
 * @link
 */

public class BJ_S5_01978_소수찾기 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(reader.readLine());
		
		int result = 0;
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		for (int n = 0; n < N; n++) {
			int nbr = Integer.parseInt(tokens.nextToken());
			if (isPrime(nbr)) {
				result++;
			}
		}
		System.out.println(result);
	}
	private static boolean isPrime(int nbr) {
		if (nbr == 1) return false;
		for (int i = 2; i <= Math.sqrt(nbr); i++) {
			if (nbr % i == 0) {
				return false;
			}
		}
		return true;
	}
}
