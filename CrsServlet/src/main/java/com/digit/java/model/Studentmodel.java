package com.digit.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Studentmodel {
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	int sid;
	String sname;
	String email;
	String user_name;
	String password;
	int cid;
	private Connection con;
	private PreparedStatement pstmt;
	
	public boolean addstudent()
	{

		String url = "jdbc:mysql://localhost:3306/crs";

        String user = "root";

        String pwd = "root";
        
        try {
        	Scanner sc = new Scanner(System.in);
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url, user, pwd);
        	
        	pstmt = con.prepareStatement("Insert into Student values(?,?,?,?,?,?)");
        	pstmt.setInt(1,sid);
        	pstmt.setString(2,sname);
        	pstmt.setString(3,email);
        	pstmt.setString(4,user_name);
        	pstmt.setString(5,password);
        	pstmt.setInt(6,cid);
        	
        	 int x = pstmt.executeUpdate();

             if(x>0) {

//                 resp.sendRedirect("/CrsServlet/AddStudentSuccess.jsp");
            	 return true;

             }

             else 
             {

//                 resp.sendRedirect("/CrsServlet/AddStudentFail.html");
            	 return false;

             }
			
        	
        }
        catch (Exception e) {
			e.printStackTrace();		
	}
		return false;
		
	}

}
