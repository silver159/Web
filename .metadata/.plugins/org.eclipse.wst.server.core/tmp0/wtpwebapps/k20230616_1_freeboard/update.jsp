<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정할 글 보기</title>
<!-- bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- bootstrap icon -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<form class="m-3" action="updateOK.jsp" method="post">
	<table class="table" style="width: 700px; margin-left: auto; margin-right: auto">
		<tr class="table-danger">
			<th colspan="4" style="font-size: 30px; text-align: center;">수정할 글 보기</th>
		</tr>
		<tr class="table-dark">
			<td style="width: 100px; text-align: center;">글번호</td>
			<td style="width: 350px; text-align: center;">이름</td>
			<td style="width: 150px; text-align: center;">작성일</td>
			<td style="width: 100px; text-align: center;">조회수</td>
		</tr>
		<tr>
			<td align="center">${vo.idx}</td>
			<td align="center">
				<!-- 이름에 태그를 적용할 수 없게 한다. -->
				<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
				<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
				${vo.name}
			</td>
			<!-- 오늘 날짜를 기억하는 Date 클래스 객체를 useBean으로 만든다. -->
			<jsp:useBean id="date" class="java.util.Date"/>
			<td align="center">
				<!-- 오늘 입력된 글은 시간만 어제 이전에 입력된 글은 날짜만 출력한다. -->
				<fmt:formatDate var="today" value="${date}" pattern="yyyy.MM.dd(E)"/>
				<fmt:formatDate var="day" value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
				<%-- today: ${today}, day: ${day} --%>
				<c:if test="${today == day}">
					<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm:ss"/>
				</c:if>
				<c:if test="${today != day}">
					<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
				</c:if>
			</td>
			<td align="center">${vo.hit}</td>
		</tr>
		<tr>
			<th class="aligh-middle">
				<label for="subject">제목</label>
			</th>
			<td colspan="2">
				
				<%-- 
				<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"/>
				<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
				${subject} 
				--%>
				<input 
					id="subject"
					class="form-control form-control-sm" 
					type="text" 
					name="subject"
					value="${vo.subject}"
				/>
			</td>
			<th class="align-miggle table-info" width="100" style="text-align: center;">
				공지글
				<c:if test="${fn:trim(vo.notice) == 'on'}"><!-- 공지글인가? -->
					<input class="form-check-input" type="checkbox" name="notice" checked="checked"/>
				</c:if>
				<c:if test="${fn:trim(vo.notice) != 'on'}"><!-- 일반글인가? -->
					<input class="form-check-input" type="checkbox" name="notice"/>
				</c:if>
			</th>
		</tr>
		<tr>
			<th class="aligh-middle">
				<label for="content">내용</label>
			</th>
			<td colspan="3">
				<%-- 
				<c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"/>
				<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
				<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
				${content} 
				--%>
				<textarea 
					id="content"
					class="form-control form-control-sm" 
					rows="10"
					name="content"
					style="resize: none;"
				>${vo.content}</textarea>
			</td>
		</tr>
		<tr class="table-secondary">
			<td colspan="4" align="center">
				<div 
					class="row g-3 align-items-center" 
					style="width: 90%; margin-left: auto; margin-right: auto;"
				>
					<div class="col-auto">
						<label for="password">비밀번호</label>
					</div>
					<div class="col-auto">
						<input 
							id="password"
							class="form-control form-control-sm" 
							type="password" 
							name="password"
							style="font-size: 13px;"
						/>
					</div>
					<div class="col-auto">
						<input
							class="btn btn-outline-primary btn-sm" 
							type="submit"
							value="수정하기"
							style="font-size: 13px;"
						/>
						<input
							class="btn btn-outline-danger btn-sm" 
							type="reset"
							value="다시쓰기"
							style="font-size: 13px;"
						/>
						<input
							class="btn btn-outline-warning btn-sm" 
							type="button"
							value="돌아가기"
							style="font-size: 13px;"
							onclick="history.back()"
						/>
						<input
							class="btn btn-outline-success btn-sm" 
							type="button"
							value="목록보기"
							style="font-size: 13px;"
							onclick="location.href='list.jsp?currentPage=${currentPage}'"
						/>
					</div>
				</div>
			</td>
		</tr>
	</table>
	
	<!--  -->
	<input type="hidden" name="idx" value="${vo.idx}"/>
	<input type="hidden" name="currentPage" value="${currentPage}"/>
	
</form>




</body>
</html>