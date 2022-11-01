<%@page import="admin.select"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<select> al = (ArrayList<select>)request.getAttribute("al");
%>
<div class="admin_login_add">
    <ul>
        <li class="font_color1">관리자 정보 수정</li>
        <li>
        <input type="text" class="add_input1" name = "aid" readonly value="<%=al.get(0).getAid()%>">
        </li>
        <li>
            <input type="password" class="add_input1" name="apass" placeholder="변경할 패스워드를 입력하세요">
            <input type="password" class="add_input1" id="ck_apass" placeholder="동일한 패스워드를 입력하세요">
        </li>
        <li class="font_color1">관리자 기본정보 입력</li>
        <li>
            <input type="text" class="add_input1" name = "aname" value="<%=al.get(0).getAname()%>">
        </li>
        <li>
        <input type="text" class="add_input1 emails" name="aemail" value="<%=al.get(0).getAemail()%>">
        </li>
        <li class="font_color1">
        <input type="text" class="add_input1 hp1" maxlength="3" name="tel0" value="<%=al.get(0).getAtel().substring(0,3)%>">
        -
        <input type="text" class="add_input1 hp2" maxlength="4" name="tel1" value="<%=al.get(0).getAtel().substring(3,7)%>">
        -
        <input type="text" class="add_input1 hp2" maxlength="4" name="tel2" value="<%=al.get(0).getAtel().substring(7,11)%>">
        </li>
        <li class="font_color1">관리자 담당부서 및 직책</li>
        <li>
            <select class="add_select1" name = "apart">
                <option value="0">담당자 부서를 선택하세요</option>
                <option <%=al.get(0).getApart().equals("임원")?"selected":"" %>>임원</option>
                <option <%=al.get(0).getApart().equals("전산팀")?"selected":"" %>>전산팀</option>
                <option <%=al.get(0).getApart().equals("디자인팀")?"selected":"" %>>디자인팀</option>
                <option <%=al.get(0).getApart().equals("CS팀")?"selected":"" %>>CS팀</option>
                <option <%=al.get(0).getApart().equals("MD팀")?"selected":"" %>>MD팀</option>
            </select>
            <select class="add_select1" name = "aposition">
                <option value="0">담당자 직책을 선택하세요</option>
                <option <%=al.get(0).getAposition().equals("대표")?"selected":"" %>>대표</option>
                <option <%=al.get(0).getAposition().equals("부장")?"selected":"" %>>부장</option>
                <option <%=al.get(0).getAposition().equals("팀장")?"selected":"" %>>팀장</option>
                <option <%=al.get(0).getAposition().equals("과장")?"selected":"" %>>과장</option>
                <option <%=al.get(0).getAposition().equals("대리")?"selected":"" %>>대리</option>
                <option <%=al.get(0).getAposition().equals("사원")?"selected":"" %>>사원</option>
            </select>
        </li>
        <li class="font_color1">※ 아이디 외에 모든 정보는 수정 할 수 있습니다.</li>
    </ul>
    <span class="admin_addbtn">
        <button type="button" class="btn_button btncolor1" title="관리자 등록" onclick="modi()">정보 수정</button>
    </span>
</div>


<script>
function modi() {
	var ckp = document.getElementById("ck_apass").value;
	var pss = f.apass.value;
	var reg = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	var sp = pss.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	var regem = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if(f.aid.value==""){
		alert("아이디를 입력해 주세요");
	}else if(f.apass.value=="" || pss.length<4){
		alert("패스워드를 확인해 주세요");
	}else if(f.aname.value==""){
		alert("이름을 입력해 주세요");
	}else if(f.aemail.value==""){
		alert("이메일을 입력해 주세요");
	}else if(f.tel0.value==""){
		alert("전화번호를 입력해 주세요");
	}else if(f.tel1.value==""){
		alert("전화번호를 입력해 주세요");
	}else if(f.tel2.value==""){
		alert("전화번호를 입력해 주세요");
	}else if(f.apart.value=="0"){
		alert("부서를 선택해 주세요");
	}else if(f.aposition.value=="0"){
		alert("직급을 선택해 주세요");
	}else{
		if(f.apass.value != ckp){
			alert("비밀번호가 다릅니다");
// 		}else if (!reg.test(f.apass.value) || pss.match((/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi)).length<2) {
//             alert('비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자2개이상을 모두 포함해야 합니다.');
		}else if(!regem.test(f.aemail.value)){
			alert("이메일 확인해주세요");
		}else{
			f.method = "post";
			f.action = "admin_modi.do";
			f.submit();
		}
	}
	
}
</script>







