package com.tjoeun.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegisger")
public class UserRegisger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegisger() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserRegisger 서블릿이 GET 방식으로 요청됨");
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserRegisger 서블릿이 POST 방식으로 요청됨");
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserRegisger 서블릿의 actionDo() 메소드 실행");
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userID = request.getParameter("userID").trim();
		String userPassword1 = request.getParameter("userPassword1").trim();
		String userPassword2 = request.getParameter("userPassword2").trim();
		String userName = request.getParameter("userName").trim();
		String userAge = request.getParameter("userAge").trim(); // null 체크와 trim() 하기 위해
		String userGender = request.getParameter("userGender").trim();
		String userEmail = request.getParameter("userEmail").trim();
		
		// 입력 체크
		if(userID == null || userID.equals("") || 
				userPassword1 == null || userPassword1.equals("") ||
				userPassword2 == null || userPassword2.equals("") ||
				userName == null || userName.equals("") ||
				userAge == null || userAge.equals("") ||
				userGender == null || userGender.equals("") ||
				userEmail == null || userEmail.equals("")) {
			
			// 입력 체크 실패 메시지를 session에 저장한다.
			// request.getSession(): 서블릿에서 session을 얻어온다.
			// request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			// request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요."); // ①
			// response.sendRedirect("index.jsp"); // ①
			
			// 입력 체크 성공 여부에 따른 메시지를 ajax로 넘겨준다.
			response.getWriter().write("1"); // ②
			return; // 입력 데이터에 오류가 있으므로 서블릿을 종료한다.
		}
		
		// 비밀번호 체크 (자바 스크릿트에서 처리해야 한다.)
		if (!userPassword1.equals(userPassword2)) {
			// 비밀번호 불일치 메시지를 session에 저장한다.
			// request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			// request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다."); // ①
			// response.sendRedirect("index.jsp"); // ①
			
			// 입력 체크 성공 여부에 따른 메시지를 ajax로 넘겨준다.
			response.getWriter().write("2"); // ②
			return; // 입력 데이터에 오류가 있으므로 서블릿을 종료한다.
		}
		
		// 넘어온 데이터가 정상이므로 RegisterVO 클래스 객체를 만들어 저장한다.
		RegisterVO vo = new RegisterVO(userID, userPassword1, userName, Integer.parseInt(userAge),
				userGender, userEmail);
		// System.out.println(vo);
		
		// 테이블에 회원 정보를 저장하는 메소드를 실행한다.
		int result =  new RegisterDAO().regisger(vo);
		// System.out.println(result);
		
		// 저장 체크
		if (result == 1) {
			// insert sql 명령이 정상적으로 실행되었을 때 메시지를 session에 저장한다.
			// request.getSession().setAttribute("messageType", "성공 메시지"); // ①
			// request.getSession().setAttribute("messageContent", "회원가입에 성공했습니다."); // ①
			
			// insert sql 명령이 정상적으로 실행되었을 때 메시지를 ajax로 넘겨준다.
			response.getWriter().write("3"); // ②
			
		}else {
			// insert sql 명령이 정상적으로 실행되지 않았을 때 메시지를 session에 저장한다.
			// request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			// request.getSession().setAttribute("messageContent", "이미 존재하는 아이디입니다."); // ①
			
			// insert sql 명령이 정상적으로 실행되지 않았을 때 메시지를 ajax로 넘겨준다.
			response.getWriter().write("4"); // ②
		}
		// response.sendRedirect("index.jsp"); // ①
	}
}
