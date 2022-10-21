import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B5_05597_과제안내신분 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		boolean[] visited = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			int nbr = Integer.parseInt(reader.readLine());
			visited[nbr] = true;
		}
		
		for (int i = 1; i <= 30; i++) {
			if (!visited[i]) {
				output.append(i).append('\n');
			}
		}
		System.out.print(output);
	}
}
