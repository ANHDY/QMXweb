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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Connection con = null;
		int id = Integer.valueOf(request.getParameter("序号"));
		UserDao sImpl = new UserDao();
		try {
			con = qmxDao.getConnection();
			Users user = sImpl.selects(con, id);
			request.setAttribute("user", user);
			String forward = "/D_qmx/correct.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
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
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("username");
		String xuehao = request.getParameter("xuehao"); 
		String xueyuan = request.getParameter("xueyuan");
		String zhuanye = request.getParameter("zhuanye");
		String qq = request.getParameter("qq"); 
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");
		
		Users user = new Users();
		user.setId(id);
		user.setName(new String(name.getBytes("UTF-8")));
		user.setXuehao(new String(xuehao.getBytes("UTF-8")));
		user.setXueyuan(new String(xueyuan.getBytes("UTF-8")));
		user.setZhuanye(new String(zhuanye.getBytes("UTF-8")));
		user.setQq(new String(qq.getBytes("UTF-8")));
		user.setPhone(new String(phone.getBytes("UTF-8")));
		user.setSex(new String(sex.getBytes("UTF-8")));
		user.setHobby(new String(hobby.getBytes("UTF-8")));
		
		UserDao dao = new UserDao();
		String forward = null;
		System.out.println(user.getId());
		boolean flag;
		try {
			flag = dao.updates(con,user);
			if(flag){
				forward = "/D_qmx/success.jsp";
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
