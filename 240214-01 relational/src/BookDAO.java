import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class BookDAO {
	public List<Book> getByAuthorId(int authorId) {
		List<Book> list = new ArrayList<>();
		
		try(Connection conn = MySqlConnectionProvider.getConnection();
				PreparedStatement stmt
					= conn.prepareStatement("SELECT * FROM books WHERE authorId = ?");
				) {
			stmt.setInt(1, authorId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					
					Book book = new Book();
					book.setId(id);
					book.setTitle(title);
					
					list.add(book);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
