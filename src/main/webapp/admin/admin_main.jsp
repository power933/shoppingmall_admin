<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=1">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <script type="text/javascript" src="./js/admin_main.js"></script>
</head>
<body>
<header class="headercss"><jsp:include page="./admin_header.jsp"></jsp:include></header>
<nav class="navcss"><jsp:include page="./admin_menu.jsp"></jsp:include></nav>
<main class="maincss">
<section>
<jsp:include page="admin_list.jsp"></jsp:include>
</section>
<section></section>
<section></section>



</main>
<footer class="main_copyright"><jsp:include page="./admin_footer.jsp"></jsp:include></footer>
</body>



</html>