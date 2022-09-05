import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String inputs = reader.readLine();
		
		for(int i = 1; i <= inputs.length(); i++) {
			if (i % 10 != 0)
				output.append(inputs.charAt(i - 1));
			else
				output.append(inputs.charAt(i - 1)).append("\n");
		}
		System.out.println(output);
	}
}