import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author kyulee
 * @link https://www.acmicpc.net/problem/14501
 * @performance 11792	84
 * @category 부분집합
 * @memo
 */

public class BJ_S3_14501_퇴사 {
	static class Meeting{
		int day;
		int point;
		public Meeting(int day, int point) {
			super();
			this.day = day;
			this.point = point;
		}
	}
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
//		reader = new BufferedReader(new StringReader(str));
		
		N = Integer.parseInt(reader.readLine());
		meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int day = Integer.parseInt(tokens.nextToken());
			int cost = Integer.parseInt(tokens.nextToken());
			meetings[i] = new Meeting(day, cost);
		}
		SubSet(0, 0);
		System.out.println(result);
	}
	
	static Meeting[] meetings;
	static int N;
	static int result = 0;
	static void SubSet(int cnt, int sum) {
		if (cnt <= N)
			result = Math.max(result, sum);
		if (cnt >= N)
			return;
		SubSet(cnt + meetings[cnt].day, sum + meetings[cnt].point);
		SubSet(cnt + 1, sum);
	}
	
	static String str = "10\r\n" + 
			"5 50\r\n" + 
			"4 40\r\n" + 
			"3 30\r\n" + 
			"2 20\r\n" + 
			"1 10\r\n" + 
			"1 10\r\n" + 
			"2 20\r\n" + 
			"3 30\r\n" + 
			"4 40\r\n" + 
			"5 50";
}
