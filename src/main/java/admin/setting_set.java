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

public class setting_set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public setting_set() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<String> al = new ArrayList<String>();
		Enumeration em = request.getParameterNames();
		while(em.hasMoreElements()) {
			String a = (String)em.nextElement();
			String b = request.getParameter(a);
			if(a.equals("stn") || a.equals("ssub_bn")) {
				if(b.equals("")|| b==null) {
					b="미등록";
				}
			}
			
			al.add(b);
		}
		setting_update su = new setting_update();
		String msg = "";
		if(su.update(al)) {
			msg = "<script>history.go(-1);alert('저장 성공');</script>";
		}
		else {
			msg = "<script>history.go(-1);alert('저장 실패');</script>";
		}
		out.print(msg);
		
	}

}
