package qmx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/qmx?serverTimezone=GMT&&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		System.out.println("测试数据库成功MySQL");
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println("数据库连接成功MySQL");
		return connection;
	}

}
