<%@page import="admin.select"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
	session.setMaxInactiveInterval(120*60);
	String aid = (String)session.getAttribute("aid");
	if(aid == null){
		out.print("<script>alert('자동로그아웃되었습니다');location.href='index.jsp';</script>");
	}else{
		select s = new select();
		ArrayList<select> al = s.selec(1, aid,"a"); 
	%>
	<div class="header_div" >
    <p onclick = "gomain()"><img src="./img/logo.png" class="logo_sm" > ADMINISTRATOR</p>
    <p><%=al.get(0).getAname() %> 관리자 <a href="admin_info.do">[개인정보 수정]</a> <a href="logout.jsp">[로그아웃]</a></p>
	</div>
		
	<%} %>
	
<script>
function gomain() {
	location.href="admin_list";
}
</script>