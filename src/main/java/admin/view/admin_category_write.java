package admin.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.setting_select;

@WebServlet("/admin/admin_category_write")
public class admin_category_write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_category_write() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	
    	
    	RequestDispatcher rd = req.getRequestDispatcher("admin_category_write.jsp");
    	rd.forward(req, resp);
    }
}
