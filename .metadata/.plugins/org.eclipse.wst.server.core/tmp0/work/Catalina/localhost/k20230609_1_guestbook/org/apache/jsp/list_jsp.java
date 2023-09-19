/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-06-29 12:42:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tjoeun.service.SelectService;
import com.tjoeun.vo.GuestbookList;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.tjoeun.service.SelectService");
    _jspx_imports_classes.add("com.tjoeun.vo.GuestbookList");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!--  \r\n");
      out.write("	currentPage를 넘겨받아 currentPage에 해당되는 1페이지 분량의 글 목록을 테이블에서\r\n");
      out.write("	얻어와서 request 영역에 저장한 후 1페이지 분량의 글을 브라우저에 출력하는 페이지\r\n");
      out.write("	(listView2.jsp)로 넘겨준다.\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
 
	request.setCharacterEncoding("UTF-8");
// 이전 페이지에서 넘어오는 화면에 표시할 글 번호(currentPage)를 받는다.
// 게시판이 최초로 실행될 때 또는 insertOK.jsp에서 호출될 때 list.jsp로 currentPage가
// 넘어오지 않는다. => null
// null은 parseInt() 메소드는 실행했을 때 NumberFormatException이 발생되므로 예외
// 처리를 해야한다.
// 이전 페이지에서 넘어오는 currentPage가 없으면 currentPage를 1로 초기화 시켜 사용하고
// 넘어오는 currentPage가 있으면 넘어온 currentPage 값으로 초기화시켜 사용한다.
	int currentPage = 1;
	try{
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}catch(NumberFormatException e){
		
	}

// 카테고리와 검색어를 받는다.
	String category = request.getParameter("category"); // 카테고리
	String item = request.getParameter("item"); // 검색어
// 넘어온 검색어가 있으면 카테고리와 검색어를 세션에 저장하고 넘어온 검색어가 없으면 세션에 
// 저장된 카테고리와 검색어를 읽어온다.
	if (item != null) {
		session.setAttribute("category", category);
		item = item.trim().length() == 0 ? "" : item;
		session.setAttribute("item", item);
	} else {
		category = (String) session.getAttribute("category");
		item = (String) session.getAttribute("item");
	}
	
// 브라우저 화면에 표시할 1페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수를 초기화 
// 시키는 메소드를 실행한다.
// 검색어가 넘어온 경우 (내용, 이름, 내용+이름)와 넘어오지 않은 경우에 따른 메소드를
// 각각 실행한다.
	SelectService service = SelectService.getInstance();
	GuestbookList guestbookList = null;
	
	/*
// 검색어가 없는 경우와 검색어가 있을 때 카테고리가 내용, 이름, 내용+이름인 경우 각각 메소드로
// 구현한다.
	if (item == null || item.trim().length() == 0) { // 검색어가 넘어왔는가?
		// 검색어가 입력되지 않은 경우
		guestbookList = service.selectList(currentPage);
	} else if (category.equals("내용")) {
		// 검색어가 입력되고 카테고리가 "내용"인 경우
		guestbookList = service.selectListMemo(currentPage, item);
	} else if (category.equals("이름")) {
		// 검색어가 입력되고 카테고리가 "이름"인 경우
		guestbookList = service.selectListName(currentPage, item);
	} else if (category.equals("내용+이름")) {
		// 검색어가 입력되고 카테고리가 "내용+이름"인 경우
		guestbookList = service.selectListMemoName(currentPage, item);
	}
	*/
	
// 검색어가 있는 경우와 검색어가 없는 경우로 메소드를 구현한다.	
	if (item == null || item.trim().length() == 0) { // 검색어가 넘어왔는가?
		// 검색어가 입력되지 않은 경우
		guestbookList = service.selectList(currentPage);
	} else {
		// 검색어가 입력된 경우 (카테고리 구별을 xml에서 한다.)
		guestbookList = service.selectListMulti(currentPage, category, item);
	}
	
	
// 1페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수가 초기화된 객체를 얻어와서 
// request 영역에 저장한다.
	request.setAttribute("guestbookList", guestbookList);

// textarea에 글을 입력할 때 엔터키를 눌러 줄을 바꿔 입력한 경우 브라우저에 </br>
// 태그로 바꿔 출력하기 위해 request 영역에 "\r\n"을 저장한다.
	request.setAttribute("enter", "\r\n"); // 에러 날 것 같으면 request 넣어서 넘겨준다.
	
// request 영역에 저장된 글 목록을 브라우저에 표시하는 페이지(listView2.jsp)로 넘겨준다.
	pageContext.forward("listView2.jsp");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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