/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-06-28 10:20:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tjoeun.fileupload.FileDAO;
import java.io.File;
import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public final class uploadAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Enumeration");
    _jspx_imports_classes.add("com.oreilly.servlet.multipart.DefaultFileRenamePolicy");
    _jspx_imports_classes.add("com.tjoeun.fileupload.FileDAO");
    _jspx_imports_classes.add("java.io.File");
    _jspx_imports_classes.add("com.oreilly.servlet.MultipartRequest");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
 
	request.setCharacterEncoding("UTF-8");
	MultipartRequest multipartRequest = new MultipartRequest(
		request,
		// application.getRealPath("./upload/"),
		// 보안성 향상을 위해 upload 폴더를 프로젝트와 상관없는 webapp 외부에 만든다.
		"C:/upload/",  
		5 * 1024 * 1024 * 1024,
		"UTF-8",
		new DefaultFileRenamePolicy()
	);
	
// index.jsp에서 넘어오는 업로드 할 파일 이름 여러개를 받는다.	
	Enumeration filenames = multipartRequest.getFileNames();
	
// hasMoreElements(): Enumeration 인터페이스 객체에 저장된 다음 데이터가 있으면 true, 없으면
// false를 리턴시킨다.
	while (filenames.hasMoreElements()){ // 업로드 할 파일이 있는 동안 반복한다.
		// nextElement(): Enumeration 인터페이스 객체에 저장된 다음에 처리한 데이터를 얻어온다.
		String parameter = (String)filenames.nextElement();
		// 업로드 페이지의 type 속성이 file로 설정된 개체를 역순으로 얻어온다.
		// out.println(parameter + "<br/>");
		
		String filename = multipartRequest.getOriginalFileName(parameter);
		String fileRealname = multipartRequest.getFilesystemName(parameter);
		// 업로드 할 파일이 넘어오지 않았으면 다음 파일을 처리한다.
		// => 남은 반복문을 실행할 필요없다.
		if(filename == null) {
			continue;
		}
		// out.println("원본 파일 이름: "+filename + "<br/>");
		// out.println("실제 업로드된 파일 이름: "+ fileRealname + "<br/>");
		
		// 업로드 제한
		File realFilename = new File("C:/upload/" + fileRealname);
		// length(): 파일의 크기를 얻어온다.
		long fileLength = realFilename.length();
		out.println("파일 크기: " + fileLength +"<br/>");
		
		if(fileLength > 5 * 1024 * 1024){ // 용량 제한
			out.println("<script>");
			out.println("alert('업로드 용량 초과')");
			out.println("</script>");
			
			// delete(): 파일을 삭제한다.
			realFilename.delete();
			
		}else if (!fileRealname.endsWith(".zip") && !fileRealname.endsWith(".png")){ // 파일 종류 제한
			// startsWith(): 인수로 지정된 문자열로 파일 이름이 시작하면 true, 그렇지 않으면 
			// false를 리턴한다.
			// endsWith(): 인수로 지정된 문자열로 파일 이름이 끝나면 true, 그렇지 않으면
			// false를 리턴한다. 확장명 제한시 사용한다.
			
			out.println("<script>");
			out.println("alert('업로드할 수 있는 형식의 파일이 아닙니다.\\n"+
						"zip 파일과 png 파일만 업로드 가능합니다.')");
			out.println("</script>");
			
			realFilename.delete();
			
		}else {
			out.println("<script>");
			out.println("alert('업로드 성공')");
			out.println("</script>");
			
			// filename과 fileRealname을 테이블에 저장하는 메소드를 호출한다.
			new FileDAO().upload(filename, fileRealname); // 익명으로 실행하기
		}
		out.println("<script>");
		out.println("location.href='index.jsp'");
		out.println("</script>"); 
		
	}
	
	
	
	
	
	

      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}