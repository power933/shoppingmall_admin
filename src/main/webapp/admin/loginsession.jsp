<%@page import="java.util.ArrayList"%>
<%@page import="admin.select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String aid = request.getParameter("aid");
	select s = new select();
	ArrayList<select> al = s.selec(1, aid,"a"); 
	
	String aname = al.get(0).getAname();
	session.setAttribute("aname", aname);
	session.setAttribute("aid", aid);
	
%>
<script type="text/javascript">
window.onload = function name1() {
	location.href = "admin_list";
}
</script>
</body>
</html>