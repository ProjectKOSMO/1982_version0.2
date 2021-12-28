<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
    <link type="text/css" href="/project1982/resources/css/1_intro.css" rel="stylesheet"/>
 <!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    
</head>

<body>
<<<<<<< Updated upstream
<h5>이용권</h5>		
	<table class = pay border="1">
		<tr>
			<td rowspan="2" class="pay_detail">이용권</td>
			<td>월 기본 제공 </td>
			<%-- <td><%= bvo.getFree_coupon() %>/5</td> --%>
			<td>4/5</td> 
		</tr>
		<tr>
			<td>남은 구매 이용권 횟수</td>
			<%-- <td id = "pay_coupon"><%=bvo.getPay_coupon() %> </td> --%>
			<td id = "pay_coupon"> 5 </td>
		</tr>
	</table>
		
	<div class ="btns">
		<input type="button" id="check1" value="구매">
		<input type="button" id="check2" value="환불">
	</div>
  
  
=======
	
  구독 기간:
        		<div class="list">
        			<button class='check30'>30일</button>	
        			<button class='check60'>60일</button>	
        			<button class='check90'>90일</button>	
        			<button class='check150'>150일</button>	
        			<button class='check360'>360일</button>	
        		</div>


>>>>>>> Stashed changes
<!-- pay js -->
<script type="text/javascript">
$(document).ready(function(){
	   var pay = 5;
	   console.log(pay);
<<<<<<< Updated upstream
	   	  
		var IMP = window.IMP;
		var code = "imp38743974"; //가맹점 식별코드
		IMP.init(code);
		
		$("#check1").click(function(e){
			//결제요청
			IMP.request_pay({ // param
          pg: "TC0ONETIME",
          pay_method: "card",
          // merchant_uid: "ORD20180131-0000012",
          name: "30일 구독권",
          amount: 10010,
          buyer_email: "gildong@gmail.com",
          buyer_name: "홍길동",
          buyer_tel: "010-4242-4242",
          buyer_addr: "서울특별시 강남구 신사동",
          buyer_postcode: "01181"
=======
	   	
		var IMP = window.IMP;
		var code = "imp38743974"; //가맹점 식별코드
		IMP.init(code);

		$('.check30, .check60, .check90, .check150, .check360').click(function(e){
		  var name_var = 'init';
		  var amount_var = 0;
		  
		  if($(this).attr("class") == 'check30'){
		  	  name_var = "30일 구독권";
		  	amount_var = 10000;
		  }else if($(this).attr("class") == 'check60'){
		  	name_var = "60일 구독권";
		  	amount_var = 18000;
		  }else if($(this).attr("class") == 'check90'){
			  	name_var = "90일 구독권";
			  	amount_var = 25000;
		  }else if($(this).attr("class") == 'check150'){
			  name_var = "150일 구독권";
			  amount_var = 40000;
		  }else if($(this).attr("class") == 'check360'){
		  	  name_var = "360일 구독권";
		  	amount_var = 60000;
		  }

		  	
		  //결제요청
		  IMP.request_pay({ // param
          pg: "TC0ONETIME",
          pay_method: "card",
          // merchant_uid: "ORD20180131-0000012",
          // name: "30일 구독권",
          name : name_var,
          
          amount: amount_var,
          // buyer_email: "gildong@gmail.com",
          // buyer_name: "홍길동",
          // buyer_tel: "010-4242-4242",
          // buyer_addr: "서울특별시 강남구 신사동",
          // buyer_postcode: "01181"
>>>>>>> Stashed changes
      }, function(rsp){
				if(rsp.success){//결제 성공시
					var msg = '결제가 완료되었습니다';
					var result = {
					"imp_uid" : rsp.imp_uid,
					"merchant_uid" : rsp.merchant_uid,
					"biz_email" : 'df',
					"pay_date" : new Date().getTime(),
					"amount" : rsp.paid_amount,
					"card_no" : rsp.apply_num,
					"refund" : 'payed'
					}
					console.log("결제성공 " + msg);
					$.ajax({
						url : 'insertPayCoupon.do', 
				        type :'POST',
				        data : JSON.stringify(result,
				        		['imp_uid', 'merchant_uid', 'biz_email', 
				        			'pay_date', 'amount', 'card_no', 'refund']),
				        contentType:'application/json;charset=utf-8',
				        dataType: 'json', //서버에서 보내줄 데이터 타입
				        success: function(res){
				        			        	
				          if(res == 1){
							 console.log("추가성공");	
							 pay += 5;
							 $('#pay_coupon').html(pay);			           
				          }else{
				             console.log("Insert Fail!!!");
				          }
				        },
				        error:function(){
				          console.log("Insert ajax 통신 실패!!!");
				        }
					}) //ajax
					
				}
				else{//결제 실패시
					var msg = '결제에 실패했습니다';
					msg += '에러 : ' + rsp.error_msg
				}
				console.log(msg);
			});//pay
		}); //check1 클릭 이벤트
		 
<<<<<<< Updated upstream
		$("#check2").click(function(e){
		      console.log("남은이용권"+$('#pay_coupon').text());
		      if($('#pay_coupon').text() >= 5){
			$.ajax({
					url: "coupon_cancel.do",
					type:"post",
					//datatype:"json",
					contentType : 'application/x-www-form-urlencoded; charset = utf-8',
					data : {
						"biz_email" : 'df' // 주문번호
						//"cancle_request_amount" : 2000, //환불금액
						//"reason": "테스트 결제 환불", //환불사유
						//"refund_holder": "홍길동", //[가상계좌 환불시 필수입력] 환불 가상계좌 예금주
						//"refund_bank":"88", //[가상계좌 환불시 필수입력] 환불 가상계좌 은행코드(ex Kg이니시스의 경우 신한은행 88)
						//"refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 가상계좌 번호
					}
				}).done(function(result){ //환불 성공
					 pay -= 5;
					 $('#pay_coupon').html(pay);	
					console.log("환불 성공 : "+ result);
				}).fail(function(error){
					console.log("환불 실패 : "+ error);
				});//ajax
			} else{
				console.log("환불 실패 : 남은 결제권 환불 불가");
			}
		}); //check2 클릭
=======
>>>>>>> Stashed changes
	}); //doc.ready
	</script>
</html>

