package qmx.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.adminEntity;
import qmx.DAOImpl.adminDaoImpl;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		adminEntity admin= new adminEntity();
		//获取用户名和密码 
		String name = request.getParameter("zhanghao"); 
		String password = request.getParameter("password"); 
		//测试数据
		
		//获取login.jsp页面提交的账号和密码设置到实体类中
		admin.setUsername(name);
		admin.setPassword(password);
		
		//引入数据交互层，获取UserDao实例 
		adminDaoImpl adminDao = new adminDaoImpl();
		adminEntity admins;
		String forward = null;
		try {
			admins = adminDao.adminLogin(admin);
			if(admins != null){ 
				// 转发到success.jsp页面 
				forward = "/D_qmx/success.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}else{
				// 登录失败
				forward = "/D_qmx/error.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		UserDao dao = new UserDao(); 
//		messages us = dao.login(admin);
//		//测试返回的值
//		System.out.println(us);
		
		doGet(request, response);
	}
}
