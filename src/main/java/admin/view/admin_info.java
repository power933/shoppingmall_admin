package admin.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.select;



@WebServlet("/admin/admin_info.do")
public class admin_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	HttpSession session = req.getSession();
    	String aid = (String)session.getAttribute("aid");
    	
    	select s = new select();
    	ArrayList<select> al = s.selec(1, aid, aid);
    	req.setAttribute("al", al);
    	
    	RequestDispatcher rd = req.getRequestDispatcher("admin_info.jsp");
    	rd.forward(req, resp);
	}
	
}
