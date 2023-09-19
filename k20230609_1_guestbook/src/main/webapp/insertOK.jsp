<%@page import="com.tjoeun.service.InsertService"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	// 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
/*
// inset.jsp에서 넘어오는 데이터를 받는다.
	String name = request.getParameter("name");	
	String password = request.getParameter("password");	
	String memo = request.getParameter("memo");	
	String ip = request.getParameter("ip");	
//	out.println(name + ", " + password + ", " + memo + ", " + ip + "<br/>");
	
	GuestbookVO vo = new GuestbookVO();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMemo(memo);
	vo.setIp(ip);
	out.println(vo);
*/
%>
<!-- 
	useBean 액션 태그로 inset.jsp에서 넘어오는 데이터를 GuestbookVO 클래스 객체에 저장한다. 
	이전 페이지에서 넘어오는 데이터가 GuestbookVO 클래스 필드로 존재하면 useBean으로 받고 
	존재하지 않으면 request.getParameter()를 이용해서 받는다.
	setProperty 액션 태그는 지정한 필드의 setter 메소드를 실행한다.
	property 속성에는 setter 메소드를 실행할 필드 이름을 쓴다.
	name 속성에는 setter 메소드를 실행할 필드가 정의된 객체 이름을 입력한다.
	useBean 액션 태그를 사용하면 이전 페이지에서 form에 저장되서 넘어오는 데이터를 받는
	동작을 별도로 코딩하지 않아도 useBean이 자동으로 받아서 처리한다.
	property 속성에 "*"을 입력하면 모든 필드의 setter 메소드가 일괄적으로 실행된다.
	단, form의 name 속성의 속성값과 같은 이름을 가지는 필드의 setter 메소드만 실행된다.
-->
<jsp:useBean id="vo" class="com.tjoeun.vo.GuestbookVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>
${vo}<br/>

<%
	// vo 클래스 => 글 1건을 기억하는 클래스
	// List 클래스 => 1 페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수를 기억하는 
	// 클래스
	// service 클래스 => sql 명령을 실행하기 전에 필요한 전처리 작업을 실행하는 클래스
	// => 비지니스 로직을 작성하는 클래스
	// DAO(Data Access Object) => sql 명령을 실행하는 클래스 => sql 명령 1개당 메소드 1개
	
	// insert.jsp에서 넘어온 데이터를 guestbook 테이블에 저장한다.
	// 테이블에 저장할 데이터가 저장된 객체(vo)를 전처리 작업을 하기 위해서 service 클래스로
	// 넘겨서 DAO 클래스 sql 명령을 실행하기 전에 필요한 작업이 있다면 실행한다.
	InsertService.getInstance().insert(vo);
	
	
	
	// 테이블에 글 1건을 저장했으면 테이블에 정장된 글을 브라우저에 출력하기 위해서 1페이지
	// 분량의 글 목록을 얻어오는 페이지(list.jsp)로 넘겨준다.
	response.sendRedirect("list.jsp");
%>




</body>
</html>





























