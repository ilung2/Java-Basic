import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;

import dbutil.MySqlConnectionProvider;

public class Main2 {
	public static void main(String[] args) {
		try (Connection conn = MySqlConnectionProvider.getConnection();
				PreparedStatement stmt
				= conn.prepareStatement("INSERT INTO filebase64 (filename, encoded) VALUES (?, ?)")) {
			byte[] readAllBytes = Files.readAllBytes(Paths.get("춘식2.png"));
			Encoder encoder = Base64.getEncoder();
			String encodeToString = encoder.encodeToString(readAllBytes);
			
			stmt.setString(1, "춘식2.png");
			stmt.setString(2, encodeToString);
			
			stmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
