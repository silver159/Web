<%@page import="com.tjoeun.onLinePoll.PollWriteEx"%>
<%@page import="com.tjoeun.onLinePoll.PollReadEx"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- pollRead.jsp에서 넘어오는 투표한 항목을 받아서 득표수를 증가시켜 텍스트 파일에 저장한다.  -->

<%
// post 방식으로 데이터가 넘어올 때 한글 깨짐을 방지한다. 한글이 없어도 무조건 써놓고 시작한다.
	request.setCharacterEncoding("UTF-8");
// pollRead.jsp에서 넘어오는 투표 데이터를 받는다.
// 넘어오는 데이터는 항상 String으로 넘어온다. 받을 때는 request.getParameter() 메소드를 사용한다.
	String temp = request.getParameter("poll");

// 에러 체크
// 투표 데이터가 넘어왔나(null 또는 공백이 아닌가?) 검사한다.
// = >  반드시 null 검사를 먼저한다. 순서를 바꾸면 null 때문에 에러가 발생한다.
	if(temp != null && temp.trim().length() !=0)
	{
		// 넘어온 투표 데이터가 숫자인가 검사한다.
		try
		{
			int result = Integer.parseInt(temp);
			// 텍스트 파일을 읽어서 투표 항목의 개수를 계산하나.
			// import시 끝에 커서를 놓고 ctrl + space바
			String filepath = application.getRealPath("/") + "poll.txt";
			ArrayList<String> poll = PollReadEx.pollRead(filepath);
			int itemCount = (poll.size()-1)/2;
			// 넘어온 투표 데이터가 정상적인 투표 범위의 데이터인가 검사한다.
			if(result>0 && result<=itemCount)
			{
				// 여기까지 왔다는 것은 정상적인 투표 데이터가 넘어왔다는 것임으로 투표한
				// 항목의 득표수를 1증가시켜 텍스트 파일에 저장한다.
				// 득표수를 1증가시킬 ArrayList의 위치(index)를 계산한다.
				int index = itemCount + result;
				
				// 득표수를 증가시킨다.
				result = Integer.parseInt(poll.get(index))+1;
				
				// 1증가된 득표수를 ArrayList의 index 번째 위치에 넣는다.
				// poll.set(index, String.valueOf(result)); // 정석 방법
				// poll.set(index,String.format("%s",result)); // 서식 지정
				poll.set(index, ""+result); // 야메
				out.println(poll);
				
				// ArrayList에 저장된 데이터를 파일에 저장하는 메소드를 실행한다.
				PollWriteEx.pollwrite(filepath, poll);
				
				// 투표 결과보기 테이지로 넘겨준다.
				response.sendRedirect("pollResult.jsp");
			}else
			{
				// 넘어온 투표 데이터가 정상적인 투표 범위의 숫자가 아니므로 오류 메시지를
				// 출력하고 pollRead.jsp로 돌려보낸다.
				out.print("<script>");
				out.println("alert('투표 데이터가 정상적인 투표 범위의 숫자가 아닙니다.')");
				out.println("location.href='pollRead.jsp'");
				out.print("</script>");
			}
		}catch(NumberFormatException e)
		{
			// 넘어온 투표 데이터가 숫자가 아니므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.
			out.print("<script>");
			out.println("alert('투표 데이터가 숫자가 아닙니다.')");
			out.println("location.href='pollRead.jsp'");
			out.print("</script>");
		}
	}else
	{
		// 투표 데이터가 넘어오지 않았으므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.
		out.print("<script>");
		out.println("alert('투표하세요')");
		out.println("location.href='pollRead.jsp'");
		out.print("</script>");

// 하나의 jsp 파일에 서버용 스크립트(jsp)와 클라이언트용 스크립트(javascript)를 모두 사용한 경우
// 코딩 순서와는 무관하게 서버용 스크립트가 먼저 다 실행되고 난 후 클라이언트용 스크립트가 실행된다
// response.sendRedirect() 메소드는 인수로 지정한 페이지로 넘겨준다.
		// response.sendRedirect("pollRead.jsp");
	}



%>
</body>
</html>























