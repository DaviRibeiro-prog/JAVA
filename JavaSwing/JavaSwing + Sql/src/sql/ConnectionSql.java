package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSql {
	
	public Connection connectionMySql() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_java?useTimezone=true&serverTimezone=UTC", "root", "");
		return conn;
	}
	
	
	
}
