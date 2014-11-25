package com.FirstSeverlet.servlet;
import com.FirstSeverlet.bean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                    
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/test";
			 Connection conn=DriverManager.getConnection(url,"root","w969003");
			 Statement stmt=conn.createStatement();
			 String Sql="select * from books";
			 ResultSet rs=stmt.executeQuery(Sql);
			 List<book> list=new ArrayList<book>();
			 while(rs.next()){
				 book newBook=new book();
				 newBook.setId(rs.getInt("id"));//添加id列（主键自增）记得在此处从数据库读取赋值
				 newBook.setName(rs.getString("name"));
				 newBook.setPrice(rs.getDouble("price"));
				 newBook.setBookCount(rs.getInt("bookCount"));
				 newBook.setAuthor(rs.getString("author"));
				 list.add(newBook);
			 }
			 request.setAttribute("list", list);
			    if(rs!=null) {
					rs.close();
					rs=null;//使用完毕，置为null，方便垃圾收集器收集
				}
				if(stmt!=null){
					stmt.close();
					stmt=null;
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}   
			  
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库查询失败");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/book_list.jsp").forward(request, response);   
		  	
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	

}
