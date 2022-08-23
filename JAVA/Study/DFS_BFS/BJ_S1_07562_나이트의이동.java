import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_07562_나이트의이동 {
	static class Node{
		int x;
		int y;
		int count;
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		int T = Integer.parseInt(reader.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(reader.readLine());
			
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			Node start = new Node(x, y, 0);
			
			tokens = new StringTokenizer(reader.readLine());
			int tx = Integer.parseInt(tokens.nextToken());
			int ty = Integer.parseInt(tokens.nextToken());
			Node target = new Node(tx, ty, 0);
			
			output.append(BFS(start, target, N)).append("\n");
		}
		System.out.print(output);
	}
	static int[][] deltas = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	private static int BFS(Node start, Node target, final int N) {
		int count = 0;
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(start);
		visited[start.x][start.y] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == target.x && node.y == target.y) {
				return node.count;
			}
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				
				if (isIn(nx, ny, N) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny, node.count + 1));
				}
			}
		}
		
		return 0;
	}

	private static boolean isIn(int nx, int ny, int N) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
	static String str = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1";
}

// solutions
// 나이트는 8방 탐색이 가능
// BFS탐색을 통해서 탐색