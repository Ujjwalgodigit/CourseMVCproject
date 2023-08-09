package com.digit.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Professormodel {
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	int pid;
	String pname;
	int exp;
	int cid;
	String user_name;
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	
	public boolean addprofessor()
	{

		String url = "jdbc:mysql://localhost:3306/crs";

        String user = "root";

        String pwd = "root";
        
        try {
        	Scanner sc = new Scanner(System.in);
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url, user, pwd);
        	
        	pstmt = con.prepareStatement("insert into Professor values(?,?,?,?,?,?)");
        	pstmt.setInt(1,pid);
        	pstmt.setString(2,pname);
        	pstmt.setInt(3,exp);
        	pstmt.setInt(4,cid);
        	pstmt.setString(5,user_name);
        	pstmt.setString(6,password);
        	
        	 int x = pstmt.executeUpdate();

             if(x>0) {

//                 resp.sendRedirect("/CrsServlet/AddProfessorSuccess.jsp");
            	 return true;

             }

             else {

//                 resp.sendRedirect("/CrsServlet/AddProfessorFail.html");
            	 return false;

             }
			
        	
        }
        catch (Exception e) {
			e.printStackTrace();
	}
		return false;
		
	}

}
