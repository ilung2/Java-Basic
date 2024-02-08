import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
	public static void main(String[] args) {
		String input = "Hello";
		String input2 = "Aello";
		
		
		// [] 문자 한개 대괄호 안에 문자 표현 범위 설정 가능.
		Pattern p = Pattern.compile("[B-Z]ello");
		Matcher m = p.matcher(input);
		System.out.println(m.matches());
		Matcher m2 = p.matcher(input2);
		System.out.println(m2.matches());
		
	}
}
