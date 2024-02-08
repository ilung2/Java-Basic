import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) {
		File origin = new File("filename.txt");
		File copy = new File("copy.txt");
		
		// 선언과 초기화를 분리 할수없음. 자바의 버전이 올라가면 분리가능 
		try (FileInputStream fis = new FileInputStream(origin);
				FileOutputStream fos = new FileOutputStream(copy)) {
			byte[] b = new byte[(int) origin.length()];
			
			fis.read(b);
			fos.write(b);
			// 닫히는 순서는 최근꺼부터 Output -> Input
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
