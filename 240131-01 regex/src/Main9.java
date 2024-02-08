import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main9 {
	public static void main(String[] args) {
		// . => 아무 문자 가능. 예외)개행문자
		Pattern p = Pattern.compile("\\d+.\\d+");
		Matcher m = p.matcher("344.23");
		System.out.println(m.matches());
	}
}
