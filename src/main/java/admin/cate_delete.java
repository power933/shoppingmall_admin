package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cate_delete.do")
public class cate_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cate_delete() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String idx = request.getParameter("idx");
		String[] arr = idx.split("_");
		
		category_sql cs = new category_sql();
		product_sql ps = new product_sql();
		int t = 0;
		int f = 0;
		for(int i = 0; i<arr.length;i++) {
			ArrayList<category_sql> al = cs.select("idx", arr[i], "", "");
			ps.delete("lcate", al.get(0).getClarge_cate(),al.get(0).getCsmaill_cate());
			boolean b = cs.delete(arr[i]);
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
			out.print("<script>alert('성공');location.href='admin_category';</script>");
		}
		
	}

}
