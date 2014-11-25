package com.FirstSeverlet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FirstSeverlet.bean.book;



public class EditBook {
	Connection con=null;
	String sql=null;
	PreparedStatement Pstmt=null;
	ResultSet rs=null;
	List<book> booklist=new ArrayList<book>();
	public EditBook(){
		DataConnection DB=new DataConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","w969003");
    	con=DB.getConnection();
	}
	public void insert(book Book){
		try {
			Pstmt = con.prepareStatement("insert into books (name,price,bookCount,author) values(?,?,?,?);");
			
			Pstmt.setString(1, Book.getName());
			Pstmt.setDouble(2, Book.getPrice());
			Pstmt.setInt(3, Book.getBookCount());
			Pstmt.setString(4, Book.getAuthor());
			System.out.println("here");
			Pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("图书添加失败");
			e.printStackTrace();
		}
	}
    public void delete(book Book){
    	try {
			Pstmt = con.prepareStatement("delete from books where name like ?;");
			Pstmt.setString(1, Book.getName());
			Pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("图书删除失败");
			e.printStackTrace();
		}
	}
    public void alter(book Book){
    	try {
			Pstmt = con.prepareStatement("update books set bookCount=? where name like ?");
			Pstmt.setInt(1, Book.getBookCount());	
			Pstmt.setString(2,Book.getName());
			Pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("图书数量修改失败");
			e.printStackTrace();
		}
	}
    public List<book> query(book Book){
    	try {
			Pstmt = con.prepareStatement("select * from cjb where id=?;");
			Pstmt.setInt(1, Book.getId());
			rs=Pstmt.executeQuery();
			if(rs.next())
				booklist.add(new book(0,rs.getString(1),rs.getDouble(2),rs.getInt(3),rs.getString(4)));
		} catch (SQLException e) {
			System.out.println("成绩查询失败");
			e.printStackTrace();
		}
    	return null;
	}
    /*public course Retrieval(String courseName){
    	try {
			Pstmt = con.prepareStatement("select max(?) as MAXSCORE,min(?) as MINSCORE,avg(?) as AVGSCORE from cjb ;");
			Pstmt.setString(1, courseName);
			Pstmt.setString(2, courseName);
			Pstmt.setString(3, courseName);
			rs=Pstmt.executeQuery();
			if(rs.next()){
				System.out.println(rs.getDouble(1)+rs.getDouble(2)+rs.getDouble(3));
				return new course(rs.getDouble(1),rs.getDouble(2),rs.getDouble(3));
			}
			} catch (SQLException e) {
			System.out.println("为什么成绩统计失败");
			e.printStackTrace();
		}
    	return null;
    	
    }*/
   
}
