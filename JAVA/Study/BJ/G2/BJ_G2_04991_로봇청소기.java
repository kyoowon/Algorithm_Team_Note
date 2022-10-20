import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/4991
 * @performance 64544	336
 * @category BFS - bitmask
 * @memo
 */

public class BJ_G2_04991_로봇청소기 {
	
	static class Node{
		int x;
		int y;
		int cnt;
		int depth;
		public Node(int x, int y, int cnt, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + ", depth=" + depth + "]";
		}
	}
	
	static int N;
	static int M;
	static int[][] maps;
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		// reader = new BufferedReader(new StringReader(str));
		
		while (true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			
			if(N + M == 0) break;
			
			maps = new int[N][M];
			
			Node start = null;
			
			int dust = 0;
			for(int r = 0; r < N; r++) {
				String inputs = reader.readLine();
				for (int c = 0; c < M; c++) {
					char space = inputs.charAt(c);
					if ('o' == space) {
						start = new Node(r, c, 0, 0);
						maps[r][c] = -1;
					}else if ('*' == space) {
						maps[r][c] = dust++;
					}else if ('x' == space) {
						maps[r][c] = -2;
					}else {
						maps[r][c] = -1;
					}
				}
			}
			output.append(BFS(start, dust)).append('\n');
		}
		System.out.print(output);
	}

	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	private static int BFS(Node start, int dust) {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][1 << dust];
		q.add(start);
		visited[start.x][start.y][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if (node.depth + 1 == 1 << dust) {
				return node.cnt;
			}
			for(int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if(isIn(nx, ny) && maps[nx][ny] != -2) {
					if (maps[nx][ny] == -1 && !visited[nx][ny][node.depth]) {
						visited[nx][ny][node.depth] = true;
						q.add(new Node(nx, ny, node.cnt + 1, node.depth));
					}else if (maps[nx][ny] >= 0 && !visited[nx][ny][(node.depth | 1 << maps[nx][ny])]) {
						visited[nx][ny][(node.depth | 1 << maps[nx][ny])] = true;
						q.add(new Node(nx, ny, node.cnt + 1, (node.depth | 1 << maps[nx][ny])));
					}
				}
			}
		}
		return -1;
	}


	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "7 5\r\n" + 
			".......\r\n" + 
			".o...*.\r\n" + 
			".......\r\n" + 
			".*...*.\r\n" + 
			".......\r\n" + 
			"15 13\r\n" + 
			".......x.......\r\n" + 
			"...o...x....*..\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			"...............\r\n" + 
			"xxxxx.....xxxxx\r\n" + 
			"...............\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			"..*....x....*..\r\n" + 
			".......x.......\r\n" + 
			"10 10\r\n" + 
			"..........\r\n" + 
			"..o.......\r\n" + 
			"..........\r\n" + 
			"..........\r\n" + 
			"..........\r\n" + 
			".....xxxxx\r\n" + 
			".....x....\r\n" + 
			".....x.*..\r\n" + 
			".....x....\r\n" + 
			".....x....\r\n" + 
			"0 0";
}
