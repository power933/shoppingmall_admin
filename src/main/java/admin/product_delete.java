package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/product_delete.do")
public class product_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public product_delete() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String idx = request.getParameter("idx");
		String[] arr = idx.split("_");
		
		product_sql ps = new product_sql();
		int t = 0;
		int f = 0;
		for(int i = 0; i<arr.length;i++) {
			boolean b = ps.delete("idx",arr[i],"");
			if(b) {
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
			out.print("<script>alert('성공');location.href='admin_product';</script>");
		}
		
	}

}
