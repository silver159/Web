<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jstl을 사용하겠다고 알려준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>
<link rel="stylesheet" href="./guestbook.css"/>
</head>
<body>

<!-- jstl을 사용하는 post 방식의 한글 깨짐 방지 -->
<!-- request.setCharacterEncoding("UTF-8"); -->
<fmt:requestEncoding value="UTF-8"/>

<%-- 
	EL을 사용하면 request(session 등) 영역에 저장된 데이터를 받아 처리없이 사용할 수 있다.
	GuestbookList guestbookList = (GuestbookList) request.getAttribute("guestbookList");
	out.println(guestbookList);
	위의 2줄을 EL을 사용하면 ${guestbookList}와 같이 사용할 수 있다. (request 변수 이름만)
	
	EL을 사용하면 객체 내부의 데이터(필드에 저장된 값)를 ${객체이름.필드이름}의 형태로 얻어올
	수 있다.
	=> getter가 자동으로 실행된다.
	out.println(guestbookList.getList());
	위의 문장을 EL을 사용하면 ${guestbookList.list}와 같이 사용할 수 있다.
	
	jstl 대입문 => c:set
	<c:set var="변수이름" value="변수에 저장할 데이터"></c:set>
	ArrayList<GuestbookVO> view = guestbookList.getList();
	위의 문장은 EL을 사용하면 <c:set var="view" value="${guestbookList.list}"></c:set>와 같이
	사용할 수 있다.
	
	jstl if문 => c:if => else를 사용할 수 없다. => else 처리가 필요하면 조건을 반대로 해서
	변도의 if를 만들어 사용한다.
	<c:if test="${조건식}">
		조건식이 참일 경우 실행할 문장
	</c:if>
	
	jstl 일반 for문: 초기치 부터 최종치 까지 증가치 만큼 증가하며 반복한다.
	=> 증가치는 생략하면 1이 기본값으로 사용되고 반드시 양수만 사용해야 한다.
	<c:forEach var="변수 이름" begin="초기치" end="최종치" [step="증가치"]>
		반복할 문장
	</c:forEach>
	
	jstl 향상된 for문: 객체에 저장된 내용이 변수에 처음 부터 마지막 까지 차례대로 대입되며
	반복한다.
	<c:forEach var="변수 이름" items="${배열이나 List 형태의 객체}">
		반복할 문장
	</cLforEach>
	
	jstl 함수 사용하기
	${fn:함수 이름(인수)}
	
	jstl 날짜 서식 => pattern에 넣는 날짜 서식을 지정하는 방법은 자바와 같다.
	<fmt:formatDate value="${날짜 데이터}" pattern="날짜 서식"></fmt:formaDate>
--%>

<c:set var="view" value="${guestbookList.list}"></c:set>

<table width="1000" border="1" align="center" cellpadding="5" cellspacing="0">
	<tr>
		<th>방명록 쓰기</th>
	</tr>
	<tr>
		<td align="right">
			${guestbookList.totalCount}(${guestbookList.currentPage}/${guestbookList.totalPage})
		</td>
	</tr>
	<tr>
		<td>
			<!-- 테이블에 저장된 글이 없으면 없다고 출력한다. -->
			<c:if test="${view.size() != 0}">
				<!-- useBean으로 컴퓨터 시스템의 날짜와 시간을 얻어오는 Date 클래스 객체를
				만든다. -->
				<jsp:useBean id="date" class="java.util.Date"/>
				<%-- ${date} --%>
				
				<c:forEach var="vo" items="${view}">
					<table class="table" width="99%" border="1" align="center" cellpadding="5" cellspacing="0">
						<tr>
							<td>
								${vo.idx}.
								<!-- 이름에 태그가 먹지 않도록 repleace 함수를 적용한다. -->
								<c:set var="name" value="${fn:replace(vo.name,'<','&lt;')}"></c:set>
								<c:set var="name" value="${fn:replace(name,'>','&gt;')}"></c:set>
								${name}(${vo.ip})님이
								
								<!-- 오늘 작성된 글은 시간만 어제 이전에 작성된 글은 날짜만 출력한다. -->
								<fmt:formatDate value="today" value="${date}" patten="yyyy.MM.dd(E)"/>
								<fmt:formatDate value="day" value="${vo.writeDate}" patten="yyyy.MM.dd(E)"/>
								<%-- today: ${today}, day: ${day} --%>
								<!-- 자바와 다르게 equals가 아니라 == 를 사용해 비교한다. -->
								<c:if test="${today == day}">
									<fmt:formatDate value="${vo.writeDate}" pattern="HH:mm"/>
								</c:if>
								<c:if test="${today != day}">
									<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
								</c:if>
								
								에 남긴글
								<input
									class="button button1"
									type="button"
									value="수정"
									onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${guestbookList.currentPage}&job=update'"
								>
								<input
									class="button button1"
									type="button"
									value="삭제"
									onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${guestbookList.currentPage}&job=delete'"
								>
								<br/>
								
								<!-- 메모에 태그가 먹지 않도록 줄이 바뀌도록 replace 함수를 적용한다. -->
								<c:set var="memo" value="${fn:replace(vo.memo, '<', '&lt;')}"></c:set>
								<c:set var="memo" value="${fn:replace(memo, '>', '&gt;')}"></c:set>
								<c:set var="memo" value="${fn:replace(memo, enter, '<br/>')}"></c:set>
								${memo}
							</td>
						</tr>
					</table>
				</c:forEach>
			</c:if>
		</td>
	</tr>
	
	<tr>
		<td align="center">
			
			<!-- 처음으로 -->
			<c:if test="${guestbookList.currentPage >1}">
				<button 
					type="button" 
					class='button button1' 
					title="첫 페이지로 이동합니다." 
					onclick="location.href='?currentPage=1'"
				>처음</button>
			</c:if>
			
			<c:if test="${guestbookList.currentPage <= 1}">
				<button 
					type="button" 
					class='button button2' 
					disabled="disabled" 
					title="이미 첫 페이지 입니다"
				>처음</button>
			</c:if>
			
			<!-- 10페이지 앞으로 -->
			<c:if test="${guestbookList.startPage >1}">
				<button 
					type="button" 
					class='button button1' 
					title="이전 10 페이지로 이동합니다." 
					onclick="location.href='?currentPage=${guestbookList.startPage - 1}'"
				>이전</button>
			</c:if>
			
			<c:if test="${guestbookList.startPage <= 1}">
				<button 
					type="button" 
					class='button button2' 
					disabled="disabled" 
					title="이미 첫 10페이지 입니다"
				>이전</button>
			</c:if>
			
			<!-- 페이지 이동버튼 -->
			<c:forEach var="i" begin="${guestbookList.startPage}" end="${guestbookList.endPage}" step="1">
				<c:if test="${guestbookList.currentPage == i}">
					<button 
						class='button button2' 
						type='button' 
						disabled='disabled'
					>${i}</button>
				</c:if>
				
				<c:if test="${guestbookList.currentPage != i}">
					<button 
						class='button button1' 
						type='button' 
						title="${i}페이지로 이동합니다." 
						onclick="location.href='?currentPage=${i}'"
					>${i}</button>
				</c:if>
			</c:forEach>
			
			<!-- 10페이지 뒤로 -->
			<c:if test="${guestbookList.endPage < guestbookList.totalPage}">
				<button 
					type="button" 
					class='button button1' 
					title="다음 10 페이지로 이동합니다." 
					onclick="location.href='?currentPage=${guestbookList.endPage + 1}'"
				>다음</button>
			</c:if>
			
			<c:if test="${guestbookList.endPage >= guestbookList.totalPage}">
				<button 
					type="button" 
					class='button button2' 
					disabled="disabled" 
					title="이미 마지막 10페이지 입니다"
				>다음</button>
			</c:if>
			
			<!-- 마지막 -->
			<c:if test="${guestbookList.currentPage < guestbookList.totalPage}">
				<button 
					type="button" 
					class='button button1' 
					title="마지막 페이지로 이동합니다." 
					onclick="location.href='?currentPage=${guestbookList.totalPage}'"
				>마지막</button>
			</c:if>
			
			<c:if test="${guestbookList.currentPage >= guestbookList.totalPage}">
				<button 
					type="button" 
					class='button button2' 
					disabled="disabled" 
					title="이미 마지막 페이지 입니다"
				>마지막</button>
			</c:if>
	
		</td>
	</tr>
	
	<!-- 글쓰기 버튼 -->
	<tr>
		<td align="right">
			<input 
				class="button button1" 
				type="button" 
				value="글쓰기" 
				onclick="location.href='insert.jsp'"
			/>
		</td>
	</tr>	
	
	
</table>



</body>
</html>



























