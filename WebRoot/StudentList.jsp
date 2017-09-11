<%@page import="org.hibernate.Query"%>
<%@page import="com.dc365.hibernatecrud.orm.Student"%>
<%@page import="com.dc365.hibernatecrud.HibernateSessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'StudentList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    Session ss = HibernateSessionFactory.getSession();
	ss.beginTransaction();
	
	Query query = ss.createQuery("from Student");
	
	List<Student> students = query.list();
	ss.getTransaction().commit();
	ss.close();
    
    
     %>
    <center>    
        学生列表
    <br>
    <br>
    <a href="StudentAdd.html">添加</a>
    <br>
    <br>
    
    <table border="1" cellspacing="0" cellpadding="4">
    <tr>
    <th>学号</th><th>姓名</th><th>操作</th>
    </tr>
    <%for(int i=0;i<students.size();i++) { %>
    <tr>
    <td><%=students.get(i).getId() %></td>
    <td><%=students.get(i).getName() %></td>
    <td>
    	<a href="StudentEdit.jsp?ID=<%=students.get(i).getId() %>" >编辑</a> 
    	<a href="servlet/StudentDelete.do?ID=<%=students.get(i).getId() %>" >删除</a> </td>
    </tr>
    <% } %>
    </table>
    <br>
    
    <br>
    <a href="index.jsp">返回</a>
    </center>
    
  </body>
</html>
