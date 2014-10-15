<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Search author.jsp' starting page</title>

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
	<center>
		<table border="1">
			<s:iterator value="b" id="book">
				<tr>
					<td><s:property value="book" /></td>
				</tr>
				<td><a
					href='<s:url action="searchbook">
    <s:param name ="name" value = "book"></s:param>
    </s:url>'>
						VIEW DETAIL </a>
				</td>
				<tr>
			</s:iterator>
		</table>
	</center>

	<input type="button" value="return"
		onclick="window.location.href='Select.jsp'">
</body>
</html>
