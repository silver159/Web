<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
// 조회수를 증가시킨 글번호와 글이 위치하던 페이지 번호를 받는다.
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	// out.println("idx: "+ idx+", currentPage: "+currentPage );
	
// 조회수 증가 테스트	
// 조회수가 증가되는 것을 확인하기 위해 컨트롤러에게 currentPage를 가지고 list.nhn을 요청한다.	
//	response.sendRedirect("list.nhn?currentPage="+currentPage);

// 조회수를 증가시켰으면 컨트롤러에게 조회수를 증가시킨 글을 얻어오는 요청을 한다.
	response.sendRedirect("contentView.nhn?idx="+ idx + "&currentPage=" + currentPage);
	
%>

</body>
</html>