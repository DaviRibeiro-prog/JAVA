package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	static Connection conn;
	static ResultSet users;
	static PreparedStatement ps;
	
	
	protected static ResultSet retriveUsers() {
		FactoryConnection.closeConnections(conn, ps, users);	// if there is any new connection, it will close the previous one
		
		try { 
			conn = FactoryConnection.getConnectionToMySql();
			ps = (PreparedStatement) conn.prepareStatement("select * from users");
			users = ps.executeQuery();
		
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
