package qmx.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Users user = new Users();
		String name = request.getParameter("username");
		String xuehao = request.getParameter("xuehao"); 
		String xueyuan = request.getParameter("xueyuan");
		String zhuanye = request.getParameter("zhuanye");
		String qq = request.getParameter("qq"); 
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");

		user.setName(name);
		user.setXuehao(xuehao);
		user.setXueyuan(xueyuan);
		user.setZhuanye(zhuanye);
		user.setQq(qq);
		user.setPhone(phone);
		user.setSex(sex);
		user.setHobby(hobby);
		
		UserDao dao = new UserDao();
		String forward = null;
		boolean flag = dao.baomings(user);
		if(flag){
			forward = "/D_qmx/hd.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
		
	}

}
