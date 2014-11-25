package com.FirstSeverlet.DAO;

import java.sql.*;
public class DataConnection {
	String driver=null;
	String url=null;
	String user=null;
	String password=null;
	
	Connection con=null;
	PreparedStatement Pstmt=null;
	ResultSet rs=null;
	public DataConnection(String driver,String url,String user,String password){
		this.driver=driver;
		this.url=url;
		this.user=user;
		this.password=password;
		
	}
	public Connection getConnection(){
		
		try {
			Class.forName(driver);
			System.out.println("就在这儿");
			con=DriverManager.getConnection(url,user,password);
			System.out.println("11");
			/*Pstmt = con.prepareStatement("SELECT * FROM XSB WHERE ID=?;");
			Pstmt.setInt(1, 56);
			rs=Pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"    "+rs.getInt(3));
				
			}*/
			
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return con;
		
	}
	public static void main(String[] args){
		new DataConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","password");
	}
	public void close(){
	 try{
		if(rs!=null) {
			rs.close();
			rs=null;//使用完毕，置为null，方便垃圾收集器收集
		}
		if(Pstmt!=null){
			Pstmt.close();
			Pstmt=null;
		}
		if(con!=null){
			con.close();
			con=null;
		}
	
	}catch(SQLException e){
		System.out.println("数据库关闭失败");
	}
	}
}
