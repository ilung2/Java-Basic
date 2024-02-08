import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyDBCP {
	private DataSource ds;
	
	public MyDBCP() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/my_db");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
//		dataSource.setInitialSize(0); // 초기 생성 인스턴스 개수
//		dataSource.setMaxTotal(8); // 최대 생성 인스턴스 개수
//		dataSource.setMaxIdle(8); //
//		dataSource.setMinIdle(0);
		
		ds = dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
