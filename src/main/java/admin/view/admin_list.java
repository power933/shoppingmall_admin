package admin.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.select;

@WebServlet("/admin/admin_list")
public class admin_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public admin_list() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	
    	select s = new select();
    	ArrayList<select> al = s.selec(0,"0","5");
    	
    	
    	double total = al.size();
    	String aa = req.getParameter("list_num");
    	if(aa == null || aa==""){
    		aa="5";
    	}
    	int listea = Integer.parseInt(aa);


    	double lastpg = Math.ceil(total/listea);
    	String pageno = req.getParameter("pageno");

    	if(pageno == null){
    		pageno = "1";
    	}
    	int pn = Integer.parseInt(pageno);
    	int start = (pn-1)*listea;
    	String st = String.valueOf(start);
    	String le = String.valueOf(listea);
    	ArrayList<select> ar = s.selec(2, st, le);
    	
    	req.setAttribute("al", al);
    	req.setAttribute("ar", ar);
    	
    	RequestDispatcher rd = req.getRequestDispatcher("admin_main.jsp");
    	rd.forward(req, resp);
    	
    }
}
