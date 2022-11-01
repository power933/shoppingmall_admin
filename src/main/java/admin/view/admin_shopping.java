package admin.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.coupon_sql;

@WebServlet("/admin/admin_shopping")
public class admin_shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_shopping() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	
    	coupon_sql cs = new coupon_sql();
    	ArrayList<coupon_sql> al = cs.select();
    	
    	req.setAttribute("al", al);
    	
    	RequestDispatcher rd = req.getRequestDispatcher("admin_shopping.jsp");
    	rd.forward(req, resp);
    }
}
