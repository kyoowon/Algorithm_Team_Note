import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		//reader = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int V = Integer.parseInt(tokens.nextToken());
			int E = Integer.parseInt(tokens.nextToken());
			
			int[] colors = new int[V + 1];
			
			ArrayList<Integer>[] graph = new ArrayList[V + 1];
			
			for (int v = 0; v <= V; v++) {
				graph[v] = new ArrayList<Integer>();
			}
			for (int e = 0; e < E; e++) {
				tokens = new StringTokenizer(reader.readLine());
				int A = Integer.parseInt(tokens.nextToken());
				int B = Integer.parseInt(tokens.nextToken());
				graph[A].add(B);
				graph[B].add(A);
			}
//			for (ArrayList<Integer> row : graph)
//				System.out.println(row);
			
			boolean[] visited = new boolean[V + 1];
			boolean flag = false;
			for (int v = 1; v <= V; v++) {
				if (!visited[v]) {
					if (!bfs(v, graph, colors, visited)) {
						flag = true;
						break;
					}
				}
			}
			if (flag)
				output.append("NO").append("\n");
			else
				output.append("YES").append("\n");
		}
		System.out.print(output);
	}
	
	private static boolean bfs(int v, final ArrayList<Integer>[] graph, int[] colors, boolean[] visited) {
		visited[v] = true;
		colors[v] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while (!q.isEmpty()) {
			int vertex = q.poll();
			for (int node : graph[vertex]) {
				if (colors[node] == 0 && !visited[node]) {
					visited[node] = true;
					colors[node] = colors[vertex] * -1;
					q.add(node);
				}else if (colors[node] == colors[vertex]) {
					return false;
				}
			}
		}
		return true;
	}

	static String str = "1\r\n" + 
			"4 4\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"4 2";
}

// 이분 그래프란?
// 이분 그래프의 성질로는 같은 레벨에 노드의 경우에는 같은 색을 가지고 있어야 함.