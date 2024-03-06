import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class SubscribeDAO {
	public List<Subscribe> getAll(Connection conn) throws SQLException {
		List<Subscribe> list = new ArrayList<>();
		
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM subscribe")){
			while (rs.next()) {
				int no = rs.getInt("no");
				String userId = rs.getString("userId");
				int subNo = rs.getInt("subNo");
				
				Subscribe subscribe = new Subscribe();
				subscribe.setNo(no);
				subscribe.setUserId(userId);
				subscribe.setSubNo(subNo);
				
				list.add(subscribe);
			}
		} 
		return list;
	}
	
	public List<Subscribe> getAllJoin() {
		String sql = "SELECT A.no, A.userId, B.subNo, b.subName" + 
				" FROM subscribe A" + 
				" LEFT JOIN subscribeTypes B ON A.subNo = B.subNo;";
		List<Subscribe> list = new ArrayList<>();
		try (Connection conn = MySqlConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int no = rs.getInt("no");
				String userId = rs.getString("userId");
				int subNo = rs.getInt("subNo");
				String subName = rs.getString("subName");
				
				Subscribe subscribe = new Subscribe();
				subscribe.setNo(no);
				subscribe.setUserId(userId);
				subscribe.setSubNo(subNo);
				subscribe.setSubscribeType(new SubscribeType(subNo, subName));
				
				list.add(subscribe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
