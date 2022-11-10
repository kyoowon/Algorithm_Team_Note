import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_20040_사이클게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int[] parent = new int[N];
		
		for (int n = 0; n < N; n++)
			parent[n] = n;
		
		int result = 0;
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			if (!unionParent(a, b, parent)) {
				result = m + 1;
				break;
			}
		}
		System.out.println(result);
	}

	
	private static boolean unionParent(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		
		if (a == b)
			return false;
		
		if (a > b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
		return true;
	}


	private static int findParent(int a, int[] parent) {
		if (a != parent[a])
			parent[a] = findParent(parent[a], parent);
		return parent[a];
	}
}
