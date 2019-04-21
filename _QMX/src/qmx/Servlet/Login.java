package qmx.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qmx.User.messages;
import qmx.Utils.UserDao;


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
		
		messages user= new messages();
		//获取用户名和密码 
		String name = request.getParameter("zhanghao"); 
		String password = request.getParameter("password"); 
		//测试数据
		
		//获取login.jsp页面提交的账号和密码设置到实体类中
		user.setName(name);
		user.setPassword(password);
		
		//引入数据交互层，获取UserDao实例 
		UserDao dao = new UserDao(); 
		messages us = dao.login(user);
//		//测试返回的值
//		System.out.println(us);
		
		String forward = null;
		// 判断user是否为空 
		if(us != null){ 
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
		doGet(request, response);
	}
}
