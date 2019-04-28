package cn.edu.bzu.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.news.jsp.entity.Title;


public class TitleDAO {
    public List readFirstTitle(){
        List<Title> list =new ArrayList<Title>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("测试数据库成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmx?serverTimezone=GMT&&useSSL=false","root","root");
            System.out.println("数据库连接成功");
            String sql="select * from admin";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("账号");
                String creator=rs.getString("密码");
                Title tl=new Title(id, name, creator);
                list.add(tl);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(rs!=null)
                {
                    rs.close();
                }
                if(psmt!=null)
                {
                    psmt.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
}