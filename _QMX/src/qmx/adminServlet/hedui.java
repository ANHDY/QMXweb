package qmx.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qmx.Dao.qmxDao;

/**
 * Servlet implementation class hedui
 */
@WebServlet("/hedui")
public class hedui extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		String xuehao = request.getParameter("xuehao");
		PrintWriter pw = response.getWriter();
		
		qmxDao qmxdao = new qmxDao();
		boolean check = qmxdao.check(xuehao);
		pw.println(check);
	}

}
