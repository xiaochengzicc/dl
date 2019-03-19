package com.ebuy_maven_ssm.web;

import com.ebuy_maven_ssm.dao.AdminDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet (urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	AdminDao adminDao=new AdminDao();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		//获取登录页面的账号名表单数据
			String username=request.getParameter("username");
			//获取登录页面的密码表单数据
			String password=request.getParameter("password");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			if(AdminDao.login(username,password)){
				
				System.err.println("登录成功，进入首页");
				response.sendRedirect(basePath+"/jsp/backstage/main.html");
			}else {
				System.err.println("登录失败，返回登录页面");
				response.sendRedirect(basePath+"/jsp/backstage/login.jsp");
			}
			
			
			
			
		
	}

}
