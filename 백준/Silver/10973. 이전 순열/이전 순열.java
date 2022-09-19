import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(tokens.nextToken());
		boolean result = NextPermutation(numbers);
		
		if (result) {
			for (int nbr : numbers) {
				output.append(nbr).append(" ");
			}
		}else {
			output.append(-1);
		}
		System.out.println(output);
	}

	private static boolean NextPermutation(int[] numbers) {
		
		int i = N - 1;
		
		while(i > 0 && numbers[i - 1] <= numbers[i]) i--;
		
		if(i == 0)return false;
		
		int j = N - 1;
		while(numbers[i - 1] <= numbers[j]) j--;
		
		swap(numbers, i - 1, j);
		int k = N - 1;
		while(i < k) swap(numbers, i++, k--);
		
		return true;
	}
	
	static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}