/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-06-27 06:29:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class summary_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>한국을 빛낸 100명의 위인들 개요</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h2>한국을 빛낸 100명의 위인들 개요</h2>\r\n");
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("대한민국 역사의 위인들을 고조선 시대부터 근대~현대 초기까지 나열하는 가요 겸 동요[4]이다.<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("1990년 12월 창단된 어린이 역사노래 부르기회에 속한 박문영[5]이 작사·작곡했으며 같은 단체에 속한,<br/> \r\n");
      out.write("1991년 처음 발표할 당시에는 코미디언 최영준과 대학생 노래패 노사사(노래를 사랑하는 사람들)가 불렀다.<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("1절에는 상고 시대부터 삼국시대까지의 인물이, 2절에는 남북국 시대부터 고려 시대까지의 인물이[6],<br/>\r\n");
      out.write("3절에는 조선 전기 인물이, 4절에는 조선 후기 인물이, 5절에는 근·현대(일제강점기, 대한민국) 인물이<br/>\r\n");
      out.write("주로 등장한다. 자라면서 1절 정도 빼고는 다 잊어버리기 십상이지만,[7] 실제로는 고등학교 국사 시간까지<br/> \r\n");
      out.write("편하게 만들어 주는 위대한 곡이다. 다만, 한국을 빛낸 100명의 위인들로 노래를 만든 것까진 좋았어도 역사적<br/>\r\n");
      out.write("사실과는 다소 거리가 있는 구절이 있어 아쉬움이 있다. 근현대사는 다소 지엽적인 부분만 나와있고<br/>\r\n");
      out.write("지눌과 의천처럼 수십 년의 연대가 차이나는 사람의 위치가 바뀌거나 중종 때의 사람인 황진이, 순조<br/> \r\n");
      out.write("때의 홍경래가 전봉준 뒤에 있다거나, 고려시대 인물로 쭉 진행되고 있는 와중에 느닷없이 조선시대<br/> \r\n");
      out.write("인물인 이종무가 나온다거나, 영조와 정조 앞에 김삿갓이 나오는 등 순서를 외우기에는 부적합하다.<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("게다가 기본적으로 넣기에는 너무 곤란한 인물들이 한가득이다. 이는 위인이라고 칭할 수 없는 내용이<br/> \r\n");
      out.write("너무 큰 게 원인이다. 100명을 채우기 위해 억지로 갖다 붙인 인물들만 수십 명에 달하는데, 죽림칠현,<br/> \r\n");
      out.write("사육신과 생육신, 태정태세문단세 등만 합쳐도 26명이다. 이 외에도 정중부나 이완용처럼 부정적인<br/> \r\n");
      out.write("인물들도 수십명이니 적어도 절반 이상은 위인이 아니라 구색 맞추기. 총 5권짜리 만화에서는 갖다<br/> \r\n");
      out.write("붙인 인물들에 대해서는 어떻게든 나오기는 했지만[8] 노래 4절 후반부 ~ 5절의 근현대사 인물들은<br/> \r\n");
      out.write("더욱더 가관이라 만화책 작가도 결국 포기하여 만화책 중 5권만 위인들 이름 앞에 번호가 안 나와서<br/> \r\n");
      out.write("순서가 아주 개판이 되어버렸다. 매국노인 이완용이나 번안소설 장한몽의 등장인물들이자 실존인물들이<br/> \r\n");
      out.write("아닌 이수일과 심순애 같은 이상한 사람들은 다 빼버리고 대신 윤봉길, 김구, 주시경, 나운규 등<br/> \r\n");
      out.write("노래에는 없는 일부 인물들이 추가로 올라가 있다. 그래도 김좌진 대신에 김두한을 넣은 건 아쉬운 점.<br/> \r\n");
      out.write("장군의 아들 김두한이라고 나오니 둘 다 들어간거라고 해석할 수도... 원작자가 감수, 글을 맡은<br/> \r\n");
      out.write("동명의 아동용 학습만화도 몇 권 나왔다.<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("<a href=\"./index.jsp\">돌아가기</a>\r\n");
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