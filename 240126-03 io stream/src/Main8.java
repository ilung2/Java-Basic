import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* 콘솔창에서
// 사람의 이름, 나이를 입력받아

// 절대경로 d:\\mydata\\person.txt 파일에 출력하기
 * 
 * (출력 형식은 '문자'정보이며
 * 첫번째 줄에는 이름
 * 두번째 줄에는 나이
 * 를 기록한다.
 * 
 * --------
 * 
 * 만약 , (길동, 22) (둘리 ,33) (도우너, 44)
 *???
 *
*/
public class Main8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
 
		PrintWriter bw = null;
		try {
			bw = new PrintWriter(new FileWriter(new File("d:\\mydata\\person.txt")));
			boolean go = true;
			while (go) {
				System.out.println("이름을 입력하세요.");
				String name = scan.nextLine();
				if (name.equals("")) {
					go = false;
//					System.exit(0);
				} else {
				System.out.println("나이를 입력하세요");
				String age = scan.nextLine();
				bw.write(name + "\n");
				bw.write(age + "\n");
				bw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
}
