import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSort {
	static int N;
	static int E;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		int[] indegree = new int[N + 1];
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<Integer>());
		
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(reader.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		TopologicalSort(indegree, graph);
	}
	private static void TopologicalSort(int[] indegree, List<List<Integer>> graph) {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();
		
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);
			
			for (Integer i : graph.get(node)) {
				indegree[i]--;
				
				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		System.out.println(result);
	}
	static String str = "7 9\n"+	
			"1 2\n"+
			"1 3\n"+
			"2 5\n"+
			"4 6\n"+
			"3 4\n"+
			"3 7\n"+
			"5 6\n"+
			"2 4\n"+
			"5 4";
}
