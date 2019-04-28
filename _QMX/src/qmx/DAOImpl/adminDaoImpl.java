package qmx.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.adminEntity;
import Entity.stuEntity;
import qmx.Dao.adminDao;
import qmx.jdbc.MysqlConnection;

public class adminDaoImpl implements adminDao {
	
	public void adminRegister(adminEntity admin) throws ClassNotFoundException, SQLException{
		MysqlConnection MyConn = new MysqlConnection();
		Connection conn = MyConn.getConnection();
		String sql = "insert into admin (账号,密码) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, admin.getUsername());
		ps.setString(2, admin.getPassword());
		ps.executeUpdate();
		conn.close();
		
	}
	
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
	
	public stuEntity adminSelect(int id) throws ClassNotFoundException, SQLException{
		String sql = ("select * from qmx where id = ?");
		stuEntity stu = null;
		MysqlConnection MyConn = new MysqlConnection();
		Connection conn = MyConn.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			stu = new stuEntity();
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("姓名"));
			stu.setXuehao(rs.getString("学号"));
			stu.setXueyuan(rs.getString("学院"));
			stu.setZhuanye(rs.getString("专业"));
			stu.setQq(rs.getString("qq号"));
			stu.setPhone(rs.getString("电话号码"));
			stu.setSex(rs.getString("性别"));
			stu.setHobby(rs.getString("选择组别"));
		}
		rs.close();
		ps.close();
		return stu;
	}
	
	public stuEntity adminUpdate(int id,stuEntity stu) throws ClassNotFoundException, SQLException{
		MysqlConnection MyConn = new MysqlConnection();
		Connection conn = MyConn.getConnection();
		String sql = "update qmx set 姓名=?,学号=?,学院=?,专业=?,qq号=?,电话号码=?,性别=?,选择组别=? "
				+ "where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getName());
		ps.setString(2, stu.getXuehao());
		ps.setString(3, stu.getXueyuan());
		ps.setString(4, stu.getZhuanye());
		ps.setString(5, stu.getQq());
		ps.setString(6, stu.getPhone());
		ps.setString(7, stu.getSex());
		ps.setString(8, stu.getHobby());
		ps.setInt(9, stu.getId());
		ps.executeUpdate();
		
		return stu;
	}
}
