package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_17472_다리만들기2 {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					BFS(i, j, visited, cnt);
					cnt++;
				}
			}
		}
		
		ArrayList<Node> list = new ArrayList<>();
		
		int[][] briges = new int[N][M]; // 다리를 놓는 경우의 수 0이면 아직 없음, 1이면 가로만, 이상이면 가로 세로 둘다 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0 && briges[i][j] < 3) {
					int start = 0;
					int end = 0;
					int sum = 1;
					for(int d = 0; d <= 2; d += 2) { // 가로로 idx : 0, idx : 2
						for (int len = 0;; len++) {
							int ny = j + deltas[d][1] * len;
							if (ny >= M || ny < 0) // 영역 밖인 경우
								break;
							briges[i][ny] |= 1 << 0;
							if (graph[i][ny] > 0) { // 어디 섬에 닫게 되면
								if (start == 0) {
									start = graph[i][ny];
								}else {
									end = graph[i][ny];
								}
								sum += len - 1;
								break;
							}
						}
					}
					if(start > 0 && end > 0 && sum >= 2) {
						list.add(new Node(start, end, sum));
					}
					start = 0;
					end = 0;
					sum = 1;
					for(int d = 1; d <= 3; d += 2) { // 가로로 idx : 0, idx : 2
						for (int len = 0;; len++) {
							int nx = i + deltas[d][0] * len;
							if (nx >= N || nx < 0) // 영역 밖인 경우
								break;
							briges[nx][j] |= 1 << 1;
							if (graph[nx][j] > 0) { // 어디 섬에 닫게 되면
								if (start == 0) {
									start = graph[nx][j];
								}else {
									end = graph[nx][j];
								}
								sum += len - 1;
								break;
							}
						}
					}
					if(start > 0 && end > 0 && sum >= 2) {
						list.add(new Node(start, end, sum));
					}
					
				}
			}
		}
		
		int[] parent = new int[cnt];
		
		for (int i = 1; i < cnt; i++)
			parent[i] = i;
		
		Collections.sort(list);
		
		int cost = 0;
		for (Node node : list) {
			if (unionParent(findParent(node.x, parent), findParent(node.y, parent), parent)) {
				cost += node.cnt;
			}
		}
		boolean flag = false;
		if (!list.isEmpty()) {
			int tmp = findParent(list.get(0).x, parent);
			for (int i = 1; i < cnt; i++) {
				if (tmp != findParent(i, parent)) {
					flag = true;
					break;
				}
			}
		}
		
		if (flag || list.isEmpty())
			System.out.println(-1);
		else
			System.out.println(cost);
	}
	
	static int findParent(int a, int[] parent) {
		if (a != parent[a]) {
			parent[a] = findParent(parent[a], parent);
		}
		return parent[a];
	}
	
	static boolean unionParent(int a, int b, int[] parent) {
		a = parent[a];
		b = parent[b];
		
		if (a == b)
			return false;
		if (a < b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
		return true;
	}

	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static void BFS(int x, int y, boolean[][] visited, int nbr) {
		visited[x][y] = true;
		Queue<Node> q = new LinkedList<>();
		graph[x][y] = nbr;
		q.add(new Node(x, y));
		while(!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nx = node.x + deltas[d][0];
				int ny = node.y + deltas[d][1];
				if (isIn(nx, ny) && !visited[nx][ny] && graph[nx][ny] != 0) {
					visited[nx][ny] = true;
					graph[nx][ny] = nbr;
					q.add(new Node(nx, ny));
				}
			}
		}
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}

	static String str = "7 7\r\n" + 
			"1 1 1 0 1 1 1\r\n" + 
			"1 1 1 0 1 1 1\r\n" + 
			"1 1 1 0 1 1 1\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"1 1 1 0 1 1 1\r\n" + 
			"1 1 1 0 1 1 1\r\n" + 
			"1 1 1 0 1 1 1";
}
