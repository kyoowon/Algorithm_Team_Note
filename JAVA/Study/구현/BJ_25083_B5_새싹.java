import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class BJ_25083_B5_새싹 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new StringReader(str));
		String input = null;
		while ((input = reader.readLine()) != null) {
			System.out.println(input);
		}
	}
	static String str = "         ,r'\"7\r\n" + 
			"r`-_   ,'  ,/\r\n" + 
			" \\. \". L_r'\r\n" + 
			"   `~\\/\r\n" + 
			"      |\r\n" + 
			"      |";
}
