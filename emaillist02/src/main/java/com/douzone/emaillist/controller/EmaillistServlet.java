package com.douzone.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

//@WebServlet("/el")
public class EmaillistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("a");
		
		if("add".equals(action)) {
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
		 	response.sendRedirect(request.getContextPath() + "/el");
		 	
		}
		else if("form".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			// forwarding
			rd.forward(request, response);
		} 
		else {
			// list (default) 처리
			List<EmaillistVo> list = new EmaillistDao().findAll();
			
			request.setAttribute("list", list);
			// Request Dispatch
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			// forwarding
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
