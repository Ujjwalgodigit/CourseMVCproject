package com.digit.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.java.model.Studentmodel;

@WebServlet("/AddStudent")

public class AddStudent extends HttpServlet {
	private PreparedStatement pstmt;
	private Connection con;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		    int sid  = Integer.parseInt(req.getParameter("sid"));
		    String sname = req.getParameter("sname");
		    String email = req.getParameter("email");
			int cid  = Integer.parseInt(req.getParameter("cid"));
			String user_name = req.getParameter("user_name");
			String password = req.getParameter("password");
			
			Studentmodel add = new Studentmodel();
			add.setCid(cid);
			add.setEmail("email");
			add.setPassword("password");
			add.setSid(sid);
			add.setSname("sname");
			add.setUser_name("user_name");
			
			if(add.addstudent())
			{
				resp.sendRedirect("/CrsServlet/AddStudentSuccess.jsp");
			}
			else {
                resp.sendRedirect("/CrsServlet/AddStudentFail.html");
	        }
	}
	}


