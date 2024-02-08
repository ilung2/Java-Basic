import java.util.regex.Pattern;

public class Main5 {
	public static void main(String[] args) {
		String input1 = "str100";
		String input2 = "str21";
		String input3 = "str32";
		
		// [] 안에 숫자 나열 가능. []뒤에 0을 넣으면 십의자리 [] 중복가능 [][] 자리수 나타냄
		Pattern p = Pattern.compile("str[13579][02468][0-9]");
		System.out.println(p.matcher(input1).matches());
		System.out.println(p.matcher(input2).matches());
		System.out.println(p.matcher(input3).matches());
	}
}
