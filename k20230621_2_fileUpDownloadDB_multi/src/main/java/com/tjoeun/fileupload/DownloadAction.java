package com.tjoeun.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 브라우저의 주소창에 ContextPath 뒤에 @WebServlet 어노테이션의 인수로 지정된 요청이 들어오면
// 즉, "/k20230621_1_fileDownload"(프로젝트 이름) 뒤에 "/DownloadAction" 가 붙어서 
// "/k20230621_1_fileDownload/DownloadAction" 처럼 요청되면 @WebServlet("/DownloadAction")
// 어노테이션이 붙어있는 클래스의 doGet() 또는 doPost() 메소드가 자동으로 실행된다.
@WebServlet("/DownloadAction")
public class DownloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadAction() {
        super();
    }

// 서블릭이 get 방식으로 요청될 때 자동으로 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("get 방식으로 요청되면 자동으로 실행된다.");
		// System.out.println("doGet(): "+request.getParameter("file"));
		actionDo(request, response);
	}

// 서블릭이 post 방식으로 요청될 때 자동으로 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("post 방식으로 요청되면 자동으로 실행된다.");
		// request.setCharacterEncoding("UTF-8");
		// System.out.println("doPost(): "+request.getParameter("name"));
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("actionDo() 메소드 실행");
		request.setCharacterEncoding("UTF-8"); // 받을 때 한글 깨짐 방지, getParameter 전에
		response.setContentType("text/html; charset=UTF-8"); // 보낼 때 한글 깨짐 방지
		
		// fileDownload.jsp에서 넘어오는 업로드한 파일 이름과 실제 디스크에 저장된 파일 이름을
		// 받는다.
		String filename = request.getParameter("file"); // 업로드한 파일 이름
		String fileRealname = request.getParameter("realfile"); // 실제 디스크에 저장된 파일 이름
		
		// 다운로드 할 파일이 저장된 실제 물리적 디렉토리 경로를 다운로드 할 파일 이름과 연결한다.
		String uploadDirectory = "C:/upload/" + fileRealname;
		
		// 다운로드 할 파일 객체를 만든다.
		File file = new File(uploadDirectory);
		
		// MIME: Multipurpose Internet Mail Extension의 약자로 파일 변환을 의미한다.
		// getMimeType(): 인수로 지정된 파일의 MIME 타입을 얻어온다.
		String mimeType = getServletContext().getMimeType(file.toString());
		// System.out.println(mimeType);
		// MIME 타입을 얻어오지 못했다면 파일을 전송하는 것을 사용자에게 알려주기 위해 
		// response 객체를 사용해서 파일 형태의 데이터를 전송한다는 것을 사용자에게 알려준다.
		if(mimeType == null) {
			response.setContentType("application/octet-stream");
		}
		
		// 접속한 브라우저에 따라 다운로드 할 파일의 헤더 정보를 다르게 설정한다. 파일이름 만들기
		String downloadName = "";
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) { // user-agent 접속한 브라우저
			// 인터넷 익스플로러를 제외한 나머지 브라우저
			downloadName = new String(filename.getBytes("UTF-8"), "8859_1");
		}else {
			// 인터넷 익스플로러
			downloadName = new String(filename.getBytes("EUC-KR"), "8859_1");
		}
		
		
		
		// 파일 이름을 헤더에 저장한다.
		// attachment 뒤의 filename은 반드시 큰따옴표를 사용해서 묶어야 한다. => \"를 사용한다.
		response.setHeader("Content-Disposition", "attachment;filename=\""+downloadName + "\";");
		
		
		
		// 파일을 전송할 준비를 한다.
		// 다운로드 할 디스크의 파일을 읽어들이는 객체를 선언한다.
		FileInputStream fileInputStream = new FileInputStream(file);
		
		// 다운로드를 실행할 브라우저로 파일을 전송하는 객체를 선언한다.
		ServletOutputStream outputStream = response.getOutputStream();
		
		// 파일을 1024 바이트(1KB) 단위로 전송하기 위한 byte 배열을 선언한다.
		byte[] b =  new byte[1024];
		int data = 0;
		
		// 디스크에서 읽어들인 전송할 파일에 데이터가 남아있는 동안 반복하며 브라우저로 파일을
		// 전송한다.
		// read(배열 이름, 시작 인덱스, 마지막 인덱스): FileInputStream 객체에서 파일을 바이트
		// 단위로 읽는다.
		// read() 메소드는 파일에서 읽어들인 데이터를 배열의 시작 인덱스 부터 마지막 인덱스
		// 까지 패우고 읽어들인 크기를 리턴한다. => 읽어들인 데이터가 없으면 -1을 리턴한다.
		
		while((data = fileInputStream.read(b, 0, b.length))!= -1) { 
			// 전송할 파일에서 읽어들인 데이터가 있는가?
			outputStream.write(b, 0, data);
		}
		
		// flush() 메소드로 ServletOutputStream 객체의 출력 버퍼에 저장된 모든 데이터를 
		// 전송하고 전송에 사용한 모든 객체를 닫는다.
		outputStream.flush();
		outputStream.close();
		fileInputStream.close();
		
		// 다운로드가 완료되면 다운로드 횟수를 증가시킨다.
		new FileDAO().hit(fileRealname);
	}
}
