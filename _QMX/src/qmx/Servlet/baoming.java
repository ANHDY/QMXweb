package qmx.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.stuEntity;
import qmx.DAOImpl.stuDaoImpl;
import qmx.User.Users;
import qmx.Utils.UserDao;

/**
 * Servlet implementation class baoming
 */
@WebServlet("/baoming")
public class baoming extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		stuEntity stu = new stuEntity();
		String name = request.getParameter("username");
		String xuehao = request.getParameter("xuehao"); 
		String xueyuan = request.getParameter("xueyuan");
		String zhuanye = request.getParameter("zhuanye");
		String qq = request.getParameter("qq"); 
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");

		stu.setName(name);
		stu.setXuehao(xuehao);
		stu.setXueyuan(xueyuan);
		stu.setZhuanye(zhuanye);
		stu.setQq(qq);
		stu.setPhone(phone);
		stu.setSex(sex);
		stu.setHobby(hobby);
		
		stuDaoImpl stuDao = new stuDaoImpl();
		String forward = null;
		try {
			stuDao.addStu(stu);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		forward = "/D_qmx/hd.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	}

}
