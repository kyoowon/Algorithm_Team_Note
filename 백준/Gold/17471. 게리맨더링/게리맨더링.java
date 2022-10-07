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
	static class Node{
		int persons;
		List<Integer> link;
		@Override
		public String toString() {
			return "Node [persons=" + persons + ", link=" + link + "]";
		}
	}
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Node[] towns;
	static int N;
	static int total = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		N = Integer.parseInt(reader.readLine());
		
		towns = new Node[N];
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		for (int i = 0; i < N; i++) {
			towns[i] = new Node();
			towns[i].link = new ArrayList<Integer>(); 
			towns[i].persons = Integer.parseInt(tokens.nextToken());
			total += towns[i].persons;
		}
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(reader.readLine());
			int T = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j < T; j++)
				towns[i].link.add(Integer.parseInt(tokens.nextToken()) - 1);
		}
		
		System.out.println(BinaryCount());
	}
	private static int BinaryCount() {
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < 1 << N; i++) {
			int subA = -2;
			int subB = -2;
			boolean[] visited = new boolean[N];
			for(int t = 0; t < N; t++) {
				if (!visited[t] && (i & 1 << t) > 0 && subA == -2) { // 방문하지 않았는데 A가 갈 수 있는 지역이 있는 경우 - 딱 한번만 들어감
					subA = BFS(t, i, visited);
				}
				if (!visited[t] && (i & 1 << t) == 0 && subB == -2) { // 방문하지 않았는데 B가 갈 수 있는 지역이 있는 경우 - 딱 한번만 들어감
					subB = BFS(t, ~i, visited);
				}
				if (subA > -2 && subB > -2)
					break;
			}
			if (subA > 0 && subB > 0) {
				result = Math.min(result, Math.abs(subA - subB));
			}
		}
		if (result != Integer.MAX_VALUE)
			return result;
		return -1;
	}
	private static int BFS(int start, int canGo, boolean[] visited) {
		int persons = towns[start].persons;
		Queue<Node> q = new LinkedList<>();
		q.add(towns[start]);
		visited[start] = true;
		while(!q.isEmpty()){
			Node node = q.poll();
			for (int town : node.link) {
				if (((canGo & 1 << town) > 0) && !visited[town]) {
					visited[town] = true;
					persons += towns[town].persons;
					q.add(towns[town]);
				}
			}
		}
		
		int result = -1;
		for (int i = 0; i < N; i++) { // 확인 갈 수 있는 지역인데 방문을 못한 경우
			if (((canGo & 1 << i) > 0) && !visited[i]) {
				return result;
			}
		}	
		return persons;
	}
	static String str = "6\r\n" + 
			"5 2 3 4 1 2\r\n" + 
			"2 2 4\r\n" + 
			"4 1 3 6 5\r\n" + 
			"2 4 2\r\n" + 
			"2 1 3\r\n" + 
			"1 2\r\n" + 
			"1 2";
}