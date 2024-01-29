import java.io.File;

public class Main3 {
	public static void main(String[] args) {
		File dir = new File("sub\\");
		System.out.println(dir.exists());
		System.out.println("파일인가요? : " + dir.isFile());
		System.out.println("디렉토리인가요 ? : " + dir.isDirectory());
         		
		// .. 두개를 적으면 현재경로에서 상위경로로 이동
		File my = new File("sub\\..\\my.txt");
		System.out.println(my.exists());
		System.out.println("파일? : " + my.isFile());
	}
}
