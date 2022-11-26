package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.ImageDAO;
import model.Account;
import dao.AccountDAO;

public final class postImage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Cookie cookie = null;
            Cookie[] cookies = null;
            String email = "";
            String passwordCookie = "";
            String userName = "";
            int check = 0;
            // Get an array of Cookies associated with this domain
            cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("email")) {
                        email = cookie.getValue();
                        check = 1;
                    }
                    if (cookie.getName().equals("password")) {
                        passwordCookie = cookie.getValue();
                    }
                    if (cookie.getName().equals("username")) {
                        userName = cookie.getValue();
                    }
                }

                AccountDAO dao = new AccountDAO();
                Account account = dao.Login(email, passwordCookie);
                if (account == null) {
                    response.sendRedirect("denied.jsp");
                }
        
      out.write("\n");
      out.write("        <form action=\"postimageservlet\" method=\"post\" >\n");
      out.write("            <input type=\"file\" name=\"filename\">\n");
      out.write("            <input type=\"text\" name=\"name\"> Name of image\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"description\" >description\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"category\" >category \n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("        </form>\n");
      out.write("        ");
} else {
                out.println("You must login to post photo");
                out.println("<a class=\"navbar-brand\" href=\"home\">Go to home page</a>");
            }
        
      out.write("     \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
