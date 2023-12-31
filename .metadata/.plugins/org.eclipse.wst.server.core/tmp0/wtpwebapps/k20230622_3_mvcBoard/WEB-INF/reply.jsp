<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변하기</title>
</head>
<body>

<!-- 질문글을 보여주는 테이블 -->
<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th colspan="4">질문글 보기</th>
	</tr>
	<tr>
		<th width="80">글번호</th>
		<th width="290">이름</th>
		<th width="150">작성일</th>
		<th width="80">조회수</th>
	</tr>
	<tr>
		<td align="center">${vo.idx}</td>
		<td align="center">
			<!-- 이름에 태그를 적용할 수 없게 한다. -->
			<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
			<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
			${name}
		</td>
		<td align="center">
			<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
		</td>
		<td align="center">${vo.hit}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">
			<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"/>
			<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
			${subject}
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
			<c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"/>
			<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
			<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
			${content}
		</td>
	</tr>
</table><br/>

<!-- 답글을 입력하는 테이블 -->
<form action="replyInsert.nhn" method="post">
	
	<!-- idx, gup, lev, seq, currnetPage -->
	<input type="hidden" name="idx" value="${vo.idx}"/> <!-- 질문글의 글번호 -->
	<input type="hidden" name="gup" value="${vo.gup}"/> <!-- 글그룹 -->
	<input type="hidden" name="lev" value="${vo.lev}"/> <!-- 글레벨 -->
	<input type="hidden" name="seq" value="${vo.seq}"/> <!-- 같은 글그룹에서 글 출력 순서 -->
	<input type="hidden" name=currentPage value="${currentPage}"/> <!-- 답글 입력 후 돌아갈 페이지 번호 -->
	
	<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th colspan="2">답글 쓰기</th>
		</tr>
		<tr>
			<th width="100">이름</th>
			<td width="500">
				<input type="text" name="name" placeholder="이름을 입력하세요.">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" style="width: 98%;">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea 
					rows="10" 
					name="content" 
					style="resize: none; width: 98%;" 
				></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장하기"/>
				<input type="reset"	value="다시쓰기"/>
				<input type="button" value="돌아가기" onclick="history.back()"/>
				<input 
					type="button" 
					value="목록보기"
					onclick="location.href='list.nhn?currentPage=${currentPage}'"
				/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>