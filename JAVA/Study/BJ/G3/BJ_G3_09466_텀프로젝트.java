import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G3_09466_텀프로젝트 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			
			int[] students = new int[N + 1];
			for(int n = 1; n <= N; n++) {
				students[n] = Integer.parseInt(tokens.nextToken());
			}
			
			int[] visited = new int[N + 1];
			
			int cnt = 1;
			for (int n = 1; n <= N; n++) {
				if (visited[n] == 0) {
					dfs(n, cnt++, visited, students);
				}
			}
			
			int result = 0;
//			System.out.println(Arrays.toString(visited));
//			System.out.println(Arrays.toString(students));
			for(int n = 1; n <= N; n++) {
				if(students[n] != 0) {
					result++;
				}
			}
			output.append(result).append('\n');
		}
		System.out.print(output);
	}
	private static void dfs(int pre, int group, int[] visited, int[] students) {
		visited[pre] = group;
		int next = students[pre];
		if(visited[next] == group) { // 사이클 발생.
			zerodfs(next, students);
			return;
		}
		if(visited[next] == 0) { // 다른 그룹에 속하지 않는 경우.
			dfs(next, group, visited, students);
		}
	}
	private static void zerodfs(int pre, int[] students) {
		int next = students[pre];
		students[pre] = 0;
		if (students[next] == 0)
			return;
		zerodfs(next, students);
	}
}
