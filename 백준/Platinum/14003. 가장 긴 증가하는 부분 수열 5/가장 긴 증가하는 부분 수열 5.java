import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(reader.readLine());

		int[] nums = new int[N];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}

		int size = 0;
		int[] path = new int[N]; // , 이전의 위치 1
		int[][] C = new int[N][2]; // 0, 값 1. 인덱스

		for (int i = 0; i < N; i++) {
			path[i] = -1;
			int pos = binarySearch(C, 0, size, nums[i]);
			if (pos >= 0)
				continue; // 이미 그 원소가 존재하는 경우

			int insertPos = Math.abs(pos) - 1; // 삽입할 위치 (기존의 위치를 더 작은 값으로 대체)

			if (size == insertPos) {// 맨 뒤에 삽입하는 경우
				size++;
			}
			if (insertPos != 0) {				
				path[i] = C[insertPos - 1][1];
			}
			C[insertPos][0] = nums[i]; // 중간에 삽입
			C[insertPos][1] = i; // 중간에 삽입
		}

		Stack<Integer> stack = new Stack<>();
		int i = C[size - 1][1];
		while (i != -1) {
			stack.push(nums[i]);
			i = path[i];
		}
		output.append(size).append("\n");
		while (!stack.isEmpty())
			output.append(stack.pop()).append(" ");
		System.out.println(output);
	}

	private static int binarySearch(int[][] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid][0];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

}