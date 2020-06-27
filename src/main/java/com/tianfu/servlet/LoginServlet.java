package com.tianfu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tianfu.dao.UserDao;
import com.tianfu.po.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User exitUser;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("doGet中的前端传的数据：" + username + password);

		/*
		 * if (user != null) { // 转发到LoginSuccess.jsp页面 // getRequestDispatcher()是请求转发
		 * request.getRequestDispatcher("/portal/mqttInfo.html").forward(request,
		 * response); user.toString(); user = null; } else { // 登录失败
		 * request.getRequestDispatcher("/portal/LoginFailed.html").forward(request,
		 * response); }
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();

		exitUser = userDao.login(username, password);
		if (exitUser == null) {
			response.setStatus(500);
			response.getWriter().println("请注册！！！");
		}else {
			System.out.println(exitUser.toString());
			exitUser = null;
			System.out.println(exitUser);
		}

		/*
		 * User exitUser = userDao.login(username, password);
		 * 
		 * if(exitUser==null) { response.setStatus(500);
		 * response.getWriter().println("请注册！！！"); }else {
		 * System.out.println(exitUser.toString()); }
		 */

		System.out.println("doPost中前端传的数据：" + username + "," + password);
	}

}
