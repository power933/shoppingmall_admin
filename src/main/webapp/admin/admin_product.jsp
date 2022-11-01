<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쇼핑몰 환경설정</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" type="text/css" href="./css/product.css?v=5">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <script src="./js/jquery.js"></script>
</head>
<body>
<header class="headercss">
<jsp:include page="admin_header.jsp"></jsp:include>
</header>
<nav class="navcss">
<jsp:include page="admin_menu.jsp"></jsp:include>
</nav>
<form name = "f" enctype="multipart/form-data">
<main class="maincss">
<section style="height: auto;">
<jsp:include page="product_list.jsp"></jsp:include>
</section>
</main>
</form>
<footer class="main_copyright">
<jsp:include page="admin_footer.jsp"></jsp:include>
</footer>
</body>
</html>

