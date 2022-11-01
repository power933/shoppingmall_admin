<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<p>상품 등록 페이지</p>
<div class="product_insert">
    <ul>
        <li>대메뉴 카테고리</li>
        <li>
            <input type="text" class="product_input1" id="plarge_cate" name="plarge_cate"> 
        </li>
    </ul>
    <ul>
        <li>소메뉴 카테고리</li>
        <li>
            <input type="text" class="product_input1" id="psmall_cate" name="psmall_cate"> 
        </li>
    </ul>
    <ul>
        <li>상품코드</li>
        <li>
            <input type="text" class="product_input1" id="pcode" name="pcode"> 
            <input type="button" value="중복확인" title="중복확인" class="product_btn" id="check"> <span class="help_text">※ 상품코드는 절대 중복되지 않도록 합니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품명</li>
        <li>
            <input type="text" class="product_input2" maxlength="100" id="pname" name="pname"> <span class="help_text">※ 상품명은 최대 100자까지만 적용할 수 있습니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품 부가설명</li>
        <li>
            <input type="text" class="product_input4" maxlength="200" id="psub_ex" name="psub_ex"> <span class="help_text">※ 상품명은 최대 200자까지만 적용할 수 있습니다.</span>
        </li>
    </ul>
    <ul>
        <li>판매가격</li>
        <li>
            <input type="text" class="product_input3" maxlength="7" name="pprice" id="pprice"  onkeyup="calcu()"> <span class="help_text">※ , 없이 숫자만 입력하세요 최대 7자리</span>
        </li>
    </ul>
    <ul>
        <li>할인율</li>
        <li>
            <input type="text" class="product_input3" maxlength="2" value="0" name="ppercent" id="ppercent" onkeyup="calcu()">% <span class="help_text" >※ 숫자만 입력하세요</span>
        </li>
    </ul>
    <ul>
        <li>할인가격</li>
        <li>
            <input type="text" class="product_input3" maxlength="7" value="0" name="psale" id="psale" readonly > <span class="help_text">※ 할인율이 0%일 경우 할인가격은 0으로 처리 합니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품재고</li>
        <li>
            <input type="text" class="product_input3" maxlength="4" value="0" id="pstock" name="pstock">EA <span class="help_text">※ 숫자만 입력하세요. 재고가 0일 경우 soldout이 됩니다.</span>
        </li>
    </ul>
    <ul>
        <li>판매 유/무</li>
        <li>
            <label class="product_label">
            <input type="radio" name="puse" value="Y" style="vertical-align:-1px;" checked> 판매시작
            </label>
            <label class="product_label">
            <input type="radio" name="puse" value="N" style="vertical-align:-1px;"> 판매종료
            </label>
        </li>
    </ul>
    <ul>
        <li>조기품절</li>
        <li>
            <label class="product_label">
                <input type="radio" name="psoldout" value="Y" style="vertical-align:-1px;"> 사용
            </label>
            <label class="product_label">
                <input type="radio" name="psoldout" value="N" style="vertical-align:-1px;" checked> 미사용
            </label>
        </li>
    </ul>
    <ul style="height: 160px;">
        <li>상품 대표이미지</li>
        <li>
            <ol style="width:100%; height: auto;">
            <li style="width:100%; height:45px;">
            <input type="file" name="pimg1">
            <span class="help_text">※ 상품 대표이미지 이며, 이미지 용량은 2MB 까지 입니다.</span>
            </li>
            <li style="height:45px;">
            <input type="file" name="pimg2">
            <span class="help_text">※ 추가 이미지 이며, 이미지 용량은 2MB 까지 입니다.</span>
            </li>
            <li style="height:45px;">
            <input type="file" name="pimg3">
            <span class="help_text">※ 추가 이미지 이며, 이미지 용량은 2MB 까지 입니다.</span>
            </li>
            </ol>
        </li>
    </ul>
    <ul style="height: 400px;">
        <li>상품 상세설명</li>
        <li>
            <textarea class="product_text1" id = "ta" name="p_ex"></textarea>
        </li>
    </ul>
</div>
<div class="subpage_view4" style="text-align:center;">
    <input type="button" value="상품 리스트" title="상품 리스트" class="p_button p_button_color1" style="margin-right: 5px;" onclick="tolist()">
    <input type="button" value="상품 등록" title="상품 등록" class="p_button p_button_color2" onclick = "insertpage()">
    </span>
</div>

<script>
function tolist() {
	location.href="admin_product";
}
var ck = false;
$(function() {
	$("#check").click(function() {
		var code = $("input[name=pcode]").val();
		$.ajax({
			url : "pcode_check",
			type : "GET",
			data : {"code" : code},
			datatype : "json",
			success: function(data) {
				if(data=="no"){
					alert("사용불가");
				}
				else{
					alert("사용가능");
					$("input[name=pcode]").attr("readonly",true);
					ck = true;
				}
			},
			error : function() {
			}
		});
	});
});

function insertpage() {
	if(document.getElementById("plarge_cate").value==""){
		alert("대메뉴 코드를 입력하세요");
	}
	else if(document.getElementById("plarge_cate").value=="")alert("대메뉴 코드를 입력하세요");
	else if(document.getElementById("psmall_cate").value=="")alert("소메뉴 코드를 입력하세요");
	else if(document.getElementById("pcode").value=="")alert("상품 코드를 입력하세요");
	else if(document.getElementById("pname").value=="")alert("상품명을 입력하세요");
	else if(document.getElementById("psub_ex").value=="")alert("부가설명을 입력하세요");
	else if(document.getElementById("pprice").value=="")alert("가격을 입력하세요");
	else if(document.getElementById("ppercent").value=="")alert("할인율을 입력하세요");
	else if(document.getElementById("pstock").value=="")alert("재고를 입력하세요");
	else{
		if(!ck){
			alert("중복확인을 해주세요");
		}
		else{
			f.method="post";
			f.action = "product_inse";
			f.submit();
		}
	}
	
}



function calcu() {
	var a = document.getElementById("pprice").value;
	var b = document.getElementById("ppercent").value;
	document.getElementById("psale").value = a*(100-b)/100;
}

CKEDITOR.replace("ta");
</script>