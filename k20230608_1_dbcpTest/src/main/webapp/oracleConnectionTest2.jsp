<%@page import="com.tjoeun.decpTest.DBUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>oracle Connection</title>
</head>
<body>

<% 
	Connection conn = DBUtil.getOracleConnection();
	out.print("연결성공: " + conn + "<br/>");
	DBUtil.close(conn);
%>


</body>
</html>