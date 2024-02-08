import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) {
		// try-resource = 자동적으로 close가 호출됨. 선언과 초기화를 합치게해줌.
		try (PrintWriter pw = new PrintWriter("Filename.txt")) {
			pw.println("문자열출력");
			pw.flush();
			// pw 는 try 블럭안에서만 접근이 가능.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("필요한 추가 작업이 있다면 finally 블럭 구성이 가능");
		}
	}
}
