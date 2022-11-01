package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(	
		fileSizeThreshold = 1024 * 1024 * 1,
		maxFileSize = 1024 * 1024 * 2, 
		maxRequestSize =  1024 * 1024 * 2	
		)
@WebServlet("/admin/coupon_insert")
public class coupon_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public coupon_insert() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	
    	ArrayList<String> al = new ArrayList<String>();
    	Enumeration em = request.getParameterNames();
    	while(em.hasMoreElements()) {
    		String a = (String)em.nextElement();
    		String b = URLDecoder.decode(request.getParameter(a),"UTF-8");
    		if(a.equals("cstart_date")) {
    			b+=" 00:00:00";
    		}
    		if(a.equals("cend_date")) {
    			b+=" 23:59:59";
    		}
    		if(a.equals("cimg")) {
//    			continue;
    		}
    		al.add(b);
    	}
//    	Part part = request.getPart("cimg");
//		String filename = part.getSubmittedFileName();
//		
//		if(filename == "") {
//			filename = "nofile";
//		}else {
//			String path = request.getServletContext().getRealPath("");
//			String upload = path + "upload/";	//실제 저장 공간
//			String url = upload + filename;
//			String url2 = url.replace("/power933/tomcat/webapps",".");	//db경로
//			
//			for(Part p : request.getParts()) {
//				p.write(upload + filename);
//			}
//			filename = url;
//		}
//		al.add(filename);
    	
		coupon_sql cs = new coupon_sql();
		if(cs.insert(al, "")) {
			out.print("<script>alert('성공');location.href='admin_shopping';</script>");
		}
		else {
			out.print("<script>alert('성공');history.go(-1);</script>");
		}
		
	}

}
