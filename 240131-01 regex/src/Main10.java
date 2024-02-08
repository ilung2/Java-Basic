import java.util.regex.Pattern;

public class Main10 {
	public static void main(String[] args) {
		// | => 는 or
		Pattern p = Pattern.compile("[-+]?(\\d+|\\d+.\\d+)");
		System.out.println(p.matcher("123.4124").matches());
		System.out.println(p.matcher("1234124").matches());
		System.out.println(p.matcher("12.34124").matches());
		System.out.println(p.matcher("-12.34124").matches());
		System.out.println(p.matcher("12.34124").matches());
	}
}
