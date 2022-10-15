import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_G4_09252_LCS2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		String A = reader.readLine();
		String B = reader.readLine();

		int aSize = A.length();
		int bSize = B.length();

		int[][] dp = new int[aSize + 1][bSize + 1];

		for (int i = 1; i <= aSize; i++) {
			for (int j = 1; j <= bSize; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int nx = aSize;
		int ny = bSize;
		int minValue = dp[nx][ny];
		// 3. 문자열 구하기
		while (nx != 0 && ny != 0) {
			if (A.charAt(nx - 1) == B.charAt(ny - 1)) {
				output.insert(0, A.charAt(nx - 1));
				nx--;
				ny--;
			} else if (dp[nx][ny] == dp[nx - 1][ny]) {
				nx--;
			} else if (dp[nx][ny] == dp[nx][ny - 1]) {
				ny--;
			}
		}

		System.out.println(dp[aSize][bSize]);
		if (dp[aSize][bSize] != 0)
			System.out.println(output);
	}

	static boolean inIn(int dx, int dy, int N, int M) {
		return 0 <= dx && dx <= N && 0 <= dy && dy <= M;
	}
}
