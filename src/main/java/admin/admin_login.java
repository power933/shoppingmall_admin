package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_login() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String id = request.getParameter("aid");
		String pass = request.getParameter("apass");
		ArrayList<String> list = new ArrayList<String>();
		tools t = new tools();
		
		list.add(id);
		list.add(t.time());
		admin_modify am = new admin_modify();
		
		select s = new select();
		String msg = "";
		ArrayList<select> al = s.selec(0,"a","a");
		for(int i =0; i<al.size();i++) {
			if(id.equals(al.get(i).getAid())) {
				if(pass.equals(al.get(i).getApass())) {
					if(al.get(i).getAuseable().equals("N")) {
						msg = "<script>alert('허가되지 않은 사용자 입니다');history.go(-1);</script>";
						break;
					}
					boolean b = am.select(list,1);
					msg = "<script>alert('로그인성공');location.href='loginsession.jsp?aid="+al.get(i).getAid()+"';</script>";
					break;
				}
				else {
					msg = "<script>alert('로그인실패(pw)');history.go(-1);</script>";
				}
			}
			else {
				msg = "<script>alert('로그인실패(id)');history.go(-1);</script>";
			}
		}
		
		pw.print(msg);
	}

}






