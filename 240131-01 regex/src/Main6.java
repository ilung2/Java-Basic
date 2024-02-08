import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]+[1-9]"); // [] 한개의 문자의범위를 나타냄.
		Matcher m = p.matcher("a1");
		
		System.out.println(m.matches());
	}
}
