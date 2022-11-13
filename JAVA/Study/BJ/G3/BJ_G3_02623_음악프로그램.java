import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_02623_음악프로그램 {
	static int N;
	static int M;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int n = 0; n <= N; n++) {
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int[N + 1];
		for(int m = 0; m < M; m++) {
			tokens = new StringTokenizer(reader.readLine());
			int S = Integer.parseInt(tokens.nextToken());
			int pre = Integer.parseInt(tokens.nextToken());
			for (int s = 0; s < S - 1; s++) {
				int next = Integer.parseInt(tokens.nextToken());
				graph.get(pre).add(next);
				indegree[next]++;
				pre = next;
			}
		}
		
		
		System.out.println(topologySort(graph, indegree));
	}

	private static String topologySort(List<ArrayList<Integer>> graph, int[] indegree) {
		// TODO Auto-generated method stub
		Queue<Integer> result = new LinkedList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int n = 1; n <= N; n++) {
			if (indegree[n] == 0) {
				q.add(n);
			}
		}
//		System.out.println(Arrays.toString(indegree));
//		System.out.println(q);
		int cnt = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			cnt++;
			output.append(node).append('\n');
			for(int next : graph.get(node)) {
				if(--indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		if (cnt == N)
			return output.toString();
		
		return "0";
	}
}
