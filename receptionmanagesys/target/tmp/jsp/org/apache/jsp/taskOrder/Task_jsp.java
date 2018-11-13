/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.0.v20161208
 * Generated at: 2018-11-10 05:10:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.taskOrder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Task_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#submit\").click(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(window.confirm(\"是否提交\")){\r\n");
      out.write("\t\t\talert(\"提交成功\");\r\n");
      out.write("\t\t\tlocation.reload();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//window.location.href=\"/taskOrder/Task.jsp\"; \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\" padding:3px 2px;border-bottom:1px solid #ccc\">添加任务单</div>\r\n");
      out.write("\t<form id=\"ff\" action=\"/InsertTaskOrder\" method=\"post\">\r\n");
      out.write("\t\t<table style=\"padding-left: 30% \">\r\n");
      out.write("\t\t<tr><td>任务情况:</td></tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td >来宾单位:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"VisitorOrg\" type=\"text\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t\t<td >任务名称:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"taskname\" type=\"text\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<td>主宾姓名:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"name\" type=\"text\"></input></td>\r\n");
      out.write("\t\t\t\t<td>职务:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"zhiwu\" type=\"text\"></input></td>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t</tr> -->\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td >抵达时间:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"VisitorDate\" type=\"date\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t\t<td required=\"required\">离开时间:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"leaveDate\" type=\"date\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td >人数:</td>\r\n");
      out.write("\t\t\t\t<td ><input name=\"VisitorNum\" type=\"text\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- <td>男:<input name=\"name\" type=\"radio\"></input></td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td>女:<input name=\"name\" type=\"radio\"></input></td>\r\n");
      out.write("\t\t\t -->\r\n");
      out.write("\t\t\t \t<td>籍貫單位\r\n");
      out.write("\t\t\t<select name=\"inviteOrgId\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<option>12</option>\r\n");
      out.write("\t\t\t<option>13</option>\r\n");
      out.write("\t\t\t<option>14</option>\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td> 访问形式:\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"visittypeId\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<option>1</option>\r\n");
      out.write("\t\t\t<option>2</option>\r\n");
      out.write("\t\t\t<option>3</option>\r\n");
      out.write("\t\t\t<option>4</option>\r\n");
      out.write("\t\t\t<option>5</option>\r\n");
      out.write("\t\t\t<option>6</option>\r\n");
      out.write("\t\t\t<option>7</option>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td>安排酒店:</td>\r\n");
      out.write("\t\t\t<td><input name=\"hotel\" type=\"text\" required=\"required\"></input></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t <tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>餐饮预算:</td><td><input type=\"text\" name=\"mealsBudget\" required=\"required\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t <tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td>入住预算:</td><td><input type=\"text\" name=\"liveBudget\" required=\"required\"/></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t<td>其他:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"others\" required=\"required\"/></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t <tr>\r\n");
      out.write("\t\t\t\t<td>接待室处长:</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"directorId\" type=\"text\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>接待人员:</td>\r\n");
      out.write("\t\t\t<td><input name=\"staffId\" type=\"text\" required=\"required\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<tr><td>承办处室:</td>\r\n");
      out.write("\t\t\t<td> \r\n");
      out.write("\t\t\t<select name=\"officeId\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<option>9</option>\r\n");
      out.write("\t\t\t<option>10</option>\r\n");
      out.write("\t\t\t<option>11</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>任务状态: </td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"task_statusId\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<option>1</option>\r\n");
      out.write("\t\t\t<option>2</option>\r\n");
      out.write("\t\t\t<option>3</option>\r\n");
      out.write("\t\t\t<option>4</option>\r\n");
      out.write("\t\t\t<option>5</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" id=\"submit\" value=\"提交\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"button\" id=\"button\" value=\"保存\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"reset\" value=\"重置\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<!-- <td><input type=\"button\" value=\"返回\"></input> -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
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