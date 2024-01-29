import java.io.File;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) {
		File sub = new File("sub\\child.txt");
		System.out.println(sub.exists());

		File sub2 = new File(".\\sub\\child.txt");
		System.out.println(sub2.exists());

		File sub3 = new File(".\\.\\sub\\.\\.\\child.txt");
		System.out.println(sub3.exists());
		        
		try { 
			System.out.println(sub.getCanonicalPath());
			System.out.println(sub2.getCanonicalPath());
			System.out.println(sub3.getCanonicalPath());
		} catch (IOException e) {
			System.out.println("변환 중 예외가 발생했습니다.");
		}
	}
}
