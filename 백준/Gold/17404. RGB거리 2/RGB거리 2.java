import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static final int R = 1;
	static final int G = 2;
	static final int B = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//reader = new BufferedReader(new StringReader(str));
		int N = Integer.parseInt(reader.readLine());
		
		
		int[][] homes = new int[N + 1][4];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			homes[i][1] = Integer.parseInt(tokens.nextToken());
			homes[i][2] = Integer.parseInt(tokens.nextToken());
			homes[i][3] = Integer.parseInt(tokens.nextToken());
		}
		
		int[][] Rhomes = new int[N + 1][4];
		int[][] Ghomes = new int[N + 1][4];
		int[][] Bhomes = new int[N + 1][4];
		
		Rhomes[1][R] = homes[1][R];
		Ghomes[1][G] = homes[1][G];
		Bhomes[1][B] = homes[1][B];
		
		Rhomes[1][G] = Rhomes[1][B] = Ghomes[1][R] = Ghomes[1][B] = Bhomes[1][G] = Bhomes[1][R] = 1_000_001;
		
		for (int i = 2; i <= N; i++) {
			Rhomes[i][R] = Math.min(Rhomes[i - 1][G], Rhomes[i - 1][B]) + homes[i][R];
			Rhomes[i][G] = Math.min(Rhomes[i - 1][R], Rhomes[i - 1][B]) + homes[i][G];
			Rhomes[i][B] = Math.min(Rhomes[i - 1][R], Rhomes[i - 1][G]) + homes[i][B];
			Ghomes[i][R] = Math.min(Ghomes[i - 1][G], Ghomes[i - 1][B]) + homes[i][R];
			Ghomes[i][G] = Math.min(Ghomes[i - 1][R], Ghomes[i - 1][B]) + homes[i][G];
			Ghomes[i][B] = Math.min(Ghomes[i - 1][R], Ghomes[i - 1][G]) + homes[i][B];
			Bhomes[i][R] = Math.min(Bhomes[i - 1][G], Bhomes[i - 1][B]) + homes[i][R];
			Bhomes[i][G] = Math.min(Bhomes[i - 1][R], Bhomes[i - 1][B]) + homes[i][G];
			Bhomes[i][B] = Math.min(Bhomes[i - 1][R], Bhomes[i - 1][G]) + homes[i][B];
		}
		
		int resultR = Math.min(Rhomes[N][G], Rhomes[N][B]);
		int resultG = Math.min(Ghomes[N][R], Ghomes[N][B]);
		int resultB = Math.min(Bhomes[N][R], Bhomes[N][G]);
		
		
		int result = Math.min(resultR, Math.min(resultG, resultB));
		System.out.println(result);
		
	}
	
	static String str = "8\n"
			+ "71 39 44\n"
			+ "32 83 55\n"
			+ "51 37 63\n"
			+ "89 29 100\n"
			+ "83 58 11\n"
			+ "65 13 15\n"
			+ "47 25 29\n"
			+ "60 66 19";
}