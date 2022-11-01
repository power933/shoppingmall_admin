<%@page import="admin.category_sql"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<%
	ArrayList<category_sql> al = (ArrayList<category_sql>)request.getAttribute("al");
	String limitpageno = String.valueOf(request.getAttribute("limitpageno"));
	String pageea =  String.valueOf(request.getAttribute("pageea"));
	String totalsize = String.valueOf(request.getAttribute("totalsize"));
	String pageno = request.getParameter("pageno");
	if(limitpageno == null){
		limitpageno = "1";
	}
	if(pageno==null){
		pageno="1";
	}
	if(pageea == null){
		pageea = "5";
	}
	int pno = Integer.parseInt(pageno);
	String cst = request.getParameter("st");
	String csc = request.getParameter("sc"); 
%>
<meta charset="UTF-8">
<p>카테고리관리 페이지</p>
<div class="subpage_view">
    <span>등록된 카테고리 <%=totalsize %>건</span>
    <span>
        <select class="p_select1" id = "sel" name="st">
            <option value = "name">카테고리명</option>
            <option value = "code">카테고리코드</option>
        </select>
        <input type="text" class="p_input1" id = "sn" name = "sc" placeholder="검색어를 입력해 주세요">
        <input type="submit" value="검색" title="카테고리 검색" class="p_submit" onclick="search1()">
    </span>
</div>
<div class="subpage_view2">
    <ul>
        <li><input type="checkbox" id = "ck"></li>
        <li>분류코드</li>
        <li>대메뉴 코드</li>
        <li>대메뉴명</li>
        <li>소메뉴 코드</li>
        <li>소메뉴명</li>
        <li>사용 유/무</li>
        <li>관리</li>
    </ul>
    <%
    	if(al.size()!=0){
    	for(int i =0; i<al.size();i++){
    %>
    <ul>
        <li><input type="checkbox" class="abc" id ="<%="ck"+i %>" value="<%=al.get(i).getIdx()%>"></li>
        <li style="text-align: left; text-indent: 5px;"><%=al.get(i).getCtotal_cate() %></li>
        <li><%=al.get(i).getClarge_cate() %></li>
        <li style="text-align: left; text-indent: 5px;"><%=al.get(i).getClarge_name() %></li>
        <li><%=al.get(i).getCsmaill_cate() %></li>
        <li style="text-align: left; text-indent: 5px;"><%=al.get(i).getCsmaill_name() %></li>
        <li><%=al.get(i).getCuse() %></li>
        <li>[수정]</li>
    </ul>
    <%}}else{ %>
    <ul>
        <li style="width: 100%;">등록된 카테고리가 없습니다.</li>
    </ul>
    <%} %>
</div>
<div class="subpage_view3">
    <ul class="pageing">
        <li><img src="./ico/double_left.svg"></li>
        <li onclick="movepage(<%=pno-1%>)"><img src="./ico/left.svg"></li>
        <%for(int i =1;i<=Integer.parseInt(limitpageno);i++){ %>
        <li onclick="movepage(<%=i%>)"><%=i %></li>
        <%} %>
        <li onclick="movepage(<%=pno+1%>)"><img src="./ico/right.svg"></li>
        <li><img src="./ico/double_right.svg"></li>
    </ul>
</div>
<div class="subpage_view4">
    <input type="button" value="카테고리 삭제" title="카테고리 삭제" class="p_button" onclick = "del()">
    <span style="float: right;">
    <input type="button" value="상품 리스트" title="상품 리스트" class="p_button p_button_color1" onclick="goproductlist()">
    <input type="button" value="카테고리 등록" title="카테고리 등록" class="p_button p_button_color2" onclick="registercate()">
    </span>
</div>

<script>
function goproductlist() {
	location.href="admin_product";
}
function registercate() {
	location.href="admin_category_write";
}
function search1() {
	var sc = document.getElementById("sn").value
	if(sc==""){
		alert("검색어를 입력해주세요");
	}
	else{
		f.method="GET";
		f.action="cate_search.do";
}
}

function movepage(i) {
	var b = <%=cst%>;
	var a = <%=csc%>;
	if(i<1){
		i = 1;
	}
	if(i><%=limitpageno%>){
		i = <%=limitpageno%>;
	}
	if(<%=cst%> == null){
		location.href="admin_category?pageno="+i;
	}
	else{
		location.href="cate_search.do?pageno="+i+"&sc="+a+"&st="+b;
	}
}

$( document ).ready( function() {
    $("#ck").click( function() {
      $('.abc').prop('checked', this.checked );
    } );
  } );

function del() {
	var pgn = "";
	var x = "<%=pageea%>";
	if(<%=al.size()%> < <%=pageea%>){
		x = <%=al.size()%>;
	}
	for(var i = 0; i< x;i++){
		var ck = document.getElementById("ck"+i);
		if(ck.checked){
			pgn += ck.value+"_";
		}
	}
	location.href="cate_delete.do?idx="+pgn;
}

</script>

