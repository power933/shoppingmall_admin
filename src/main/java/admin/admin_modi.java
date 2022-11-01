package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/admin_modi.do")
public class admin_modi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<String> al = new ArrayList<String>();
		
		Enumeration em = request.getParameterNames();
		String tel = "";
		while(em.hasMoreElements()) {
			String a = (String)em.nextElement();
			String b = request.getParameter(a);
			if(a.equals("tel0")||a.equals("tel1")||a.equals("tel2")) {
				tel += b;
				if(a.equals("tel2")) {
					al.add(tel);
				}
				continue;
			}
			if(a.equals("aindate")) {
				String c = b.substring(0,19);
				al.add(c);
				continue;
			}
			al.add(b);
		}
		
		String id = request.getParameter("aid");
		al.add(id);
		admin_modify am = new admin_modify();
		if(am.select(al, 2)) {
			out.print("<script>alert('수정성공');location.href='admin_list';</script>");
		}else {
			out.print("<script>alert('수정실패');history.go(-1);</script>");
		}
		
	}

}
