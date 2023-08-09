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

import com.digit.java.model.Addcoursemodel;


@WebServlet("/AddCourse")

public class AddCourse extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid  = Integer.parseInt(req.getParameter("cid"));
		String cname = req.getParameter("cname");
		int fees  = Integer.parseInt(req.getParameter("fees"));
		int dur_months  = Integer.parseInt(req.getParameter("dur_months"));
		
		Addcoursemodel add = new Addcoursemodel();
		add.setCid(cid);
		add.setCname("cname");
		add.setDur_months(dur_months);
		add.setFees(fees);
	
	if(add.addcourse())
	{
		resp.sendRedirect("/CrsServlet/AddCourseSuccess.jsp");
	}
	else
	{
		resp.sendRedirect("/CrsServlet/ReAddCourseFail.html");
	}

}
	}
