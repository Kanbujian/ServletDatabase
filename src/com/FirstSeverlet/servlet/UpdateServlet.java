package com.FirstSeverlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateServlet() {
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

		doPost(request,response);
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
        request.setCharacterEncoding("utf-8");
        //一定要记得设置字符编码格式，否则中文为乱码，name无法匹配，也就无法修改
        //这两句反正保险一点
        response.setCharacterEncoding("utf-8");
		String name=String.valueOf(request.getParameter("name"));
		int bookCount=Integer.valueOf(request.getParameter("bookCount"));
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/test";
			 Connection conn=DriverManager.getConnection(url,"root","w969003");
			 
			 String Sql="update books set bookCount=? where name like ?";
			 
			 PreparedStatement pstmt=conn.prepareStatement(Sql);
			 pstmt.setInt(1,bookCount);
			 pstmt.setString(2,name);
			 pstmt.executeUpdate();
			 if(pstmt!=null){
					pstmt.close();
					pstmt=null;
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}   
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("FindServlet");
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
