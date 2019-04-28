package qmx.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.stuEntity;
import qmx.Dao.stuDao;
import qmx.jdbc.MysqlConnection;

public class stuDaoImpl implements stuDao {
	
	static PreparedStatement ps =null;
	
	public void addStu(stuEntity stu) throws ClassNotFoundException, SQLException{
		MysqlConnection Mycon = new MysqlConnection();
		Connection con=Mycon.getConnection();
		String sql = "insert into qmx(姓名,学号,学院,专业,qq号,电话号码,性别,选择组别) values(?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, stu.getName());
		ps.setString(2, stu.getXuehao());
		ps.setString(3, stu.getXueyuan());
		ps.setString(4, stu.getZhuanye());
		ps.setString(5, stu.getQq());
		ps.setString(6, stu.getPhone());
		ps.setString(7, stu.getSex());
		ps.setString(8, stu.getHobby());
		ps.executeUpdate();
		con.close();
//		ps.close();
	}
	
	public void stuUpdate(stuEntity stu) throws ClassNotFoundException, SQLException{
		String sql = "update qmx set 姓名=?,学院=?,专业=?,qq号=?,电话号码=?,性别=?,选择组别=? "
				+ "where 学号 = ?";
		MysqlConnection Mycon = new MysqlConnection();
		Connection con = Mycon.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, stu.getName());
		ps.setString(2, stu.getXueyuan());
		ps.setString(3, stu.getZhuanye());
		ps.setString(4, stu.getQq());
		ps.setString(5, stu.getPhone());
		ps.setString(6, stu.getSex());
		ps.setString(7, stu.getHobby());
		ps.setString(8, stu.getXuehao());
		ps.executeUpdate();
		con.close();
		ps.close();
	}
	
	public boolean xuehaoSearch(String xuehao) throws ClassNotFoundException, SQLException{
		boolean check_msg;
		MysqlConnection MyConn = new MysqlConnection();
		Connection conn = MyConn.getConnection();
		String sql = "select * from qmx where 学号=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, xuehao);
		ResultSet rs = ps.executeQuery();
		check_msg = rs.next();
		conn.close();
		return check_msg;
		
	}
}
