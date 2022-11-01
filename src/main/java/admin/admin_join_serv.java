package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_join_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_join_serv() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		Enumeration em = request.getParameterNames();
		ArrayList<String> al = new ArrayList<String>();
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
			al.add(b);
		}
		admin_modify am = new admin_modify();
		boolean x = am.select(al,0);
		if(x) {
			pw.print("<script>alert('가입요청성공');location.href='index.html';</script>");
		}
		else {
			pw.print("<script>alert('가입요청실패');history.go(-1);</script>");
		}
		
		
	}

}
