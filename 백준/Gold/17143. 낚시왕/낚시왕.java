import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Shark {
		int n; // 인덱스
		int r; // 행
		int c; // 열
		int s; // 속력
		int d; // 방향
		int z; // 크기

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public void move() {
			int speed = s;
			if (d ==  1 || d == 2) {
				speed %= ((R - 1) * 2);
			}else if (d == 3 || d == 4){
				speed %= ((C - 1) * 2);
			}
			
			for (int t = 0; t < speed; t++){
				int nx = r + deltas[d][0];
				int ny = c + deltas[d][1];
				
				if (nx <= 0 || nx > R || ny <= 0 || ny > C) {
					r -= deltas[d][0];
					c -= deltas[d][1];
					if (d == 1) d = 2;
					else if (d == 2) d = 1;
					else if (d == 3) d = 4;
					else if (d == 4) d = 3;
					continue;
				}
				r = nx;
				c = ny;
			}
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}
	static int[][] deltas = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int R;
	static int C;
	static Shark[] sharks;

	public static void main(String[] args) throws IOException {
		// reader = new BufferedReader(new StringReader(str));

		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		sharks = new Shark[M + 1];

		for (int m = 1; m <= M; m++) {
			tokens = new StringTokenizer(reader.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int z = Integer.parseInt(tokens.nextToken());
			sharks[m] = new Shark(r, c, s, d, z);
			sharks[m].n = m;
		}

		startFishing(1);
		System.out.println(result);
	}

	static int result = 0;

	private static void startFishing(int col) {
		if (col == C + 1) {
			return;
		}
		Shark fishing = null;
		for (Shark s : sharks) {
			if (s != null && s.c == col) {
				if (fishing == null || fishing.r > s.r) {
					fishing = s;
				}
			}
		}
		if (fishing != null) {
			result += fishing.z;
			sharks[fishing.n] = null;
		}
		movingShark();
		startFishing(col + 1);
	}

	private static void movingShark() {
		int[][] visited = new int[R + 1][C + 1];
		for (Shark s : sharks) {
			if (s != null) {
				s.move();
				if (visited[s.r][s.c] == 0)
					visited[s.r][s.c] = s.n;
				else {
					if (sharks[visited[s.r][s.c]].z > s.z) {
						sharks[s.n] = null;
					}else {
						sharks[visited[s.r][s.c]] = null;
						visited[s.r][s.c] = s.n;
					}
				}
			}
		}
	}

	static String str = "4 6 8\r\n" + 
			"4 1 3 3 8\r\n" + 
			"1 3 5 2 9\r\n" + 
			"2 4 8 4 1\r\n" + 
			"4 5 0 1 4\r\n" + 
			"3 3 1 2 7\r\n" + 
			"1 5 8 4 3\r\n" + 
			"3 6 2 1 2\r\n" + 
			"2 2 2 3 5";
}