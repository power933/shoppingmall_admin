package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/notice_del.do")
public class notice_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String idx = request.getParameter("idx");
		notice_delete nd = new notice_delete();
		
		String[] idx1 = {idx};
		
		if(nd.delete(idx1).get(0)) {
			out.print("<script>alert('삭제성공');location.href='admin_notice';</script>");
		}else {
			out.print("<script>alert('삭제실패');history.go(-1);</script>");
		}
		
		
	}
	

}
