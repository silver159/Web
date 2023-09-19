package com.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.service.MvcBoardService;

@WebServlet("*.nhn")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
// 컨트롤러에서 사용한 service 클래스 객체를 얻어온다.	
	private MvcBoardService service = MvcBoardService.getInstance(); // 많이 써서 필드로 생성
	
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 doGet() 메소드");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 doPost() 메소드");
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 actionDo() 메소드");
		
		// 한글 깨짐 방지
		// request: 넘어온 데이터 저장 response: 넘어갈 데이터 저장
		request.setCharacterEncoding("UTF-8"); // 받을 때, getParameter 전에
		response.setContentType("text/html; charset=UTF-8"); // 보낼 때
		
		// 요청을 받기 
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String context = url.substring(contextPath.length()+1, url.length() - 4);
		// System.out.println(context);
		
		// view 페이지 경로 만들기
		String viewpage = "/WEB-INF/";
		switch (context) {
			case "insert":
				viewpage += "insert"; // "/WEB-INF/" + "insert" => "/WEB-INF/insert"
				break;
			case "insertOK":
				
				// insert.jsp에서 테이블에 저장할 메인글 정보를 입력하고 submit 버튼을 클릭하면
				// 폼에 입력한 정보가 컨트롤러의 doPost() 메소드의 HttpServletRequest 인터페이스
				// 타입의 객체인 request에 저장된다.
				// doPost() 메소드 request에 저장된 데이터를 가지고 actionDo() 메소드를 실행하므로
				// insert.jsp에 입력한 메인글 정보는 actionDo() 메소드의 request에 저장된다.
				service.insert(request, response);
				
				viewpage += "index";
				break;
			case "list": // .nhn
				// 브라우저에 출력할 1페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수가
				// 저장된 클래스 객체를 얻어오는 메소드를 호출한다.
				service.selectList(request, response);
				viewpage += "list"; // .jsp
				break;
				
			case "increment":
				// 조회수를 증가시키는 메소드를 호출한다.
				service.increment(request, response);
				viewpage += "increment"; 
				break;
				
			case "contentView":
				// 조회수를 증가시킨 글 1건을 얻어오는 메소드를 호출한다.
				service.selectByIdx(request, response);
				viewpage += "contentView"; 
				break;
				
			case "update":
				// 글 1건을 수정하는 메소드를 호출한다.
				service.update(request, response);
				viewpage += "goList"; 
				break;
				
			case "delete":
				// 글 1건을 삭제하는 메소드를 호출한다.
				service.delete(request, response);
				viewpage += "goList"; 
				break;
				
			case "reply":
				// 답글을 입력하는 페이지에 질문글을 출력하기 위해서 질문글 1건을 얻어와서
				// 입력하는 페이지로 넘겨준다.
				service.selectByIdx(request, response);
				viewpage += "reply";
				break;
				
			case "replyInsert":
				// 답글이 브라우저에 표시될 위치를 정하기 위해서 조건에 만족하는 seq 값을 1씩
				// 증가시킨 후 답글을 저장하는 메소드를 호출한다.
				service.replyInsert(request, response);
				viewpage += "goList";
				break;
		}
		viewpage += ".jsp"; // "/WEB-INF/insert" + ".jsp" => "/WEB-INF/insert.jsp"
		// System.out.println(viewpage);
		
		// view 페이지로 넘기기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
	}
	
}
