import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/9205
 * @performance 	12660	108
 * @category BFS
 * @memo
 */

public class BJ_S1_09205_맥주마시면서걸어가기 {
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean BFS(Node start, Node end, Node[] market) {
		Queue<Node> q = new LinkedList<>();
		boolean visited[] = new boolean[market.length];
		q.add(start);
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (canGoing(node, end)) {
				return true;
			}
			for (int i = 0; i < market.length; i++) {
				if (!visited[i] && canGoing(node, market[i])) {
					visited[i] = true;
					q.add(market[i]);
				}
			}
		}
		return false;
	}
	
	static boolean canGoing(Node start, Node point) {
		return Math.abs(point.x - start.x) + Math.abs(point.y - start.y) <= 1000;
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int t = 1; t <= T; t++) {
			int S = Integer.parseInt(reader.readLine());
			Node[] market = new Node[S];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			Node home = new Node(x, y);
			for (int s = 0; s < S; s++) {
				tokens = new StringTokenizer(reader.readLine());
				x = Integer.parseInt(tokens.nextToken());
				y = Integer.parseInt(tokens.nextToken());
				market[s] = new Node(x, y);
			}
			tokens = new StringTokenizer(reader.readLine());
			x = Integer.parseInt(tokens.nextToken());
			y = Integer.parseInt(tokens.nextToken());
			Node end = new Node(x, y);
			if (BFS(home, end, market)) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static String str = "2\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"1000 1000\r\n" + 
			"2000 1000\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"2000 1000\r\n" + 
			"2000 2000";
}