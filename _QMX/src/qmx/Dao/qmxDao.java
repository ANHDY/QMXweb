package qmx.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qmx.User.Users;

public class qmxDao {

	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String USER = "root";
	private static String PASSWORD = "root";
	private static String URL = "jdbc:mysql://localhost:3306/qmx?serverTimezone=GMT&&useSSL=false";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		System.out.println("测试数据库成功");
		
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println("数据库连接成功");
		return connection;
	}
	
	
	public static void closeConnection(Connection connection,PreparedStatement ps,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static boolean addUpdateDelete(String sql,Object[] arr){
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = qmxDao.getConnection();
			ps = con.prepareStatement(sql);
			if(arr != null && arr.length != 0){
				for(int i=0;i<arr.length;i++){
					ps.setObject(i+1, arr[i]);
				}
			}
			
			int count = ps.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public List read(){
		
		List<Users> list = new ArrayList<Users>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = qmxDao.getConnection();
			String sql = "select * from qmx";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("姓名");
				String xuehao = rs.getString("学号");
				String xueyuan = rs.getString("学院");
				String zhuanye = rs.getString("专业");
				String qq = rs.getString("qq号");
				String phone = rs.getString("电话号码");
				String sex = rs.getString("性别");
				String hobby = rs.getString("选择组别");
				Users u = new Users(id,name,xuehao,xueyuan,zhuanye,qq,phone,sex,hobby);
				list.add(u);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(rs!=null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(con!=null){
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public boolean check(String xuehao) {
		boolean check_msg = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = qmxDao.getConnection();
			String sql = "select * from qmx where 学号 = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, xuehao);
			ResultSet rs = pst.executeQuery();
			check_msg = rs.next();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null)	pst.close();
				if(con != null)	con.close();
			} catch (Exception e2) {
			}
		}
		return check_msg;
	}
	
	
	
	
}
