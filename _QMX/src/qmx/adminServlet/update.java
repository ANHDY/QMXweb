package qmx.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.stuEntity;
import qmx.DAOImpl.adminDaoImpl;

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

		int id = Integer.valueOf(request.getParameter("序号"));
		adminDaoImpl adminSelect = new adminDaoImpl();
		try {
			stuEntity stu = adminSelect.adminSelect(id);
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("/D_qmx/correct.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("username");
		String xuehao = request.getParameter("xuehao"); 
		String xueyuan = request.getParameter("xueyuan");
		String zhuanye = request.getParameter("zhuanye");
		String qq = request.getParameter("qq"); 
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");
		
		stuEntity stu = new stuEntity();
		stu.setId(id);
		stu.setName(new String(name.getBytes("UTF-8")));
		stu.setXuehao(new String(xuehao.getBytes("UTF-8")));
		stu.setXueyuan(new String(xueyuan.getBytes("UTF-8")));
		stu.setZhuanye(new String(zhuanye.getBytes("UTF-8")));
		stu.setQq(new String(qq.getBytes("UTF-8")));
		stu.setPhone(new String(phone.getBytes("UTF-8")));
		stu.setSex(new String(sex.getBytes("UTF-8")));
		stu.setHobby(new String(hobby.getBytes("UTF-8")));
		
		adminDaoImpl adminUpdate = new adminDaoImpl();
		String forward = null;
		System.out.println(stu.getId());
		try {
			adminUpdate.adminUpdate(id, stu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forward = "/D_qmx/success.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
