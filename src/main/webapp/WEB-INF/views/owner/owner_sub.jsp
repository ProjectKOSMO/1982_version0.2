<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ownersub 페이지</title>
    <link type="text/css" href="/project1982/resources/css/10_ownersub.css" rel="stylesheet"/>
</head>

<body>

	<div class="hide">${ownerBoardList[0].ownernum }</div>
	
	
	<form action="" method="post" id="login-form" name="">
		<h1>구독권 결제</h1>
		<div class="center">
		
			<div class="right">
				   
					<div class="list">
						<div class="box">
							<h1>30</h1>
							<h3>day</h3>
							<p>50,000원</p>
							<button class="box_button">Buy</button>
						</div>
						<div class="box">
							<h1>60</h1>
							<h3>day</h3>
							<p>90,000원</p>
							<button class="box_button">Buy</button>
						</div>
						<div class="box">
							<h1>90</h1>
							<h3>day</h3>
							<p>135,000원</p>
							<button class="box_button">Buy</button>
						</div>
						<div class="box">
							<h1>184</h1>
							<h3>day</h3>
							<p>260,000원</p>
							<button class="box_button">Buy</button>
						</div>
						<div class="box">
							<h1>365</h1>
							<h3>day</h3>
							<p>500,000원</p>
							<button class="box_button">Buy</button>
						</div>	
							
					</div>
			
			</div>
		</div>     
	
	</form>
		<div  class="return">
			<button class="box_button" type="button" class="navyBtn" onClick="location.href='ownerMypage.do'">돌아가기</button>
		</div> 
	</body>
	</html>