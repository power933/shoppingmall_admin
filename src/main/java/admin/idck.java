package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public idck() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String msg = "no";
		String id = request.getParameter("id");
		select s = new select();
		ArrayList<select> al = s.selec(0,"a","a");
		int w = 0;
		while(w<al.size()) {
			if(id.equals(al.get(w).getAid())) {
				msg = "no";
				break;
			}
			else {
				msg = "ok";
			}
			w++;
		}
		pw.print(msg);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
