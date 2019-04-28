package qmx.service;

import java.sql.Connection;
import java.sql.ResultSet;

import qmx.DAOImpl.stuDaoImpl;

public class adminService {
	
	public ResultSet doDownload(Connection connection){
		stuDaoImpl studentDaoImpl = new stuDaoImpl();
		ResultSet rs = null;
		try {
			rs = studentDaoImpl.stuList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
