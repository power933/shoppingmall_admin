<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<div id="boardlayout" >
    <div class="subpage_wrap">
        <div id="subpageLNB" class="subpage_lnb">
<div id="boardLnbCommon">
    <h2 class="title1"><a href="/service/cs" designElement="text" >CS CENTER</a></h3>
    <ul class="lnb_sub">
        <li ><a href="#" designElement="text">공지사항</a></li>
        <li ><a href="#" designElement="text">자주 묻는 질문</a></li>
        <li ><a href="#" designElement="text">상품문의</a></li>
        <li ><a href="#" designElement="text"><b>상품후기</b></a></li>
    </ul>
</div>
<script>
$(function() {
    // 고객센터 LNB 텍스트 수정기능으로 삭제시, 클라이언트단에서 삭제 처리
    $('#boardLnbCommon a').each(function(e) {
        if ( $(this).text() == '' ) {
            $(this).parent('li, h2').remove();
        }
    });
});
</script>
        </div>

        <!-- +++++ cscenter contents ++++ -->
        <div class="subpage_container">
            <!-- 전체 메뉴 -->
            <a id="subAllButton" class="btn_sub_all" href="#" designElement="text">MENU</a>

            <!-- -->
            <div class="cs_top2 mycs_fcont_margin">
                <a class="menu2" href="#" designElement="text"><span class="area"><span class="text2">배송문의</span></span></a>
                <a class="menu3" href="#" designElement="text"><span class="area"><span class="text2">반품/교환문의</span></span></a>
                <a class="menu1" href="#" designElement="text"><span class="area"><span class="text2">상품문의</span></span></a>
                <a class="menu9" href="#" designElement="text"><span class="area"><span class="text2">쿠폰내역</span></span></a>
                <a class="menu10" href="#" designElement="text"><span class="area"><span class="text2">마일리지내역</span></span></a>
                <a class="menu5" href="#" designElement="text"><span class="area"><span class="text2">자주묻는질문</span></span></a>
            </div>

            <!-- 타이틀 -->
            <div class="title_container2">
                <h3 class="title_sub6"><span designElement="text" textIndex="8" >자주 묻는 질문</span> <span class="top5" designElement="text" textIndex="9" >TOP5</span></h3>
                <a class="btn_thebogi" href="#" designElement="text" textIndex="10" >더보기</a>
            </div>
            
            <ul class="faq_new v2">
                <li>
                    <div class="question">
                        <p class="subject pointer boad_faqview_btn" board_seq="1"> <span class="cat">[배송안내]</span> 주문시 배송은 얼마나 걸리나요?    </p>
                        <p class="add_info">
                            <span class="hide">번호:  4</span>
                        </p>
                    </div>
                    <div id="faqcontent_1" class="answer hide">								
                        <p style="box-sizing: inherit;">1. 주문하신 상품에 따라 배송시일이 달라 집니다.</p><p style="box-sizing: inherit; font-family: " spoqa="" han="" sans",="" "malgun="" gothic",="" "apple="" sd="" gothic="" neo",="" dotum,="" sans-serif;="" color:="" rgb(102,="" 102,="" 102);="" font-size:="" 16px;="" text-align:="" left;"="">택배로 나가는 제품의 경우 - 재고가 국내에 있는 제품은 2~3일이내 / 재고가 없는 경우 15일이내&nbsp;</p><p style="box-sizing: inherit; font-family: " spoqa="" han="" sans",="" "malgun="" gothic",="" "apple="" sd="" gothic="" neo",="" dotum,="" sans-serif;="" color:="" rgb(102,="" 102,="" 102);="" font-size:="" 16px;="" text-align:="" left;"="">설치제품의 경우 - 15~20일 소요됩니다.</p><p style="box-sizing: inherit; font-family: " spoqa="" han="" sans",="" "malgun="" gothic",="" "apple="" sd="" gothic="" neo",="" dotum,="" sans-serif;="" color:="" rgb(102,="" 102,="" 102);="" font-size:="" 16px;="" text-align:="" left;"=""><br></p><p style="box-sizing: inherit; font-family: " spoqa="" han="" sans",="" "malgun="" gothic",="" "apple="" sd="" gothic="" neo",="" dotum,="" sans-serif;="" color:="" rgb(102,="" 102,="" 102);="" font-size:="" 16px;="" text-align:="" left;"="">주문시에 미리 연락을 드려 스케줄 안내를 드리고 있습니다.</p>
                    </div>
                </li>
            </ul>
            <script type="text/javascript">
            // FAQ 게시글 보기
            $('.boad_faqview_btn').on('click', function() { 
                var board_seq = $(this).attr('board_seq');
                $("#faqcontent_"+board_seq).toggle();
            }); 
            </script>
        </div>
        
    </div>
    <script type="text/javascript" src="./js/cscenter_ui.js"></script><!-- 고객센터 ui 공통 -->

</div>
        
        </div>
</div>
