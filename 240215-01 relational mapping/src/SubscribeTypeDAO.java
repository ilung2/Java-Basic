import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.MySqlConnectionProvider;

public class SubscribeTypeDAO {
	public SubscribeType getByPk(int subNo, Connection conn) throws SQLException {
		try (PreparedStatement stmt
					= conn.prepareStatement("SELECT * FROM subscribeTypes WHERE subNo = ?")) {
			stmt.setInt(1, subNo);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int subNoCol = rs.getInt("subNo");
					String subName = rs.getString("subName");
					
					return new SubscribeType(subNoCol, subName);
				}
			}
		}
		return null;
	}
}
