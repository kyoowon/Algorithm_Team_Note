import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/16236
 * @performance 12144	96
 * @category
 * @memo
 */

public class BJ_G3_16236_아기상어 {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int eat;
		int size;
		public Node(int x, int y, int eat, int size) {
			super();
			this.x = x;
			this.y = y;
			this.eat = eat;
			this.size = size;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", eat=" + eat + ", size=" + size + "]";
		}
		@Override
		public int compareTo(Node o) {
			if (this.x == o.x) return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
		}
		
		
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] graph;
	static int[] fishs;
	static Node start;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		N = Integer.parseInt(reader.readLine());
		graph = new int[N][N];
		fishs = new int[9];
		int count = 0;
		
		for (int r = 0; r < N; r++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
				if (graph[r][c] == 9) {
					start = new Node(r, c, 0, 2);
					graph[r][c] = 0; 
				} else if (graph[r][c] > 0){
					fishs[graph[r][c]]++;
					count++;
				}
			}
		}
		startHunting(count);
		System.out.println(result);
	}
	
	static int[][] deltas = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static int result = 0;
	private static void startHunting(int cnt) {
		int time = 0;
		Queue<Node> q = new LinkedList<>();
		List<Node> Next = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		visited[start.x][start.y] = true;
		q.add(start);
		while(cnt > 0 && !q.isEmpty()) {
			time++;
			int size = q.size();
			while (--size >= 0) {
				Node node = q.poll();				
				for (int d = 0; d < deltas.length; d++) {
					int nx = node.x + deltas[d][0];
					int ny = node.y + deltas[d][1];
					
					if (isIn(nx, ny) && !visited[nx][ny]) {
						if (graph[nx][ny] < node.size && graph[nx][ny] != 0) {
							if (node.eat + 1 == node.size)
								Next.add(new Node(nx, ny, 0, node.size + 1));
							else {
								Next.add(new Node(nx, ny, node.eat + 1, node.size));
							}
						} else if (graph[nx][ny] == node.size || graph[nx][ny] == 0) {
							q.add(new Node(nx, ny, node.eat, node.size));
						}
						visited[nx][ny] = true;
					}
				}
			}
			
			if (!Next.isEmpty()) {
				Collections.sort(Next);
				Node del = Next.get(0);
				fishs[graph[del.x][del.y]]--;
				graph[del.x][del.y] = 0;
				q.clear();
				q.add(del);
				visited = new boolean[N][N];
				visited[del.x][del.y] = true;
				
				int minValue = -1;
				for (int r = 1; r < 9; r++) {
					if (fishs[r] > 0) {
						minValue = r;
						break;
					}
				}
				result = time;
				if (del.size <= minValue) {
					return;
				}
				cnt--;
				Next.clear();
			}
		}
	}
	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}

	static String str = "20\r\n" + 
			"1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 9";
}

// 먹을 수 없는 물고기가 없다면 종료
// 1마리라면 먹으러
// 이상이라면 가까운 거리 (헤밀턴 거리)
// 같은 거리라면 가장 위, 왼쪽
// 크기만큼 먹으면 커짐

// solution
// 시뮬레이션