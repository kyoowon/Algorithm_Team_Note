import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/14499
 * @performace 11896	84
 * @category implements
 * @memo
 */

public class BJ_G4_14499_주사위굴리기 {
	static class Dice{
		int x;
		int y;
		int[] nbrs; // 0 : 아래, 1 : 상, 2 : 위, 3 : 하, 4 : 왼, 5 : 오
		
		// 동 회전 , 서 회전, 북 회전, 남 회전
		static int[][] orders = {{}, {5, 3, 4, 1}, {4, 3, 5, 1}, {2, 3, 0, 1}, {0, 3, 2, 1}};
		
		public Dice(int x, int y, int[] nbrs) {
			super();
			this.x = x;
			this.y = y;
			this.nbrs = nbrs;
		}
		
		public void rotate(int d) {
			int pre = nbrs[orders[d][0]];
			for (int o = 1; o < orders[d].length; o++) {
				int next = nbrs[orders[d][o]];
				nbrs[orders[d][o]] = pre;
				pre = next;
			}
			nbrs[orders[d][0]] = pre;
		}
			
		public int getBotton() {
			return nbrs[3];
		}
		
		public void setBotton(int v) {
			nbrs[3] = v;
		}
		
		public int getTop() {
			return nbrs[1];
		}
		
		@Override
		public String toString() {
			return "Dice [x=" + x + ", y=" + y + ", nbrs=" + Arrays.toString(nbrs) + "]";
		}
	}
	
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static int M;
	static int[][] graph;
	static int[][] deltas = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; //동 서 북 남
	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		
		int x = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		Dice dice = new Dice(x, y, new int[6]);
				
		graph = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < M; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(reader.readLine());
		for(int k = 0; k < K; k++) {
			int move = Integer.parseInt(tokens.nextToken());
			
			int nx = dice.x + deltas[move][0];
			int ny = dice.y + deltas[move][1];
			
			if (isIn(nx, ny)) {
				dice.x = nx;
				dice.y = ny;
				dice.rotate(move);
				output.append(dice.getTop()).append('\n');
				if (graph[nx][ny] == 0) {
					graph[nx][ny] = dice.getBotton();
				}else {
					dice.setBotton(graph[nx][ny]);
					graph[nx][ny] = 0;
				}
			}
		}
		
		System.out.print(output);
	}
	
	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}
	
	static String str = "3 3 0 0 16\r\n" + 
			"0 1 2\r\n" + 
			"3 4 5\r\n" + 
			"6 7 8\r\n" + 
			"4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2";
}
