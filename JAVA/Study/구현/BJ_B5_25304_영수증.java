import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B5_25304_영수증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(reader.readLine());
		
		int N = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			
			X -= A * B;
			
		}
		if (X == 0) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
