import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/25330
 * @performance 11648	80
 * @category DFS
 * @memo
 */

public class BJ_G4_25330_SHOWMETHEDUNGEON{
	static class Town implements Comparable<Town>{
		int Moster;
		int person;
		public Town(int moster, int person) {
			super();
			Moster = moster;
			this.person = person;
		}
		@Override
		public String toString() {
			return "Town [Moster=" + Moster + ", person=" + person + "]";
		}
		@Override
		public int compareTo(Town o) {
			return Integer.compare(Moster, o.Moster);
		}
		
	}
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int K;
	static Town[] towns;
	public static void main(String[] args) throws IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokensA = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokensA.nextToken());
		K = Integer.parseInt(tokensA.nextToken());
		
		towns = new Town[N];
		tokensA = new StringTokenizer(reader.readLine());
		StringTokenizer tokensB = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			towns[i] = new Town(Integer.parseInt(tokensA.nextToken()), Integer.parseInt(tokensB.nextToken()));
		}
		
		Arrays.sort(towns);
		
		DFS(0, K, 0, 0, 0);
		System.out.println(result);
	}
	
	static int result = 0;
	private static void DFS(int cnt, int k, int persons, int damage, int bitmask) {
		if (cnt == N) {
			result = Math.max(result, persons);
			return;
		}
		if (0 > k)
			return;
		if (0 <= k)
			result = Math.max(result, persons);
		for(int i = 0; i < towns.length; i++) {
			if ((bitmask & 1 << i) == 0 && towns[i].Moster <= k) {
				DFS(cnt + 1, k - (damage + towns[i].Moster), persons + towns[i].person, damage + towns[i].Moster, bitmask | 1 << i);
			}
		}
	}

	static String str = "5 100\r\n" + 
			"1 1 1 1 1\r\n" + 
			"10 10 10 10 10";
}
