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
 * @link
 * @performance 121888	612
 * @category BFS
 * @memo
 */

public class BJ_G5_07576_토마토 {
	static class Tomato {
		int x;
		int y;
		int time;
		public Tomato(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Tomato [x=" + x + ", y=" + y + ", time=" + time + "]";
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];
		int zero = 0;
		Queue<Tomato> tomatos = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < M; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
				if (graph[r][c] == 0) zero++;
				else if (graph[r][c] == 1) {
					tomatos.add(new Tomato(r, c, 0));
					visited[r][c] = true;
				}
			}
		}
		
//		for (int[] row : graph)
//			System.out.println(Arrays.toString(row));
		// input
		
		if (zero == 0) {
			System.out.println(0);
		}else {
			System.out.println(BFS(tomatos, zero));
		}
		
	}
	
	static boolean[][] visited;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private static int BFS(Queue<Tomato> tomatos, int zero) {

		while(!tomatos.isEmpty()) {
			Tomato tomato = tomatos.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = tomato.x + deltas[d][0];
				int ny = tomato.y + deltas[d][1];
				
				if (isIn(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 0) {
					visited[nx][ny] = true;
					if (--zero == 0)
						return tomato.time + 1;
					tomatos.add(new Tomato(nx, ny, tomato.time + 1));
				}
			}
		}
		
		return -1;
	}
	
	static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "2 2\r\n" + 
			"1 -1\r\n" + 
			"-1 1";
}

// 익은 토마토 4방 탐색을 통해 익지 않는 토마토를 영향에 받게해서 익게 할 수 있다.
// 출력은 모든 토마토가 익을 날짜를 출력해야한다. 그러나 처음부터 모두 익어있었다면 0, 모두 익게 할 수 없다면 -1을 출력하라.

// solutions
// 익은 토마토에 대한 좌표를 입력과 동시에 받고 이때 zero 카운트!!
// 모든 좌표를 통시에 BFS를 돌린다.
// 돌리고 난 뒤에도 안익은 토마토가 있다면 -1, 다 익게 했다면 날짜를 출력한다.