package com.digit.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.java.model.Userloginmodel;

@WebServlet("/AdminLogin")

public class AdminLogin extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Userloginmodel user1 = new Userloginmodel();
		user1.setUser_name("user_name");
		user1.setPassword("password");
	
		if(user1.login())
		{
			resp.sendRedirect("/CrsServlet/AdminHome.jsp");
		}
		else {
        	resp.sendRedirect("/CrsServlet/AdminLoginFail.html");
        }
	}
	
	

}
