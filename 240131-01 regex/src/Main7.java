import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main7 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-z]{0,5}"); // {최소값,최대값}
		Matcher m = p.matcher("slf");
		
		System.out.println(m.matches());
	}
}
