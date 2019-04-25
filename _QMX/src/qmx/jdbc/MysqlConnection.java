package qmx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/qmx?serverzone=GMT&&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		return connection;
	}
	
	public void closeConnection(Connection connection,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(connection != null)
			connection.close();
		if(ps != null)
			ps.close();
		if(rs != null)
			rs.close();
	}
}
