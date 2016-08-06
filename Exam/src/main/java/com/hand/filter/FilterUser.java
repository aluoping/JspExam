package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterUser implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {// 过滤用户
		System.out.println("进入dofilter方法——————》");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String servletPath = req.getServletPath();
		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");
		if (servletPath != null && (servletPath.equals("login.jsp") || (servletPath.equals("index.jsp")
				|| (servletPath.equals("/Login")) || (servletPath.equals("error.jsp"))
				|| (servletPath.equals("success.jsp")) || (servletPath.equals("film.jsp"))))) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("success")) {
				chain.doFilter(request, response);
			} else if (flag != null && flag.equals("error")) {
				req.setAttribute("msg", "登陆失败，重新登陆");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
		}

	}

	public void destroy() {

	}

}
