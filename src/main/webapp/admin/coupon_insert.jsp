<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p>쇼핑몰 관리 페이지</p>
<div class="subpage_view" style="margin-top: 25px;">
    <span style="height: 35px; border-bottom:1px solid #ccc;">※ 신규 쿠폰등록 </span>
    <span>
     <ol class="coupon_in">
        <li>쿠폰명</li>
        <li><input type="text" class="inputs coupon_intext4" maxlength="40" id="cname" name="cname"> ※ 쿠폰명은 최대 40자까지 입력이 가능합니다.</li>
     </ol>
     <ol class="coupon_in">
        <li>쿠폰종류</li>
        <li><input type="text" class="inputs coupon_intext1" maxlength="40" id="ckind" name="ckind"> ※ 쿠폰종류를 입력해 주세요 (상품할인, 배송비할인)</li>
     </ol>
     <ol class="coupon_in">
        <li>사용 시작일</li>
        <li><input type="text" class="inputs coupon_intext1" maxlength="10" id="cstart_date" name="cstart_date" readonly> ※ 클릭시 해당 시작을 캘린더에서 선택 하세요</li>
     </ol>
     <ol class="coupon_in">
        <li>사용 종료일</li>
        <li><input type="text" class="inputs coupon_intext1" maxlength="10" id="cend_date" name="cend_date" readonly> ※ 종료 일자 이후에는 쿠폰은 더 이상 사용되지 않습니다.</li>
     </ol>
     <ol class="coupon_in">
        <li>쿠폰타입</li>
        <li>
            <select class="inputs coupon_intext2" id="ctype" name="ctype">
                <option>쿠폰 타입 선택</option>
                <option>정액할인</option>
                <option>정률할인</option>
            </select>
             ※ 정액할인 일 경우 할인 금액을 입력해야 하며, 정률 할인 일 경우 할인율 % 값을 입력하세요</li>
     </ol>
     <ol class="coupon_in">
        <li>할인금액 및 할인율</li>
        <li><input type="text" class="inputs coupon_intext1" id="csale" name="csale" onkeyup="ck()"> ※ 정률할인 일 경우 숫자 100 이상 입력이 안됩니다.</li>
     </ol>
     <ol class="coupon_in">
        <li>최소 주문금액</li>
        <li><input type="text" class="inputs coupon_intext1" id="cleast" name="cleast"> ※ 해당 쿠폰은 최소 주문금액이 되어야만 사용이 가능합니다. (최소 10000 이상 부터 입력이 가능합니다.)</li>
     </ol>
     <ol class="coupon_in">
        <li>쿠폰이미지 등록</li>
        <li><input type="file" id="cimg" name="cimg"> ※ 쿠폰이미지는 최소 2MB 이하 이미지만 사용가능 합니다.</li>
     </ol>
    </span>
    <span><input type="button" value="쿠폰 리스트" class="shopping_btn2" title="쿠폰 리스트" onclick="golist()"><input type="button" value="등록 완료" class="shopping_btn" title="등록 완료" onclick="gosub()"></span>
</div>

</div>

<script>
function gosub() {
	if(document.getElementById("cname").value==""){
		alert("아이디를 입력하세요");
	}
	else if(document.getElementById("ckind").value==""){alert("아이디를 입력하세요");}
	else if(document.getElementById("cstart_date").value==""){alert("쿠폰종류를 입력하세요");}
	else if(document.getElementById("cend_date").value==""){alert("사용 시작일을 입력하세요");}
	else if(document.getElementById("ctype").value=="쿠폰 타입 선택"){alert("쿠폰타입을 선택하세요");}
	else if(document.getElementById("csale").value==""){alert("할인금액을 입력하세요");}
	else if(document.getElementById("cleast").value=="" ){alert("최소 주문금액을 확인하세요");}
	
	else{
		if(document.getElementById("cleast").value<10000){
			alert("최소 금액은 1만원 이상이여야 합니다");
		}
		else{
		f.method="post";
		f.action = "coupon_insert";
		f.submit();
		}
	}
}
function golist() {
	location.href="admin_shopping";
}
$(function(){
	$("#cstart_date").datepicker();
    $("#cend_date").datepicker();
});

function ck() {
	var a = document.getElementById("ctype").value;
	var b = document.getElementById("csale").value;
	if(a=="정률할인" && b>100){
		document.getElementById("csale").value=100;
	}
}
function ck1() {
	var a = document.getElementById("cleast").value;
	if(a<10000){
		document.getElementById("cleast").value=10000;
	}
}

</script>

