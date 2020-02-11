<%@page import="com.douzone.guestbook.dao.GuestBookDao"%>
<%@page import="java.util.List"%>
<%@page import="com.douzone.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");

		String strNo = request.getParameter("no");
		Long no = Long.parseLong(strNo);

		String inputPassword = request.getParameter("password");
		String noPassword = new GuestBookDao().find(no);

		if (inputPassword.equals(noPassword)) {
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);

			new GuestBookDao().delete(vo);
	%>
	<script type="text/javascript">
		alert("삭제되었습니다.");
		location.assign("/guestbook01/index.jsp");
	</script>
	<%
		} 
		else {
	%>
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.back();
	</script>
	<% 
		}
	%>
</body>
</html>