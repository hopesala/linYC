<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Book.jsp' starting page</title>
    
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
    ISBN: <s:property value = "target_book.ISBN"/> <br>
    Title:<s:property value = "target_book.Title"/> <br>
    Publish:<s:property value = "target_book.Publisher"/> <br>
    PublishDate:<s:property value = "target_book.PublishDate"/> <br>
    Price <s:property value = "target_book.Price"/> <br>
    
    Author: <s:property value = "target_author.Name"/> <br>
    Age:<s:property value = "target_author.Age"/> <br>
    Country:<s:property value = "target_author.Country"/> <br>
  </table>
	<input type="button" value="return" onclick="window.location.href='Select.jsp'">
	<s:form action = "deletebook">
	<s:hidden name = "target_bookIsbn" value="%{target_book.ISBN}"/>
	<s:submit value="delete">
	</s:submit>
	</s:form>
  </body>
</html>
