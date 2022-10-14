package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_S3_10974_모든순열 {
	static int N;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine());
		
		int[] numbers = new int[N];
		
		for(int i = 1; i <= N; i++)
			numbers[i - 1] = i;
		
		do {
			for(int nbr : numbers)
				output.append(nbr).append(" ");
			output.append("\n");
		}while(NextPermutation(numbers));
		
		System.out.print(output);
	}

	private static boolean NextPermutation(int[] numbers) {
		
		int i = N - 1;
		
		while(i > 0 && numbers[i - 1] >= numbers[i]) i--;
		
		if (i == 0) return false;
		
		int j = N - 1;
		
		while (numbers[i - 1] >= numbers[j]) j--;
		
		swap(numbers, i - 1, j);
		int k = N - 1;
		while(i < k) swap(numbers, i++, k--);
		
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
}
