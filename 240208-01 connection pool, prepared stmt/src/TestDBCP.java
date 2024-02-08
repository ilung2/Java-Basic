import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBCP {
	public static void main(String[] args) {
		MyDBCP dbcp = new MyDBCP();
		try (Connection conn = dbcp.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 200 AS NUM");) {
			if (rs.next()) {
				int num = rs.getInt("NUM");
				System.out.println(num == 200);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
