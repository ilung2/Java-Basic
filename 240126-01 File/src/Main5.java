import java.io.File;
import java.io.IOException;

public class Main5 {
	public static void main(String[] args) {
		File hi = new File("hi.txt");

//		if (hi.delete()) {
//			System.out.println("파일 삭제");
//		}
		if (hi.exists()) {
			if (hi.renameTo(new File("새로운이름.txt"))) {
				System.out.println("이름 변경 성공");
			} else {
				System.out.println("이미 파일 이름이 존재해서 변경 불가능");
			} 
		}
		         
		try {
			if (hi.createNewFile()) {
				System.out.println("파일 생성에 성공했습니다.");
			} else {
				System.out.println("파일 생성에 실패했습니다.");
			}
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생하여 파일을 생성할 수 없습니다.");
		}
	}
}
