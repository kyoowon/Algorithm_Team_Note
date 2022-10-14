package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_10819_차이를최대로 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;

	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));

		N = Integer.parseInt(reader.readLine());

		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}

		int result = Integer.MIN_VALUE;

		Arrays.sort(numbers);
		
		do {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(numbers[i] - numbers[i + 1]);
			}
			result = Math.max(sum, result);
		} while (NextPermutation(numbers));
		System.out.println(result);
	}

	private static boolean NextPermutation(int[] numbers) {

		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			j--;

		swap(numbers, i - 1, j);

		int k = N - 1;

		while (i < k)
			swap(numbers, i++, k--);

		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	static String str = "6\r\n" + "20 1 15 8 4 10";
}
