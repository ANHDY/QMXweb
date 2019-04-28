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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		adminEntity admin = new adminEntity();
		//获取register.jsp页面提交的账号和密码
		String name = request.getParameter("zhanghao");
		String password = request.getParameter("password");
		
		//获取register.jsp页面提交的账号和密码设置到实体类中
		admin.setUsername(name);
		admin.setPassword(password);
		
		//引入数据交互层
		adminDaoImpl adminRegister = new adminDaoImpl();
		
		String forward = null;
		try {
			adminRegister.adminRegister(admin);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forward = "/D_qmx/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
			
		
	}

}
