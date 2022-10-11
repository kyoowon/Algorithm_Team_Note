import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/14226
 * @performance 	17780	96
 * @category BFS + DP
 * @memo 방문한 경우를 2차원으로 체크
 */

public class BJ_G4_14226_이모티콘 {
	static class Node{
		int n;
		int copy;
		int cnt;
		public Node(int n, int copy, int cnt) {
			super();
			this.n = n;
			this.copy = copy;
			this.cnt = cnt;
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		
		System.out.println(BFS());
	}
	
	private static int BFS() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[2001][2001];
		int result = 0;
		q.add(new Node(2, 1, 2));
		while(!q.isEmpty()) {
			Node node = q.poll();
			if (visited[node.n][node.copy]) continue;
			visited[node.n][node.copy]  = true;
			if (node.n == N)
				return node.cnt;
			if (node.n > 0 && node.n < 2000)
				q.add(new Node(node.n - 1, node.copy, node.cnt + 1));
			if (node.copy != node.n)
				q.add(new Node(node.n, node.n, node.cnt + 1));
			if (node.copy > 0 && node.n + node.copy < 2000)
				q.add(new Node(node.n + node.copy, node.copy, node.cnt + 1));
			
		}
		return result;
	}
}
