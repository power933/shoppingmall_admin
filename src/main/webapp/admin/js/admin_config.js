function save() {
	if(f.stitle.value==""){alert("홈페이지 제목을 입력하세요");}
	else if(f.semail.value==""){alert("관리자 이메일을 입력하세요");}
	else if(f.sbasicpoint.value==""){alert("회원가입시 적립금을 입력하세요");}
	else if(f.sbasiclevel.value==""){alert("회원가입시 권한레벨을 입력하세요");}
	else if(f.scompany_name.value==""){alert("회사명을 입력하세요");}
	else if(f.sbn.value==""){alert("사업자등록번호를 입력하세요");}
	else if(f.schairman.value==""){alert("대표자명을 입력하세요");}
	else if(f.stel.value==""){alert("대표전화번호를 입력하세요");}
	else if(f.stn.value==""){alert("통신판매업 신고번호를 입력하세요");}
	else if(f.ssub_bn.value==""){alert("부가통신 사업자번호를 입력하세요");}
	else if(f.spost.value==""){alert("사업장 우편번호를 입력하세요");}
	else if(f.saddr.value==""){alert("사업장주소를 입력하세요");}
	else if(f.sres_name.value==""){alert("정보관리책임자명을 입력하세요");}
	else if(f.sres_email.value==""){alert("정보관리자 이메일을 입력하세요");}
	else if(f.sbank_name.value==""){alert("은행 이름을 입력하세요");}
	else if(f.sbank_num.value==""){alert("은행 계좌번호를 입력하세요");}
	else if(f.spoint_least.value==""){alert("결제 최소 포인트를 입력하세요");}
	else if(f.spoint_limit.value==""){alert("결제 최대 포인트를 입력하세요");}
	else if(f.sdelivery_name.value==""){alert("배송업체명을 입력하세요");}
	else if(f.sdelivery_payment.value==""){alert("배송비 가격을 입력하세요");}
	else{
		f.action="setting_set.do";
		f.submit();
	}	
}

function rset() {
	location.reload();
}
