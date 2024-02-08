import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main4 {
	public static void main(String[] args) {
//		try {
//			Files.copy(Paths.get("hello.txt"), Paths.get("copy.txt")
//					, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		try {
			Files.move(Paths.get("hello.txt"), Paths.get("newname.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
