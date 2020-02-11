package com.douzone.helloweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식으로 넘어올 때는 인코딩을 시켜줘야지 한글이 안깨짐. 
		// get방식은 상관없음. get방식은 Servers -> server.xml에다가 URIEncoding을 지정한다.
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("doGet() called");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String brithYear = request.getParameter("birthYear");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		String desc = request.getParameter("desc");
		
		System.out.println(email);
		System.out.println(password);
		System.out.println(brithYear);
		System.out.println(gender);
		for(String hobby : hobbies) {
			System.out.println(hobby);
		}
		System.out.println(desc);
		
		// 응답할 때
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("ok");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() called");
		doGet(request, response);
	}

}
