import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_SAFFY_헌터2 {
	static class Node {
		int x;
		int y;
		int monster;
		public Node(int x, int y, int monster) {
			super();
			this.x = x;
			this.y = y;
			this.monster = monster;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", monster=" + monster + "]";
		}
	}
	
	static int N;
	static int[][] graph;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(reader.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(reader.readLine());
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
//			for (int[] row : graph)
//				System.out.println(Arrays.toString(row));
			//input
			
			result = 0;
			startHunting();
			System.out.println(result);
		}
	}
	
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int result = 0;
	private static void startHunting() {
		Queue<Node> q = new LinkedList<>();
		int moster = 0;
		if (graph[0][0] > 0)
			moster &= 1 << graph[0][0];
		q.add(new Node(0, 0, moster));
		int time = 0;
		boolean[][] visited = new boolean[N][N];
		while (!q.isEmpty()) {
			time++;
			int size = q.size();
			ArrayList<Node> nexts = new ArrayList<>();
			while (--size >= 0) {
				Node hunter = q.poll();
				visited[hunter.x][hunter.y] = true;
				for (int d = 0; d < deltas.length; d++) {
					int nx = hunter.x + deltas[d][0];
					int ny = hunter.y + deltas[d][1];
					
					if (isIn(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						if(graph[nx][ny] > 0) { // 몬스터 - 경우를 나눠야 하나? 같은 거리에  여러개가 있으면 어쩌지?
							// 일단은 상관 없다고 생각하고 풀이를 진행
							nexts.add(new Node(nx, ny, hunter.monster | 1 << graph[nx][ny]));
						}
						if (graph[nx][ny] < 0) { // 의뢰인 경우
							if ((hunter.monster & 1 << (graph[nx][ny] * -1)) > 0) {
								nexts.add(new Node(nx, ny, hunter.monster));
							}
						}
						q.add(new Node(nx, ny, hunter.monster));
					}
				}
			}
			if (!nexts.isEmpty()) {
				System.out.println(nexts);
				Node next = nexts.get(0);				
				q.clear();
				q.add(next);
				for (boolean[] row : visited) {
					Arrays.fill(row, false);
				}
				graph[next.x][next.y] = 0;
				result = time;
			}
		}
	}
	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	static String str = "5\r\n" + 
			"3\r\n" + 
			"0 0 0\r\n" + 
			"0 1 -1\r\n" + 
			"0 0 0\r\n" + 
			"4\r\n" + 
			"-3 -1 1 0\r\n" + 
			"-2 0 0 3\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 2 0\r\n" + 
			"5\r\n" + 
			"0 0 -3 0 0\r\n" + 
			"0 0 0 3 0\r\n" + 
			"0 0 0 0 2\r\n" + 
			"0 0 1 0 0\r\n" + 
			"-1 0 0 -2 0\r\n" + 
			"6\r\n" + 
			"-1 0 0 0 0 -4\r\n" + 
			"0 0 0 0 2 0\r\n" + 
			"-3 -2 0 4 0 0\r\n" + 
			"3 0 0 0 0 1\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"8\r\n" + 
			"3 0 0 0 -2 0 0 0\r\n" + 
			"0 0 0 0 -4 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 -1 0 0 0 0 0\r\n" + 
			"0 -3 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 2 4 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"";
}


// solution
// BFS로 사방탐색을 통해서 가장 가까운 몬스터 혹은 의뢰인을 찾는다.
// 이때 의뢰인을 먼저 찾은 경우에는 해당 몬스터를 잡았는지 확인한다.
// 잡았다면 의뢰인으로 이동!!