package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_list() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		select s = new select();
		String aid = request.getParameter("aid");
		ArrayList<select> al = s.selec(1,aid,"a");
		request.setAttribute("ainfo", al);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("admin_header.jsp");
		rd.forward(request, response);
	}

}






