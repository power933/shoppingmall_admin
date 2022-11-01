<%@page import="admin.product_sql"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<%
	ArrayList<product_sql> al = (ArrayList<product_sql>)request.getAttribute("al");
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
<p>상품관리 페이지</p>
<div class="subpage_view">
    <span>등록된 상품<%=totalsize %>건</span>
    <span>
        <form>
        <select class="p_select1" id = "sel" name="st">
            <option value = "name">상품명</option>
            <option value = "code">상품코드</option>
        </select>
        <input type="text" class="p_input1" placeholder="검색어를 입력해 주세요" id = "sn" name = "sc">
        <input type="submit" value="검색" title="상품검색" class="p_submit"  onclick="search1()">
        </form>
    </span>
</div>
<div class="subpage_view2">
    <ul>
        <li><input type="checkbox" id = "ck"></li>
        <li>코드</li>
        <li>이미지</li>
        <li>상품명</li>
        <li>카테고리 분류</li>
        <li>판매가격</li>
        <li>할인가격</li>
        <li>할인율</li>
        <li>재고현황</li>
        <li>판매유/무</li>
        <li>품절</li>
        <li>관리</li>
    </ul>
    <%
    	if(al.size()!=0){
    %>
    <%for(int i =0; i<al.size();i++){ %>
    <ul>
        <li><input type="checkbox" class="abc" id ="<%="ck"+i %>" value="<%=al.get(i).getIdx()%>"></li>
        <li><%=al.get(i).getPcode() %></li>
        <li><img src="<%=al.get(i).getPimg1() %>" style="height:90%; width:90%;"></li>
        <li><%=al.get(i).getPname() %></li>
        <li><%=al.get(i).getPlarge_cate()+al.get(i).getPsmall_cate() %></li>
        <li><%=al.get(i).getPprice() %></li>
        <li><%=al.get(i).getPsale() %></li>
        <li><%=al.get(i).getPpercent() %></li>
        <li><%=al.get(i).getPstock() %></li>
        <li><%=al.get(i).getPuse() %></li>
        <li><%=al.get(i).getPsoldout() %></li>
        <li>관리</li>
    </ul>
    <%}}else{ %>
    <ul>
        <li style="width: 100%;">등록된 상품이 없습니다.</li>
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
    <input type="button" value="선택상품 삭제" title="선택상품 삭제" class="p_button" onclick="del()">
    <span style="float: right;">
    <input type="button" value="신규상품 등록" title="신규상품 등록" class="p_button p_button_color1" onclick="newprodcut()">
    <input type="button" value="카테고리 등록" title="카테고리 등록" class="p_button p_button_color2" onclick="newcate()">
    </span>
</div>

<script>

function newprodcut() {
	location.href="admin_product_write";
}

function newcate() {
	location.href="admin_category";
}

function search1() {
	var sc = document.getElementById("sn").value
	if(sc==""){
		alert("검색어를 입력해주세요");
	}
	else{
		f.method="GET";
		f.action="product_search.do";
}
}

function movepage(i) {
	var b = "<%=cst%>";
	var a = "<%=csc%>";
	if(i<1){
		i = 1;
	}
	if(i><%=limitpageno%>){
		i = <%=limitpageno%>;
	}
	if(<%=cst%> == null){
		location.href="admin_product?pageno="+i;
	}
	else{
		location.href="product_search.do?pageno="+i+"&sc="+a+"&st="+b;
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
	location.href="product_delete.do?idx="+pgn;
}

</script>
