package qmx.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qmx.Dao.qmxDao;
import qmx.User.Users;
import qmx.Utils.UserDao;

/**
 * Servlet implementation class updates
 */
@WebServlet("/stuUpdate")
public class stuUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stuUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		Connection con = null;
		try {
			con = qmxDao.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = request.getParameter("username");
		String xuehao = request.getParameter("xuehao"); 
		String xueyuan = request.getParameter("xueyuan");
		String zhuanye = request.getParameter("zhuanye");
		String qq = request.getParameter("qq"); 
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");
		
		Users user = new Users();
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
		boolean flag;
		try {
			flag = dao.stuUpdates(con,user);
			if(flag){
				forward = "/D_qmx/hd.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}
			else{
				forward = "/D_qmx/error.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
