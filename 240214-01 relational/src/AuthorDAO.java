import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class AuthorDAO {
	public List<Author> getAll() {
		List<Author> list = new ArrayList<>();
		
		try (Connection conn = MySqlConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM authors")) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				Author author = new Author();
				author.setId(id);
				author.setName(name);
				
				list.add(author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Author getById(int id) {
		String query = "SELECT A.id AS aId, A.name, B.id AS bId, B.title"
				+ " FROM authors A"
				+ " LEFT JOIN books B ON A.id = B.authorId"
				+ " WHERE A.id = ?";
		
		Author author = null;
		List<Book> list = new ArrayList<>();
		try(Connection conn = MySqlConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			
			try (ResultSet rs = stmt.executeQuery()) {
				
				while (rs.next()) {
					if (author == null) {
						author = new Author();
						author.setId(rs.getInt("aId"));
						author.setName(rs.getString("name"));
						author.setBooks(list);
					}
					Book book = new Book();
					book.setId(rs.getInt("bId"));
					book.setTitle(rs.getString("title"));
					book.setAuthor(author);
					
					list.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return author;
	}
}
