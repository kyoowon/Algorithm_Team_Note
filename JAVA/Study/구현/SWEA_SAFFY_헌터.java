import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_SAFFY_헌터 {
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
			
		}
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