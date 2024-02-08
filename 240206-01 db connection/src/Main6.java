import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
			stmt = conn.createStatement();
			
			String query = "SELECT Name, Continent, SurfaceArea, Population FROM country WHERE NAME = 'South Korea';";
			
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("Name");
				String continent = rs.getString("Continent");
				Float surfaceArea = rs.getFloat("SurfaceArea");
				int population = rs.getInt("Population");
				
				System.out.printf("%s %s %.3f %d\n", name, continent, surfaceArea, population);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
}
