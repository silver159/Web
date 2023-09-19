<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mysql에 연결하기</title>
</head>
<body>

<% 
	// 데이터베이스 연결에 사용할 객체를 선언한다.
	Connection conn = null;
	try{
		// mysql 드라이버 클래스를 읽어온다.
		Class.forName("com.mysql.jdbc.Driver");// mysql 5.x 사용자, ClassNotFoundException
		// mysql에 연결해서 Connection 객체에 저장한다.
		// DriverManager 클래스의 getConnection(url, user, password) 메소드로 mysql에 연결한다.
		// url에 사용할 mysql이 설치된 경로와 데이터베이스 이름을 적는다.
		String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; // mysql 5.x 사용자
		// localhost는 접속할 MySQL이 설치된 컴퓨터가 현재 사용중인 컴퓨터임을 의미하며
		// localhost 대신 127.0.0.1을 사용해도 된다.
		// 3306은 MySQL이 컴퓨터와 통신할 때 사용하는 포트 번호를 의미한다.
		// => 오라클은 1521을 사용한다.
		conn = DriverManager.getConnection(url, "root", "0000");
	}catch(ClassNotFoundException e){
		out.println("드라이버 클래스가 없거나 읽어올 수 없습니다");
	}catch(MySQLSyntaxErrorException e){
		
	}catch(SQLException e){
		out.println("데이터베이스가 없거나 이름이 틀렸습니다");
	}finally{
		if(conn != null){try{conn.close();}catch(SQLException e){e.printStackTrace();}}
	}
	
%>




</body>
</html>