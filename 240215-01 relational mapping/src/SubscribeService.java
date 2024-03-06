import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class SubscribeService {
	private SubscribeDAO subscribeDAO;
	private SubscribeTypeDAO subscribeTypeDAO;

	public SubscribeService() {
		subscribeDAO = new SubscribeDAO();
		subscribeTypeDAO = new SubscribeTypeDAO();
	}

	public List<Subscribe> getAll() {
		try (Connection conn = MySqlConnectionProvider.getConnection()) {
			List<Subscribe> list = subscribeDAO.getAll(conn);

			for (Subscribe s : list) {
				SubscribeType type = subscribeTypeDAO.getByPk(s.getSubNo(), conn);
				s.setSubscribeType(type);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
