package qmx.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import qmx.Dao.qmxDao;
import qmx.User.Users;
import qmx.User.messages;

public class UserDao {
	
	public boolean baomings(Users user){
		
		String sql = "insert into qmx (姓名,学号,学院,专业,qq号,电话号码,性别,选择组别) values(?,?,?,?,?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(user.getName());
		list.add(user.getXuehao());
		list.add(user.getXueyuan());
		list.add(user.getZhuanye());
		list.add(user.getQq());
		list.add(user.getPhone());
		list.add(user.getSex());
		list.add(user.getHobby());
		
		boolean flag = qmxDao.addUpdateDelete(sql, list.toArray());
		if(flag){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean deletes(Connection con,String xuehao) throws SQLException{
		String sql = "delete from qmx where 学号 = ?";
		PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, xuehao);
	    if(ps.executeUpdate()>0)
	    	return true;
	    return false;
	}
	
	public boolean updates(Connection con,Users user) throws SQLException{
		String sql = "update qmx set 姓名=?,学号=?,学院=?,专业=?,qq号=?,电话号码=?,性别=?,选择组别=? "
				+ "where id = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getXuehao());
		ps.setString(3, user.getXueyuan());
		ps.setString(4, user.getZhuanye());
		ps.setString(5, user.getQq());
		ps.setString(6, user.getPhone());
		ps.setString(7, user.getSex());
		ps.setString(8, user.getHobby());
		ps.setInt(9, user.getId());
		if(ps.executeUpdate()>0)
			return true;
		else
			return false;
	}
	
	public boolean stuUpdates(Connection con,Users user) throws SQLException{
		String sql = "update qmx set 姓名=?,学院=?,专业=?,qq号=?,电话号码=?,性别=?,选择组别=? "
				+ "where 学号 = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getXueyuan());
		ps.setString(3, user.getZhuanye());
		ps.setString(4, user.getQq());
		ps.setString(5, user.getPhone());
		ps.setString(6, user.getSex());
		ps.setString(7, user.getHobby());
		ps.setString(8, user.getXuehao());
		if(ps.executeUpdate()>0)
			return true;
		else
			return false;
	}
	
	public Users selects(Connection con,int id) throws SQLException{
		String sql=("select * from qmx where id = ?");
		Users stu = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			stu = new Users();
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
	
	
	public messages login(messages mess) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//1.获取数据库的连接
			con = qmxDao.getConnection();
			//2.书写sql语句
			String sql="select * from message where 账号 = ? and 密码=?";
			//3.预编译
			ps=con.prepareStatement(sql);
			//4.设置值
			ps.setString(1, mess.getName());
			ps.setString(2, mess.getPassword());
			//5.执行sql语句
			rs=ps.executeQuery();
			messages messes=null;
			if(rs.next()){
				messes = new messages();
				//从数据库中获取值到实体类的setter方法中
				messes.setName(rs.getString("账号"));
				messes.setPassword(rs.getString("密码"));
				return mess;
			}else{
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean register(messages user) {
		
		String sql="insert into message (账号,密码) values(?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(user.getName());
		list.add(user.getPassword());
		
		boolean flag = qmxDao.addUpdateDelete(sql, list.toArray());
		if(flag){
			return true;
		}else{
			return false;
		}
	}
	
	
//	public List getAllUser(){
//		Connection con=null;
//		PreparedStatement ps=null;
//		ResultSet rs = null;
//		
//		try {
//			con = qmxDao.getConnection();
//			String sql = "select * from qmx";
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			List<Users> list = new ArrayList<Users>();
//			Users users=null;
//			while(rs.next()){
//				users = new Users();
//				users.setId(rs.getString("id"));
//				users.setName(rs.getString("姓名"));
//				users.setXuehao(rs.getString("学号"));
//				users.setXueyuan(rs.getString("学院"));
//				users.setZhuanye(rs.getString("专业"));
//				users.setQq(rs.getString("qq号"));
//				users.setPhone(rs.getString("电话号码"));
//				users.setSex(rs.getString("性别"));
//				users.setHobby(rs.getString("选择组别"));
//				list.add(users);
//			}
//			return list;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		
//		
//		
//		
//	}

}
