import java.util.Arrays;
import java.util.Scanner;

public class 순열_조합_부분집합 {
	static int N, R, total;
	static int[] numbers, input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
		System.out.println("총 경우의 수 : " + total);
		System.out.println();
		total = 0;
		
		Arrays.sort(input);
		
		System.out.println("next Permutation");
		do {
			System.out.println(Arrays.toString(input));
		}while(NextPermutation(input));
		System.out.println();
		combination(0, 0);
		System.out.println("총 경우의 수 : " + total);
		System.out.println();
		
		
		System.out.println("next combination");
		int[] newInput = new int[N];
		for (int i = N - 1; i >= N - R; i--) {
			newInput[i] = 1;
		}
		do {
			System.out.println(Arrays.toString(newInput));
			for (int i = 0; i < N; i++) {
				if (newInput[i] == 1) System.out.print(input[i] + " ");
			}
			System.out.println();
		}while(NextPermutation(newInput));
		System.out.println();
		
		
		total = 0;
		permutationDup(0);
		System.out.println("총 경우의 수 : " + total);
		System.out.println();
		total = 0;
		combinationDup(0, 0);
		System.out.println("총 경우의 수 : " + total);
		System.out.println();
		
		total = 0;
		SubSet(0);
		System.out.println("총 경우의 수 : " + total);
		System.out.println();
		BinarySubSet();
	}
	
	// 순열 - 순열은 서로 다른 것들 중 중복을 허용하지 않고 몇 개를 뽑아서 한줄로 나열하는 것을 의미한다.
	
	/**
	 * @param cnt : 직전까지 뽑는 순열에 포함된 수의 개수, cnt + 1번째 해당하는 순열에 포함될 수를 뽑기
	 * @return
	 */
	
	static void permutation(int cnt) {
		if(cnt == R) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도
		for(int i = 0; i < N; i++) {
			// 시도하는 수가 선택되었는지 판단
			if(isSelected[i]) continue;
			//선택되지 않았다면 수를 사용.
			isSelected[i] = true;
			numbers[cnt] = input[i];
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	static void permutationDup(int cnt) {
		if(cnt == R) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도
		for(int i = 0; i < N; i++) {
			numbers[cnt] = input[i];
			permutation(cnt + 1);
		}
	}
	
	static boolean NextPermutation(int[] numbers) { // numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열 존재하면 true, 아니면 false
		
		int N = numbers.length;
		
		// 1. 꼭대기 찾기 - 맨 뒤부터 시작
		int i = N - 1;
		while(i > 0 && numbers[i  - 1] >= numbers[i]) --i;
		
		if (i == 0) return false; // 다음 순열을 만들 수 없는 이미 가장 큰 순열의 상태
		
		// 2. 꼭대기의 바로 앞자리(i - 1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
		
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j;
		
		swap(numbers, i - 1, j);
		
		// 3. i - 1위치값과 j 위치 값을 교환
		int k = N - 1;
		while (i < k) swap(numbers, i++, k--);
		return true;
	}
	
	static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
	
	// 조합 - 서로 다른 n개의 원소 중 r개를 순서없이 골라낸 것을 조합이라고 한다.
	/**
	 * @param cnt
	 * @param start 다음 익덱스에서 접근할 수 있도록
	 */
	
	static void combination(int cnt, int start) {
		if(cnt == R) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	static void combinationDup(int cnt, int start) {
		if(cnt == R) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i);
		}
	}
	
	static void SubSet(int cnt) {
		if (cnt == N) {
			total++;
			for(int i = 0; i < N; i++) {
				if (isSelected[i]) System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		isSelected[cnt] = true;
		SubSet(cnt + 1);
		isSelected[cnt] = false;
		SubSet(cnt + 1);
	}
	
	static void BinarySubSet() {
		for (int flag = 0, caseCnt = 1 << N; flag < caseCnt; flag++) { // 모든 가능한 비트열의 상황에 대해 처리
			for (int i = 0; i < N; i++) {
				if((flag & (1 << i)) != 0){
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		}
	}
	
}
