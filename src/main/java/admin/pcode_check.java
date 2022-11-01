package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/pcode_check")
public class pcode_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public pcode_check() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String msg = "no";
		String code = request.getParameter("code");
		product_sql ps = new product_sql();
		ArrayList<product_sql> al = ps.select("codeck", code, "", "");
		if(al.size()==0) {
			msg = "ok";
		}
		out.print(msg);
		
	}


}









