package com.douzone.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

//@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("a");

		if("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("message");

			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);

			new GuestBookDao().insert(vo);

			response.sendRedirect(request.getContextPath() + "/gb");
		}
		else if("form".equals(action)) {
			// Request Dispatch
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			// forwarding
			rd.forward(request, response);
		}
		else if("delete".equals(action)) {
			String strNo = request.getParameter("no");
			Long no = Long.parseLong(strNo);

			String inputPassword = request.getParameter("password");
			String noPassword = new GuestBookDao().find(no);

			if (inputPassword.equals(noPassword)) {
				GuestBookVo vo = new GuestBookVo();
				vo.setNo(no);

				new GuestBookDao().delete(vo);
				
				response.sendRedirect(request.getContextPath() + "/gb");
			}
		}
		else {
			// list (default) 처리
			List<GuestBookVo> list = new GuestBookDao().findAll();

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
