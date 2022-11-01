package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String idx = request.getParameter("idx");
		ArrayList<String> al = new ArrayList<>();
		Enumeration em = request.getParameterNames();
		
		while(em.hasMoreElements()) {
			String a = (String)em.nextElement();
			String b = request.getParameter(a);
			if(a.equals("nfileurl")) {
				if(b.equals("")) {
					b = "nofile";
				}
			}
			if(a.equals("idx")) {
				continue;
			}
			al.add(b);
		}
		notice_insert ni = new notice_insert();
		if(ni.update(al,idx)==true) {
			out.print("<script>alert('입력성공');location.href='admin_notice';</script>");
		}else {
			out.print("<script>alert('입력실패');history.go(-1);</script>");
		}
		
		
		
	}


}
