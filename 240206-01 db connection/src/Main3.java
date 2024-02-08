import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// pets 테이블에 레코드 1행 추가
// 이름:피카츄, 종:쥐, 나이:3

// 이름:꼬부기, 종:거북이, 나이:4
public class Main3 {
	public static void insertPet(String name, String species, int age) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO pets (name, species, age)"
					+ " VALUES ('" + name + "', '" + species + "', " + age + ")";
			
			System.out.println("SQL: " + sql);
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		insertPet("파이리", "도마뱀", 4);
		insertPet("피죤투", "비둘기", 5);
	}
}
