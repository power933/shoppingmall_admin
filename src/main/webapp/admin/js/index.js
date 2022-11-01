function tojoin() {
	location.href = "./add_master.html";
}
function masterlogin() {
	var pas = document.getElementById("apass");
	if(frm.aid.value==""){
		alert("아이디를 입력하세요");
	}
	else if(frm.apass.value==""){
		alert("패스워드를 입력하세요");
	}
	else{
		frm.method = "post";
		frm.action = "admin_login.do";
		frm.submit();
	}
}

function tofind() {
	location.href="";
}

