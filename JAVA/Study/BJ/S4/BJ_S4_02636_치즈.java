package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S4_02636_치즈 {
	static class Node{
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		public Node() {
			super();
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static boolean[][] graph;
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new StringReader(str));
		
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int c = 0; c < M; c++) {
				int nbr = Integer.parseInt(tokens.nextToken());
				if (nbr == 1) {
					graph[r][c] = true;
				}
			}
		}
		bfs();
		System.out.println(time);
		System.out.println(extra);
	}
	
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int time;
	static int extra;
	private static void bfs() {
		while(true) {			
			Queue<Node> edges = getEdges();
			if (edges.isEmpty())
				break;
			time++;
			for (Node edge : edges) {
				graph[edge.r][edge.c] = false;
			}
			extra = edges.size();
		}
	}
	
	private static Queue<Node> getEdges() {
		Queue<Node> edges = new LinkedList<>();
		Queue<Node> temp = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		temp.add(new Node(0, 0, 0));
		while(!temp.isEmpty()) {
			Node node = temp.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.r + deltas[d][0];
				int ny = node.c + deltas[d][1];
				if(isIn(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (graph[nx][ny]) {
						edges.add(new Node(nx, ny, 0));						
					}else
						temp.add(new Node(nx, ny, 0));
				}
			}
		}
		
		return edges;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}
