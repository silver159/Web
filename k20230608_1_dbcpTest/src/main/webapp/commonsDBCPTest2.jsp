<%@page import="com.tjoeun.decpTest.DBUtil"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP</title>
</head>
<body>

<% 
	Connection conn = DBUtil.getcommonsDBCPConnection();
	out.println("연결성공: " + conn + "<br/>");
	DBUtil.close(conn);

%>


</body>
</html>