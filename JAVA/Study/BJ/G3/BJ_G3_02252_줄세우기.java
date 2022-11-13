import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_02252_줄세우기 {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
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
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			graph.get(A).add(B);
			indegree[B]++;
		}
		
		Queue<Integer> result = TopologySort(graph, indegree);
		
		while(!result.isEmpty()) {
			output.append(result.poll()).append(' ');
		}
		System.out.println(output);
	}
	private static Queue<Integer> TopologySort(List<ArrayList<Integer>> graph, int[] indegree) {
		Queue<Integer> result = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int n = 1; n <= N; n++) {
			if(indegree[n] == 0) {
				q.add(n);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			result.add(node);
			for(int next : graph.get(node)) {
				if(--indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		return result;
	}
}
