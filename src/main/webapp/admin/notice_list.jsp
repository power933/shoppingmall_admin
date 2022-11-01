<%@page import="java.util.ArrayList"%>
<%@page import="admin.notice_select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<%
	notice_select ns = new notice_select();
	ArrayList<notice_select> al = ns.select(0,0,0);
	ArrayList<notice_select> tal = ns.select(3,0,0);
	int maxpage = tal.size();
	String pagenum = "5";
	int pnum = Integer.valueOf(pagenum);
	String pageno = request.getParameter("pageno");
	if(pageno == null){
		pageno = "1";
	}
	int pno = Integer.parseInt(pageno);
	double tpn = Double.parseDouble(pagenum);
	
	ArrayList<notice_select> ar = ns.select(2, (int)((pno-1)*tpn) ,(int)tpn);
	int limitpage = (int)Math.ceil(maxpage/tpn);
	
	int tsize = (int)tpn+ar.size();
	int cnt = 0;
%>
<p>공지사항 관리페이지</p>
<div class="subpage_view">

<ul>
    <li><input type="checkbox" id="ck"  ></li>
    <li>NO</li>
    <li>제목</li>
    <li>글쓴이</li>
    <li>날짜</li>
    <li>조회</li>
</ul>


<%
int ttlist = 0;
if(al.size() != 0){
	for(int i = 0; i<al.size();i++){
		if(al.get(i).getNuse_notice().equals("y")){
	%>
	<ol >
    <li><input type="checkbox" class="ab" id="<%="ck"+(cnt+pnum) %>" value ="<%=al.get(i).getIdx()%>"></li>
    <li>중요공지</li>
    <li onclick = "gowriting(<%=al.get(i).getIdx()%>)" ><%=al.get(i).getNtitle() %></li>
    <li><%=al.get(i).getNwriter() %></li>
    <li><%=al.get(i).getNdate().substring(0,19) %></li>
    <li><%=al.get(i).getNcount() %></li>
</ol>
<%
cnt++;

}} %>
	<%
	int count = 0;
	for(int i =0;i<ar.size();i++){
	%>
<ol>
    <li><input type="checkbox" class="ab" id =<%="ck"+i %> value ="<%=al.get(i).getIdx()%>" ></li>
    <li><%=(int)(maxpage -((pno-1)*tpn)-i) %></li>
    <li onclick = "gowriting(<%=ar.get(i).getIdx()%>)"><%=ar.get(i).getNtitle() %></li>
    <li><%=ar.get(i).getNwriter() %></li>
    <li><%=ar.get(i).getNdate().substring(0,19) %></li>
    <li><%=ar.get(i).getNcount() %></li>
</ol>
<%
ttlist = cnt+pnum;
}}else{ %>
<ol class="none_text">
    <li>등록된 공지 내용이 없습니다.</li>
</ol>
<%} %>
</div>
<div class="board_btn">
    <button class="border_del" onclick = "del()">공지삭제</button>
    <button class="border_add" onclick = "gonp()">공지등록</button>
</div>
<div class="border_page">
    <ul class="pageing">
        <li><img src="./ico/double_left.svg"></li>
        <li onclick="gopage(<%=pno-1%>)"><img src="./ico/left.svg"></li>
<%for(int i =1; i<=limitpage;i++) {%>
        <li onclick ="gopage(<%=i %>)"><%=i %></li>
    <%} %>
        <li onclick="gopage(<%=pno+1%>)"><img src="./ico/right.svg"></li>
        <li><img src="./ico/double_right.svg"></li>
    </ul>
</div>

<script>
function gopage(i) {
	if(i>=<%=limitpage%>){
		i = <%=limitpage%>;
	}
	else if(i<=0){
		i = 1;
	}
	location.href = "./admin_notice.jsp?pageno="+i;
}

// function allck() {
// 	for(var i = 0; i<5;i++){
// 	var cb = document.getElementById("ck")+i;
// 	var cc = document.getElementById("ck")
// 	if(cc)
// 	}
// }

$( document ).ready( function() {
    $("#ck").click( function() {
      $('.ab').prop('checked', this.checked );
    } );
  } );
  
  
function gonp() {
	location.href = "./admin_notice_write";
}
function gowriting(idx) {
	location.href = "admin_notice_write?idx="+idx;
}

function del() {
	var pgn = "";
	var x = <%=ttlist%>;
	if(<%=ar.size()%> <5){
		x = <%=ar.size()%>;
	}
	for(var i = 0; i< x;i++){
		var ck = document.getElementById("ck"+i);
		if(ck.checked){
			pgn += ck.value+"_";
		}
	}
	location.href="admin_del.do?idx=" +pgn;
}

</script>