<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.FirstSeverlet.bean.book" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'book_list.jsp' starting page</title>
    <style type="text/css">
    <%request.setCharacterEncoding("utf-8"); %>
    <%response.setCharacterEncoding("utf-8");%>
    #customers
      {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }
  #customers td, #customers th 
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#customers th 
  {
  font-size:1.1em;
  text-align:center;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }
    </style>
    
	


  </head>
  
  <body>
   <table id="customers">
   <tr>
   <td align="center" colspan="5" >
   <h2>所有图书信息</h2>
   </td>
   </tr>
   
<tr>
<th>图书名称</th>
<th>价格</th>
<th>数量</th>
<th>作者</th>
<th>修改数量</th>
</tr>

<%
    List<book> list=(List<book>)request.getAttribute("list");
    int i=1;
    if(list==null||list.size()<1){
     out.print("没有数据");
     }else{
     for(book newBook:list){
 %>
   <tr align="center">
      <td><%=newBook.getName() %></td>
      <td><%=newBook.getPrice() %></td>
      <td><%=newBook.getBookCount() %></td>
      <td><%=newBook.getAuthor() %></td>
        <td>
      <form action="UpdateServlet" method="post" onsubmit="return check(this);">
	      <input type="hidden" name="name" value="<%=newBook.getName() %>">
	      <input type="text" name="bookCount" size="3">
	      <input type="submit" value="修改">
	   </form>
      </td>
      </tr>
      
      <%
      }
      } %>

</table>  
</br> 
  </body>
</html>
