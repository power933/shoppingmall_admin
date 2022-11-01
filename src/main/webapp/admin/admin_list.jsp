<%@page import="java.util.ArrayList"%>
<%@page import="admin.select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
select s = new select();
ArrayList<select> al = s.selec(0,"0","5");
double total = al.size();
String aa = request.getParameter("list_num");
if(aa == null || aa==""){
	aa="5";
}
int listea = Integer.parseInt(aa);


double lastpg = Math.ceil(total/listea);
String pageno = request.getParameter("pageno");

if(pageno == null){
	pageno = "1";
}
int pn = Integer.parseInt(pageno);
int start = (pn-1)*listea;
String st = String.valueOf(start);
String le = String.valueOf(listea);
ArrayList<select> ar = s.selec(2, st, le);

%>
<p>신규등록 관리자</p>
<ol class="new_admin_title">
    <li>NO</li>
    <li>관리자명</li>
    <li>아이디</li>
    <li>전화번호</li>
    <li>이메일</li>
    <li>담당부서</li>
    <li>담당직책</li>
    <li>가입일자</li>
    <li>승인여부</li>
</ol>
<%if(ar.get(0).getAidx()== null){%>
<ol class="new_admin_none" id = "noadmin">
    <li>신규 등록된 관리자가 없습니다.</li>
</ol>
<%}else{ %>
 <%for(int i =0; i<ar.size();i++){%> 
<ol class="new_admin_lists">
    <li><%=(int)(total-start-i) %> </li>
    <li><%=ar.get(i).getAname() %></li>
    <li><%=ar.get(i).getAid() %></li>
    <li><%=ar.get(i).getAtel() %></li>
    <li><%=ar.get(i).getAemail() %></li>
    <li><%=ar.get(i).getApart() %></li>
    <li><%=ar.get(i).getAposition() %></li>
    <li><%=ar.get(i).getAindate().substring(0,ar.get(i).getAindate().length()-2) %></li>
    <li>
        <input type="button" value="승인" class="new_addbtn1" title="승인" onclick="accp('<%=ar.get(i).getAid() %>')">
        <input type="button" value="미승인" class="new_addbtn2" title="미승인" onclick="reject('<%=ar.get(i).getAid() %>')">
    </li>
</ol>
<%}} %>
<br>
<ul>
<%
int w = 1;
while(w<=lastpg){
	%>
	<li id="li" onclick="topage(<%=w%>)" style="border:1px solid #ccc; cursor:pointer; width: 30px; line-height: 30px; text-align: center; float:left;"><%=w %></li>
	
<%w++;}%>
</ul>

<select id = "sel" onchange="oc()">
	<option value="3">3개</option>
	<option selected value="5">5개</option>
	<option value="10">10개</option>
</select>

<script type="text/javascript">
function accp(id) {
	location.href="admin_update.do?aid="+id+"&ayn=Y";
	
}
function reject(id) {
	location.href="admin_update.do?aid="+id+"&ayn=N";
}

function topage(a) {
	var b = <%=listea%>
	location.href="admin_main.jsp?pageno="+a+"&list_num="+b;
}

function oc() {
	var a = <%=pageno %>
	var b = document.getElementById("sel").value;
	location.href="admin_main.jsp?pageno="+a+"&list_num="+b;
}

</script>
