package qmx.stuServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qmx.DAOImpl.stuDaoImpl;
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
		
		stuDaoImpl xueSearch = new stuDaoImpl();
		boolean check = false;
		try {
			check = xueSearch.xuehaoSearch(xuehao);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println(check);
	}

}
