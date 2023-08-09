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

import com.digit.java.model.Professormodel;

@WebServlet("/AddProfessor")

public class AddProfessor  extends HttpServlet{
	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		    int pid  = Integer.parseInt(req.getParameter("pid"));
		    String pname = req.getParameter("pname");
		    int exp  = Integer.parseInt(req.getParameter("exp"));
			int cid  = Integer.parseInt(req.getParameter("cid"));
			String user_name = req.getParameter("user_name");
			String password = req.getParameter("password");
			
			Professormodel add = new Professormodel();
			
			add.setCid(cid);
			add.setExp(exp);
			add.setPassword("password");
			add.setPid(pid);
			add.setPname("pname");
			add.setUser_name("user_name");
			
			if(add.addprofessor())
			{
				resp.sendRedirect("/CrsServlet/AddProfessorSuccess.jsp");
			}
			else {
                resp.sendRedirect("/CrsServlet/AddProfessorFail.html");
	        }
			
			

	}
	}


