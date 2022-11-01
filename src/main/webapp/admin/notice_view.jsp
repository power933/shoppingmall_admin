<%@page import="java.util.ArrayList"%>
<%@page import="admin.notice_select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
String id = (String)session.getAttribute("aid");
String idx = request.getParameter("idx");
notice_select ns = new notice_select();
int idd = Integer.parseInt(idx);
ArrayList<notice_select> al = ns.select(1, idd, 0);
String name = (String)session.getAttribute("aname");
String ck = "";
if (al.get(0).getNuse_notice().equals("y")){ck="checked";}
%>

<meta charset="UTF-8">
<p>공지사항 VIEW 페이지</p>
<div class="write_view">
<ul>
    <li>공지번호</li>
    <li><%=al.get(0).getIdx() %> 번째 공지글</li>
</ul>
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox" id="aa"<%=ck %>  value="y"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
        <input type = "hidden" name="nuse_notice" value="y">
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" class="notice_input1" name="ntitle" value="<%=al.get(0).getNtitle() %>"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" class="notice_input2" value="<%=name %>" name="nwriter" readonly> ※ 관리자 이름이 노출 됩니다.       
    </li>
</ul>
<ul>
    <li>첨부파일</li>
     <li>
        <input type="file" name="nfileurl"  value=""> ※ 첨부파일 최대 용량은 2MB 입니다.
        <em class="fileview">기존 첨부 파일명 : <%=al.get(0).getNfilurl()%> </em>       
    </li>
</ul>

 
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" placeholder="공지내용을 입력하세요!" id="ta" name="ncontent"> <%=al.get(0).getNcontent()%> </textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button class="border_del" onclick="golist()">공지목록</button>
    <button class="border_add" onclick="modify()">공지수정</button>
    <button class="border_del" onclick="destroy()">공지삭제</button>
</div>

<input type ="hidden" name="ncount" value="5">
<input type = "hidden" name = "idx" value="<%=al.get(0).getIdx()%>">

<script>
function modify() {
	var x = document.getElementById("aa");
	if(x.checked == false){
		f.nuse_notice.value="n";
	}
	else{
		f.nuse_notice.value="y";
	}
	f.action = "post";
	f.action="notice_modify.do";
}

function destroy() {
	if(confirm('정말 삭제하시겠습니까?')){
		f.method = "post";
		f.action = "notice_del.do";
		f.submit();
	}
	else{
		alert('취소하셨습니다');
	}
}
CKEDITOR.replace("ta");
</script>

