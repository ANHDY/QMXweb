<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="cn.edu.bzu.dao.TitleDAO,cn.news.jsp.entity.Title"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Test-newsTitle</title>
  </head>
  
  <body>
  <table border="1">
      <tr>
          <td>id</td>
          <td>name</td>
          <td>creator</td>
      </tr>
        <%
           TitleDAO dao=new TitleDAO();
           List<Title> list =dao.readFirstTitle();    
           for(Title tl:list)
           {%>
          <tr>
              <td><%=tl.getId() %></td>
              <td><%=tl.getName() %></td>
              <td><%=tl.getPassword() %>></td>
          </tr>
            <%}
       %>
  </table>
  </body>
</html>