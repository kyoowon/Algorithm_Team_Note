package algorithm_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new StringReader(str));
		int V = Integer.parseInt(reader.readLine());
		
		int[][] adjMarix = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for (int j = 0; j < V; j++) {
				adjMarix[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int start = 0;
		int end = V - 1;
		// 다익스트라 알고리즘에 필요한 자료구조
		int[] D = new int[V]; //  출발지에서 자신으로 오는데 소요되는 최소비용
		boolean[] visited = new boolean[V]; // 처리한 정점 여부
		
		Arrays.fill(D,  Integer.MAX_VALUE);
		// 출발정점 처리
		D[start] = 0;
		
		int min, minVertex;
		
		for (int i = 0; i < V; i++) {
			// step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
			// 방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}
			// step2. 방문처리
			visited[minVertex] = true;
			if (minVertex == end) break;
			
			// step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			for(int j = 0; j < V; j++) {
				if (!visited[j] && adjMarix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMarix[minVertex][j]) {
					D[j] = D[minVertex] + adjMarix[minVertex][j];
				}
			}
		}
		System.out.println(Arrays.toString(D));
		System.out.println(D[end]);
	}
	
	static String str = "5\r\n" + 
			"0 2 2 5 9\r\n" + 
			"2 0 3 4 8\r\n" + 
			"2 3 0 7 6\r\n" + 
			"5 4 7 0 5\r\n" + 
			"9 8 6 5 0";
}
