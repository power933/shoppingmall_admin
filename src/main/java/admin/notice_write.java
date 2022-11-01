package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public notice_write() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<String> al = new ArrayList<>();
		Enumeration em = request.getParameterNames();
		tools t = new tools();
		String time = t.time();
		while(em.hasMoreElements()) {
			String a = (String)em.nextElement();
			String b = request.getParameter(a);
			if(a.equals("nfileurl")) {
				if(b.equals("")) {
					b = "nofile";
				}
			}
			al.add(b);
		}
		al.add(time);
		notice_insert ni = new notice_insert();
		
		
		if(ni.insert(al)) {
			out.print("<script>alert('작성완료');location.href='admin_notice.jsp';</script>");
		}
		else {
			out.print("<script>alert('작성실패');history.go(-1);</script>");
		}
	
	}

}
