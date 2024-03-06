import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Decoder;

import dbutil.MySqlConnectionProvider;

public class main {
	public static void main(String[] args) {
		try (Connection conn = MySqlConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM filebase64 WHERE no = ?")) {
			stmt.setInt(1, 1);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int no = rs.getInt("no");
					String filename = rs.getString("filename");
					String encoded = rs.getString("encoded");

					Decoder decoder = Base64.getDecoder();
					byte[] decode = decoder.decode(encoded);

					Files.write(Paths.get(".\\", filename), decode);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
