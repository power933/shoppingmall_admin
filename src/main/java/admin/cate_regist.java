package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cate_regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cate_regist() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		boolean ck = false;
		ArrayList<String> al = new ArrayList<String>();
		Enumeration em = request.getParameterNames();
		while(em.hasMoreElements()) {
			String a = (String)em.nextElement();
			String b = request.getParameter(a);
			if(a.equals("clarge_only")) {
				if(b.equals("Y")){
					ck = true;
				}
			}
			al.add(b);
		}
		if(ck) {
			al.set(0, al.get(0)+99);
			al.set(4,"99");
			al.set(5,"미사용");
		}
		
		category_sql cs = new category_sql();
		if(cs.select("total", al.get(0), "", "").size()!=0) {
			out.print("<script>alert('중복된 코드입니다');history.go(-1);</script>");
		}
		else {
			if(cs.insert(al)) {
				out.print("<script>alert('저장성공');location.href='admin_category';</script>");
			}
			else {
				out.print("<script>alert('저장실패');location.href='admin_category_write';</script>");
			}
		}
	}

}
