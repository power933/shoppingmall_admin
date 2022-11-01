<%@page import="java.util.ArrayList"%>
<%@page import="admin.notice_select"%>
<%@page import="admin.notice_insert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">



<%String name = (String)session.getAttribute("aname"); %>

<p>공지사항 등록페이지</p>
<div class="write_view">
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox"  id="aa"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
        <input type = "hidden" name="nuse_notice" value="y"> 
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" class="notice_input1" name="ntitle"> ※ 최대 150자까지 입력이 가능
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
        <input type="file" name="nfileurl"> ※ 첨부파일 최대 용량은 2MB 입니다.       
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" placeholder="공지내용을 입력하세요!" id = "ta" name="ncontent"></textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button class="border_del" onclick="golist()">공지목록</button>
    <button class="border_add" onclick="addlist()">공지등록</button>
</div>
<input type ="hidden" name="ncount" value="5">

<script>

function golist() {
	f.action = "./admin_notice?pageno=1";
	f.submit();
}
function addlist() {
	var x = document.getElementById("aa");
	if(x.checked == false){
		f.nuse_notice.value="n";
	}
	else{
		f.nuse_notice.value="y";
	}
	
	f.method = "post";
	f.action = "./notice_write.do";
	f.submit();
}
CKEDITOR.replace("ta");
</script>
