package com.FirstSeverlet.bean;
import java.sql.*;
public class sss {
	public void make(){
	try{
	Class.forName("com.mysql.jdbc.Driver");
	   System.out.println("clear");
	   String url="jdbc:mysql://localhost:3306/test";
	   Connection conn=DriverManager.getConnection(url,"root","w969003");
	   
	   String sql="insert into book (name,price,bookCount,author) values(?,?,?,?)";
	  
	   conn.close();
	   }catch(Exception e){
	     
	      e.printStackTrace();
	   }
	}
}
