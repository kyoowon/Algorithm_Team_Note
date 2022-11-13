import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G3_01005_ACMCraft {
	static class Node{
		int n;
		int total;
		public Node(int n, int total) {
			super();
			this.n = n;
			this.total = total;
		}
		@Override
		public String toString() {
			return "Node [n=" + n + ", paths=" + total + "]";
		}
	}
	
	static int N;
	static int K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		 reader = new BufferedReader(new StringReader(str));
		
		int T = Integer.parseInt(reader.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			int[] indegree = new int[N + 1];
			int[] costs = new int[N + 1];
			
			List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			
			for (int n = 0; n <= N; n++) {
				graph.add(new ArrayList<>());
			}
			
			tokens = new StringTokenizer(reader.readLine());
			for(int i = 1; i <= N; i++)
				costs[i] = Integer.parseInt(tokens.nextToken());
			
			for (int k = 0; k < K; k++) {
				tokens = new StringTokenizer(reader.readLine());
				int A = Integer.parseInt(tokens.nextToken());
				int B = Integer.parseInt(tokens.nextToken());
				graph.get(A).add(B);
				indegree[B]++;
			}
			
			int W = Integer.parseInt(reader.readLine());
			
			
			int result = TopologySort(graph, W, costs, indegree);
			output.append(result).append("\n");
		}
		System.out.print(output);
	}
	
	private static int TopologySort(List<ArrayList<Integer>> graph, int target, int[] costs, int[] indegree) {
		Queue<Node> q = new LinkedList<>();
		int[] preCostsTable = new int[N + 1];
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				if (i == target)
					return costs[i];
				q.add(new Node(i, costs[i]));
			}
		}
		
		while(true) {
			Node node = q.poll();
			for (Integer path : graph.get(node.n)) {
				preCostsTable[path] = Math.max(node.total, preCostsTable[path]);
				if (--indegree[path] == 0) {
					int current = preCostsTable[path] + costs[path];
					if(path == target) {
						return current;
					}
					q.add(new Node(path, current));
				}
			}
		}	
	}

	static String str = "5\n"
			+ "3 2\n"
			+ "1 2 3\n"
			+ "3 2\n"
			+ "2 1\n"
			+ "1\n"
			+ "4 3\n"
			+ "5 5 5 5\n"
			+ "1 2\n"
			+ "1 3\n"
			+ "2 3\n"
			+ "4\n"
			+ "5 10\n"
			+ "100000 99999 99997 99994 99990\n"
			+ "4 5\n"
			+ "3 5\n"
			+ "3 4\n"
			+ "2 5\n"
			+ "2 4\n"
			+ "2 3\n"
			+ "1 5\n"
			+ "1 4\n"
			+ "1 3\n"
			+ "1 2\n"
			+ "4\n"
			+ "4 3\n"
			+ "1 1 1 1\n"
			+ "1 2\n"
			+ "3 2\n"
			+ "1 4\n"
			+ "4\n"
			+ "7 8\n"
			+ "0 0 0 0 0 0 0\n"
			+ "1 2\n"
			+ "1 3\n"
			+ "2 4\n"
			+ "3 4\n"
			+ "4 5\n"
			+ "4 6\n"
			+ "5 7\n"
			+ "6 7\n"
			+ "7";
}