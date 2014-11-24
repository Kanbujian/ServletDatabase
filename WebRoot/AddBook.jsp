<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.FirstSeverlet.bean.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
     <%request.setCharacterEncoding("utf-8"); %>
     <jsp:useBean id="book" class="com.FirstSeverlet.bean.book"></jsp:useBean>
	 <jsp:setProperty property="*" name="book"/>	
	 <%
	   try{
	 
	   
	 
	   Class.forName("com.mysql.jdbc.Driver");
	   out.print(book.getBookCount());
	   String url="jdbc:mysql://localhost:3306/test";
	   Connection conn=DriverManager.getConnection(url,"root","w969003");
	   
	   String sql="insert into books (name,price,bookCount,author) values(?,?,?,?)";
	   PreparedStatement ps=conn.prepareStatement(sql);
	   
	   ps.setString (1,book.getName());
	   ps.setDouble(2,book.getPrice());
	   ps.setInt(3,book.getBookCount());
	   ps.setString(4,book.getAuthor());
	   
	   int row=ps.executeUpdate();
	 
	   if(row>0){
	   out.println("成功添加了"+row+"条数据");
	   }
	   
				if(ps!=null){
					ps.close();
					ps=null;
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}   
			  
	   }catch(Exception e){
	      out.print("图书信息添加失败！");
	      e.printStackTrace();
	   }
	   
	    %>

  </head>
  
  <body>
     <a href="index.jsp">返回</a>
     <br>
  </body>
</html>
