public class ThrowsTest {
	public static int runtimeExcep(int num1, int num2) {
		return num1 / num2;
	}

	public static boolean checkedExcep(int num) throws Exception {
		if (num > 0) {
			return true;
		}
		throw new Exception("체크드 예외");
	}

	public static void main(String[] args) {
		runtimeExcep(10, 0);
	}
}





