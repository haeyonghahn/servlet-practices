<%@page import="com.douzone.emaillist.dao.EmaillistDao"%>
<%@page import="com.douzone.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String firstName = request.getParameter("fn");
 	String lastName = request.getParameter("ln");
 	String email = request.getParameter("email");
 	
 	EmaillistVo vo = new EmaillistVo();
 	vo.setFirstName(firstName);
 	vo.setLastName(lastName);
 	vo.setEmail(email);
 	
 	new EmaillistDao().insert(vo);
 	
 	// add.jsp와 같은 데이터베이스를 insert하는 페이지는 웹프로그램을 하는데 있어
 	// 반복적인 수행이 일어나지 않도록 주의해야한다. 따라서, sendRedirect를 사용하여
 	// 본래 페이지로 돌아갈 수 있도록 조정한다.
 	response.sendRedirect("/emaillist01/index.jsp");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>