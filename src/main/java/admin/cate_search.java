package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cate_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cate_search() {
    }
    
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	
    	String a = "";
		String st = req.getParameter("st");
		String sc = req.getParameter("sc");
		
		String pno = req.getParameter("pageno");
    	if(pno == null || pno.equals("")) {
    		pno = "1";
    	}
    	int pageno = Integer.parseInt(pno);
    	category_sql cs = new category_sql();
    	ArrayList<category_sql> tmplist = cs.select(st,sc,"0","all");
    	int pageea = 5;
    	int totalsize = tmplist.size();
    	int limitpageno = (int) Math.ceil((double)totalsize/pageea);
    	int tmp = (pageno-1)*pageea;
    	String r1 = String.valueOf(tmp);
    	String r2 = String.valueOf(pageea);
    	
    	ArrayList<category_sql> al = cs.select(st,sc,r1,r2);
    	req.setAttribute("al", al);
    	req.setAttribute("limitpageno", limitpageno);
//    	req.setAttribute("pageea", pageea);
    	req.setAttribute("totalsize", totalsize);
    	RequestDispatcher rd = req.getRequestDispatcher("admin_category.jsp");
    	rd.forward(req, resp);
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String a = "";
//		String st = request.getParameter("st");
//		String sc = request.getParameter("sc");
//		category_sql cs = new category_sql();
//		ArrayList<category_sql> al = cs.select(st, sc);
		
		
		
	}


}
