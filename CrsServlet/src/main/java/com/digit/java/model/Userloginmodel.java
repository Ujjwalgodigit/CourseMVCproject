package com.digit.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Userloginmodel {
	
	String user_name;
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	  public boolean login()
	{
		String url = "jdbc:mysql://localhost:3306/crs";

        String user = "root";

        String pwd = "root";
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pwd);
            pstmt = con.prepareStatement("select * from users where user_name=? and password=?");
            pstmt.setString(1, user_name);
            pstmt.setString(2, password);
            
            resultSet =pstmt.executeQuery();
            
            if(resultSet.next()==true) {
        
            return true;
//        	resp.sendRedirect("/CrsServlet/AdminHome.jsp");
            	
            }
            else {
            	return false;
//            	resp.sendRedirect("/CrsServlet/AdminLoginFail.html");
            }
        }
        catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
