package admin.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product_sql;

@WebServlet("/admin/admin_product")
public class admin_product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
	    	resp.setContentType("text/html; charset=UTF-8");
	    	
	    	String pno = req.getParameter("pageno");
	    	if(pno == null || pno.equals("")) {
	    		pno = "1";
	    	}
	    	int pageno = Integer.parseInt(pno);
	    	product_sql ps = new product_sql();
	    	ArrayList<product_sql> tmplist = ps.select("0","0","0","0");
	    	int pageea = 5;
	    	int totalsize = tmplist.size();
	    	int limitpageno = (int) Math.ceil((double)totalsize/pageea);
	    	int tmp = (pageno-1)*pageea;
	    	String r1 = String.valueOf(tmp);
	    	String r2 = String.valueOf(pageea);
	    	
	    	ArrayList<product_sql> al = ps.select("limit",r1,r2,"");
	    	
	    	req.setAttribute("al", al);
	    	req.setAttribute("limitpageno", limitpageno);
	    	req.setAttribute("pageea", pageea);
	    	req.setAttribute("totalsize", totalsize);
	    	RequestDispatcher rd = req.getRequestDispatcher("admin_product.jsp");
	    	rd.forward(req, resp);
		}
}










