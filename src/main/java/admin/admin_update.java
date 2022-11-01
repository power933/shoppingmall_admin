package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("aid");
		String yn = request.getParameter("ayn");
		PrintWriter out = response.getWriter();
		ArrayList<String> al = new ArrayList<String>();
		al.add(yn);
		al.add(id);
		if(id.equals("admin")) {
			out.print("<script>location.href='admin_main.jsp';alert('수정불가');</script>");
		}
		else {
		update u = new update();
		if(u.update_yn(al)) {
			out.print("<script>location.href='admin_main.jsp';alert('수정완료');</script>");
		}
		else {
			out.print("<script>alert('수정실패');</script>");
		}
		}
	}

}
