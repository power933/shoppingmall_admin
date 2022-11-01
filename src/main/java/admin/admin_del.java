package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_del() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String idx = request.getParameter("idx");
		String list[] = idx.split("_");
		
		notice_delete nd = new notice_delete();
		ArrayList<Boolean> bl = nd.delete(list);
		int t = 0;
		int f = 0;
		for(int i = 0; i<bl.size();i++) {
			if(bl.get(i)) {
				t++;
			}
			else {
				f++;
			}
		}
		if(f>0) {
			out.print("<script>alert('"+f+"개의 쿼리 실패');history.go(-1);</script>");
		}
		else {
			out.print("<script>alert('성공');location.href='admin_notice';</script>");
		}
		
	}


}
