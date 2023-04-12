package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bo.RegisterBo;

public class StuDao {

	  public static Connection getConnection() {
		  Connection con=null;
		  
		  try {
			
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      String url="jdbc:mysql://localhost:3306/stu?useSSL=false&allowPublicKeyRetrieval=true";
		      String username="root";
		      String password="root";
		      con=DriverManager.getConnection(url,username,password);

		} catch (Exception e) {
			System.out.println(e);
		}
		  
		  
		  return con;
	  }
	
	  
  public static int registerData(RegisterBo rb) {
	     
	    int status=0;
	    
	    try {
			 Connection con = StuDao.getConnection();
			 String sql="insert into register values(?,?)";
	    	 PreparedStatement ps=con.prepareStatement(sql);  
	    	 ps.setString(1, rb.getName());
	    	 ps.setString(2, rb.getPass());
	    	 status=ps.executeUpdate();
	    	
		} catch (Exception e) {
			System.out.println(e);
		}
	    
	    
	    
	    return status;
	  
  }
	
	
}
