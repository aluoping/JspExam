package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.UserDao;


public class LoginServlet extends HttpServlet{
	UserDao ud = new UserDao();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String first_name = req.getParameter("username");
		
		RequestDispatcher rd = null;
		String forward = null;
		if (first_name == null ) {
			req.setAttribute("msg", "用户名为空");
			rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		} else {
			boolean bool = ud.check(first_name);
			if (bool) {
				forward = "success.jsp";
				req.getSession().setAttribute("flag", "success");
			} else {
				req.getSession().setAttribute("flag", "error");
				req.setAttribute("msg", "用户名错误");
				forward = "error.jsp";
			}
			rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}
	
}
