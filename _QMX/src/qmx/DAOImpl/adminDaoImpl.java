package qmx.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.adminEntity;
import qmx.Dao.adminDao;
import qmx.jdbc.MysqlConnection;

public class adminDaoImpl implements adminDao {
	public adminEntity adminLogin(adminEntity admin) throws ClassNotFoundException, SQLException{
		MysqlConnection myCon = new MysqlConnection();
		Connection con = myCon.getConnection(); 
		String sql = "select * from admin where 账号 = ? and 密码 = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, admin.getUsername());
		ps.setString(2, admin.getPassword());
		ResultSet rs = ps.executeQuery();
		adminEntity admins = null;
		if(rs.next()){
			admins = new adminEntity();
			admins.setUsername(rs.getString("账号"));
			admins.setPassword(rs.getString("密码"));
			return admin;
		}
		return null;
	}
	
	public void deletesStu(int id) throws ClassNotFoundException, SQLException{
		MysqlConnection MyConn = new MysqlConnection();
		Connection conn = MyConn.getConnection();
		String sql = "delete from qmx where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.executeUpdate();
		conn.close();
		
		
		
		
		
	}
}
