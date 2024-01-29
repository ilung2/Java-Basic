import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File dataFile = new File("data.txt");
		System.out.println("파일 존재?: " + dataFile.exists());
		System.out.println("파일 크기 : " + dataFile.length());
		 
		Scanner scan = null;
		try {
			scan = new Scanner(dataFile);
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아, Scanner 객체를 생성할 수 없습니다.");
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}
}
