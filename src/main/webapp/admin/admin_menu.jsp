<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<div class="nav_div">
    <ol>
        <li title="쇼핑몰 기본설정" onclick = "gosetting()">쇼핑몰 기본설정</li>
        <li title="회원관리" >회원관리</li>
        <li title="공지사항" onclick = "gonotice()">공지사항</li>
        <li title="쇼핑몰관리" onclick="goshopping()">쇼핑몰관리</li>
        <li title="상품리스트" onclick = "goproduct()">상품리스트</li>
        <li title="주문내역">주문내역</li>
        <li title="매출내역">매출내역</li>
    </ol>
</div>

<script>
function gosetting() {
	location.href = "./admin_config";
}

function gonotice() {
	location.href = "./admin_notice";
}

function goproduct() {
	location.href = "./admin_product";
}
function goshopping() {
	location.href = "./admin_shopping";
}

</script>