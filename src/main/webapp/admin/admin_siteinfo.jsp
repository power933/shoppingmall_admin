<%@page import="java.util.ArrayList"%>
<%@page import="admin.setting_select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<% 
ArrayList<setting_select> al = (ArrayList<setting_select>)request.getAttribute("al"); 
String yn[] = {"y","n"};
%>

<p>홈페이지 가입환경 설정</p>

<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" class="in_form1" name = "stitle" value="<%=al.get(0).getStitle() %>">
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" class="in_form2" name="semail" value=<%=al.get(0).getSemail() %>> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss" id = "r1">
    <%
    String pnt[] = {"포인트 사용", "포인트 미사용"};
    	for(int i =0; i<2;i++){
    		String ck = "";
    		if(al.get(0).getSpointuse().equals(yn[i])){
    			ck = "checked";
    		}else{ck="";	}
    %>
        <em><label><input type="radio" class="ckclass" value="<%=yn[i] %>" name="spointuse" <%=ck %>> <%=pnt[i] %> </label></em> 
    <% }%>    
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" maxlength="5" name="sbasicpoint" value=<%=al.get(0).getSbasicpoint() %>> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" maxlength="1" name="sbasiclevel" value=<%=al.get(0).getSbasiclevel() %>> 레벨
    </li>
</ul> 
</div>
<p>홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" name="scompany_name" value=<%=al.get(0).getScompany_name() %>> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" name="sbn" value=<%=al.get(0).getSbn() %>> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" name="schairman" value=<%=al.get(0).getSchairman() %>> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" name="stel" value=<%=al.get(0).getStel() %>> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" name="stn" value=<%=al.get(0).getStn() %>> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" name="ssub_bn" value=<%=al.get(0).getSsub_bn() %>> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" name="spost" value=<%=al.get(0).getSpost() %>> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" name="saddr" value=<%=al.get(0).getSaddr() %>> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" name="sres_name" value=<%=al.get(0).getSres_name() %>> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" name="sres_email" value=<%=al.get(0).getSres_email() %>> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" class="in_form0" name="sbank_name" value=<%=al.get(0).getSbank_name() %>> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" name="sbank_num" value=<%=al.get(0).getSbank_num() %>> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
    
    <%
    String sc[] = {"사용", "미사용"};
    	for(int i =0; i<2;i++){
    		String ck = "";
    		if(al.get(0).getSuse_card().equals(yn[i])){
    			ck = "checked";
    		}else{ck="";	}
    %>
    
        <em><label><input type="radio" class="ckclass" value="<%=yn[i] %>" <%=ck %> name="suse_card"> <%=sc[i] %></label></em> 
    <%} %>  
    ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
    
    <%
    	for(int i =0; i<2;i++){
    		String ck = "";
    		if(al.get(0).getSuse_tel().equals(yn[i])){
    			ck = "checked";
    		}else{ck="";	}
    %>
    
        <em><label><input type="radio" class="ckclass" value="<%=yn[i] %>" <%=ck %> name="suse_tel" ><%=sc[i] %></label></em> 
        <%} %>
        ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
    
    <%
    	for(int i =0; i<2;i++){
    		String ck = "";
    		if(al.get(0).getSuse_book().equals(yn[i])){
    			ck = "checked";
    		}else{ck="";}
    %>
    
        <em><label><input type="radio" class="ckclass" value="<%=yn[i] %>" <%=ck %> name="suse_book"> <%=sc[i] %></label></em>
        <%} %> 
        ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
    
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="spoint_least" value=<%=al.get(0).getSpoint_least() %>> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="spoint_limit" value=<%=al.get(0).getSpoint_limit() %>> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
    
    <%
    	for(int i =0; i<2;i++){
    		String ck = "";
    		if(al.get(0).getSuse_receipt().equals(yn[i])){
    			ck = "checked";
    		}else{ck="";}
    %>
    
        <em><label><input type="radio" class="ckclass" value="<%=yn[i] %>" <%=ck %> name="suse_receipt"> <%=sc[i] %></label></em> 
        
      <%} %>
      ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" class="in_form0" name="sdelivery_name" value=<%=al.get(0).getSdelivery_name() %>> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" class="in_form0" maxlength="7" name="sdelivery_payment" value=<%=al.get(0).getSdelivery_payment() %>> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
    
    <%
    	for(int i =0; i<2;i++){
    		String ck = "";
    		if(al.get(0).getSuse_hopedate().equals(yn[i])){
    			ck = "checked";
    		}else{ck="";}
    %>
    
        <em><label><input type="radio" class="ckclass" value="<%=yn[i] %>" <%=ck %> name="suse_hopedate"> <%=sc[i] %></label></em> 
    <%} %>    
        ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" onclick="save()">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="rset()">저장 취소</button>
</div>








