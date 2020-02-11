<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Hello World</h1>
	<h2>Hello World</h2>
	<h3>Hello World</h3>
	<h4>Hello World</h4>
	<h5>Hello World</h5>
	<h6>Hello World</h6>
	
	<table border="1" cellspacing="0" cellpadding="10">
		<tr>
			<th>번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<tr>
			<td>1</td>
			<td>안녕</td>
			<td>둘리</td>
			<td>2020-01-01</td>
		</tr>
		<tr>
			<td>2</td>
			<td>hi</td>
			<td>마이콜</td>
			<td>2020-02-02</td>
		</tr>
		<tr>
			<td>3</td>
			<td>good</td>
			<td>또치</td>
			<td>2020-02-03</td>
		</tr>
	</table>
	
	<!-- css height width의 크기에 따라 자동으로 비율을 맞춰 조정한다. -->
	<!-- 절대경로 -->
	<img src='/helloweb/images/puppy.jpg' style="width:100px"/><br>
	<!-- 상대경로 -->
	<img src='images/puppy.jpg' style="width:100px"/>
	<br>
	<a href="form.jsp">폼으로 가기</a>
	<a href="index.jsp?n=한해용&a=10">메인으로 가기</a>
	<p>
	정보: 프로토콜 핸들러 ["ajp-nio-8009"]을(를) 시작합니다.
	1월 30, 2020 2:26:09 오후 org.apache.catalina.startup.Catalina start
	정보: Server startup in 270 ms
	</p>
</body>
</html>