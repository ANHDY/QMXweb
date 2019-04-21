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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		messages user = new messages();
		//获取register.jsp页面提交的账号和密码
		String name = request.getParameter("zhanghao");
		String password = request.getParameter("password");
		
		//获取register.jsp页面提交的账号和密码设置到实体类中
		user.setName(name);
		user.setPassword(password);
		
		//引入数据交互层
		UserDao dao = new UserDao();
		
		String forward = null;
		boolean flag = dao.register(user);
		if(flag){
			forward = "/D_qmx/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
			
		}
		
	}

}
