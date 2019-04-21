package qmx.Dao;

import java.sql.Connection;
import java.sql.SQLException;

public class daotest {
	public static void main(String[] args) 
			throws ClassNotFoundException,SQLException {
		Connection connection = qmxDao.getConnection();
		System.out.println(connection);
	}
}
