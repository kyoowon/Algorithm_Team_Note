import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author LIS - DP
 * @memo 이는 시간 복잡도가 공차가 1인 등차수열의 합만큼의 시간복잡도를 가진다. O(n^2)
 *
 */

public class LIS {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder outputDP = new StringBuilder();
	static StringBuilder outputB = new StringBuilder();

	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		int N = Integer.parseInt(reader.readLine());
		int[] arr = new int[N];

		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}

		System.out.println(LisDp(N, arr));
		System.out.println(LisBinary(N, arr));
	}

	static int LisDp(final int N, final int[] nums) {
		int max = 0;
		int maxIdx = -1;
		int[] lis = new int[N];
		int[] path = new int[N];
		for (int i = 0; i < N; i++) {
			path[i] = -1;
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					path[i] = j;
				}
				if (max < lis[i]) {
					max = lis[i];
					maxIdx = i;
				}
			}
		}
		Stack<Integer> stack = new Stack<>();
		int i = maxIdx;
		while (i != -1) {
			stack.push(nums[i]);
			i = path[i];
		}
		while (!stack.isEmpty())
			outputDP.append(stack.pop()).append(" ");
		System.out.println(outputDP);
		return max;
	}

	static int LisBinary(final int N, final int[] nums) {
		int[][] lis = new int[N][2]; // 0 : 값, 1 : 인덱스 위치
		int[] path = new int[N];
		int size = 0;
		for (int i = 0; i < N; i++) {
			path[i] = -1;
			int pos = binarySearch(lis, 0, size, nums[i]);

			if (pos >= 0)
				continue;

			int insertPos = Math.abs(pos) - 1; // 맨뒤 또는 기존원소 대체 자리
			
			if (insertPos != 0)
				path[i] = lis[insertPos - 1][1]; // 이전 값 저장
			lis[insertPos][0] = nums[i]; // 해당 값
			lis[insertPos][1] = i; // 해당 인덱스
			if (insertPos == size)
				size++;
		}
		Stack<Integer> stack = new Stack<>();
		int i = lis[size - 1][1];
		while (i != -1) {
			stack.push(nums[i]);
			i = path[i];
		}
		while (!stack.isEmpty())
			outputB.append(stack.pop()).append(" ");
		System.out.println(outputB);
		return size;
	}

	private static int binarySearch(int[][] a, int fromIndex, int toIndex, Object key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			Comparable midVal = (Comparable) a[mid][0];
			int cmp = midVal.compareTo(key);

			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	static String str = "10\r\n" + "1 100 2 50 60 3 5 6 7 8";
}
