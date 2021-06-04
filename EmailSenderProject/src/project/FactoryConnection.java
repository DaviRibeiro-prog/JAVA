package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

public class FactoryConnection {
	
	protected static Connection getConnectionToMySql() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emailproject?useTimezone=true&serverTimezone=UTC", "root", "");
		return conn;
	}
	
	protected static void closeConnections(Connection conn, PreparedStatement ps, ResultSet users) {
		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(users);
		DbUtils.closeQuietly(ps);
	}
}
