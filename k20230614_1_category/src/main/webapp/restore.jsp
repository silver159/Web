<%@page import="com.tjoeun.vo.CategoryVO"%>
<%@page import="com.tjoeun.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- categoryView2.jsp 데이터 받기 -->
<jsp:useBean id="vo" class="com.tjoeun.vo.CategoryVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>
${vo}

<% 
	CategoryService service = CategoryService.getInstance();
// 복구한 카테고리 이름을 복구 완료 메시지에 표시하기 위해 카테고리를 얻어온다.
	CategoryVO original = service.selectByIdx(vo.getIdx());

// 복구 버튼이 클릭되면 deleteCheck 필드의 값을 "NO"로 수정한다.
	service.deleteRestore(vo.getIdx());
	
// 복구 메시지를 출력하고 카테고리 목록을 얻어오는 페이지(list.jsp)를 호출한다.
	out.println("<script>");
	out.println("alert('"+original.getCategory()+" 카테고리 복구완료!!')");
	out.println("location.href='list.jsp'");
	out.println("</script>");
	// response.sendRedirect("list.jsp"); 이걸로 하면 alert 뜨기 전에 넘어간다.
	// 따라서 <script> 사용하여 location.href='list.jsp'를 이용해서 보내야 한다.
%>

</body>
</html>