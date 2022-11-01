package admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/admin/product_inse")
@MultipartConfig(
		maxFileSize=1024*1024*1024
		)
public class product_inse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	tools t = new tools();
    	
    	ArrayList<String> al = new ArrayList<String>();
    	ArrayList<String> tmp = new ArrayList<String>();
    	category_sql cs = new category_sql();
    	ArrayList<category_sql> cateck = null;
    	boolean xx = true;
    	
    	String realpath = request.getServletContext().getRealPath("");
    	String projectpath = request.getServletContext().getContextPath();
		String path = realpath+"images/";
		String createfile = "/images/";
		
    	
    	String ftime = t.time2();
    	Collection <Part> parts = request.getParts();
    	
		for(Part file : parts) {
		String filecheck  =file.getName();
		String filetext = request.getParameter(filecheck);
		if(filecheck.equals("pimg1")||filecheck.equals("pimg2")||filecheck.equals("pimg3")) {
			String originName = file.getSubmittedFileName();
			if(originName==null||originName=="") {						
				filetext="";
			}
			else {
				filetext= path+ftime+originName;						
				File fe = new File(path);
				if(!fe.exists()) {fe.mkdir();}
				file.write(filetext);
				filetext="http://power933.cafe24.com"+projectpath+createfile+ftime+originName;
			}
			tmp.add(filetext);
			System.out.println(tmp);
		}
		else {
			if(filecheck.equals("plarge_cate")) {
    			if(cs.select("lck",filetext,"","").size()==0) {
    				xx = false;
    			}
    		}
    		if(filecheck.equals("psmall_cate")) {
    			if(cs.select("sck",filetext,"","").size()==0) {
    				xx = false;
    			}
    		}
    		al.add(filetext);
		}
		}
		al.addAll(tmp);
    	al.add("0");
    	al.add(t.time());
    	
    	product_sql ps = new product_sql();
    	if(xx) {
	    	if(ps.insert(al, "")) {
	    		out.print("<script>alert('등록성공');location.href='admin_product';</script>");
	    	}
	    	else {
	    		out.print("<script>alert('등록실패');history.go(-1);</script>");
	    	}
	    }
    	else {
    		out.print("<script>alert('카테고리 등록을 해주세요');history.go(-1);</script>");
    	}
    	
	}

}
