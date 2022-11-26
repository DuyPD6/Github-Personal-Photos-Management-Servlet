package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Account;
import dao.AccountDAO;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Catalog-Z Bootstrap 5.0 HTML Template</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fontawesome/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/templatemo-style.css\">\n");
      out.write("        <!--\n");
      out.write("            \n");
      out.write("        TemplateMo 556 Catalog-Z\n");
      out.write("        \n");
      out.write("        https://templatemo.com/tm-556-catalog-z\n");
      out.write("        \n");
      out.write("        -->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Cookie cookie = null;
            Cookie[] cookies = null;
            String email = "";
            String password = "";
            String name = (String) request.getAttribute("UserLogin");
            // Get an array of Cookies associated with this domain
            cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("email")) {
                        email = cookie.getValue();
                    }
                    if (cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }

                }
            }
            AccountDAO dal = new AccountDAO();
            Account account = dal.Login(email, password);

            if (account != null) {
                name = account.getUsername();
            }

        
      out.write("  \n");
      out.write("        <!-- Page Loader -->\n");
      out.write("        <div id=\"loader-wrapper\">\n");
      out.write("            <div id=\"loader\"></div>\n");
      out.write("\n");
      out.write("            <div class=\"loader-section section-left\"></div>\n");
      out.write("            <div class=\"loader-section section-right\"></div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"http://localhost:8080/Project/home\">\n");
      out.write("                    <i class=\"fas fa-film mr-2\"></i>\n");
      out.write("                    Pham Duc Duy\n");
      out.write("                </a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <i class=\"fas fa-bars\"></i>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav ml-auto mb-2 mb-lg-0\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link nav-link-1 active\" aria-current=\"page\" href=\"/Project/home\">Home Page</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
if (name != null) {
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link nav-link-2\" href=\"imagebyuser\">Manage Your Photos</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link nav-link-3\" href=\"postimageservlet\">Post image</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link nav-link-3\" href=\"logout\">Log out</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                        } else {
      out.write("      \n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link nav-link-2\" href=\"Login.jsp\">Login</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link nav-link-4\" href=\"https://www.facebook.com/BuNnYjUmB/\">Contact</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"tm-hero d-flex justify-content-center align-items-center\" data-parallax=\"scroll\" data-image-src=\"img/hero.jpg\">\n");
      out.write("            <form class=\"d-flex tm-search-form\" action=\"searchimages\" method=\"post\">\n");
      out.write("                <input class=\"form-control \" type=\"text\" name=\"keyword\" placeholder=\"Input anything you want to search\" aria-label=\"Search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${keyword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <button class=\"btn btn-outline-success tm-search-btn\" type=\"submit\">\n");
      out.write("                    <i class=\"fas fa-search\"></i>\n");
      out.write("                </button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid tm-container-content tm-mt-60\">\n");
      out.write("            <div class=\"row mb-4\">\n");
      out.write("                <h2 class=\"col-6 tm-text-primary\">\n");
      out.write("                    Latest Photos\n");
      out.write("                </h2>\n");
      out.write("                <div class=\"col-6 d-flex justify-content-end align-items-center\">\n");
      out.write("                    <form action=\"\" class=\"tm-text-primary\">\n");
      out.write("                        Page <input type=\"text\" value=\"1\" size=\"1\" class=\"tm-input-paging tm-text-primary\"> of 1\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row tm-mb-90 tm-gallery\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div> <!-- row -->\n");
      out.write("            <div class=\"row tm-mb-90\">\n");
      out.write("                <div class=\"col-12 d-flex justify-content-between align-items-center tm-paging-col\">\n");
      out.write("                    <a href=\"javascript:void(0);\" class=\"btn btn-primary tm-btn-prev mb-2 disabled\">Previous</a>\n");
      out.write("                    <div class=\"tm-paging d-flex\">\n");
      out.write("                        <a href=\"javascript:void(0);\" class=\"active tm-paging-link\">1</a>\n");
      out.write("                        <a href=\"javascript:void(0);\" class=\"tm-paging-link\">2</a>\n");
      out.write("                        <a href=\"javascript:void(0);\" class=\"tm-paging-link\">3</a>\n");
      out.write("                        <a href=\"javascript:void(0);\" class=\"tm-paging-link\">4</a>\n");
      out.write("                    </div>\n");
      out.write("                    <a href=\"javascript:void(0);\" class=\"btn btn-primary tm-btn-next\">Next Page</a>\n");
      out.write("                </div>            \n");
      out.write("            </div>\n");
      out.write("        </div> <!-- container-fluid, tm-container-content -->\n");
      out.write("\n");
      out.write("        <footer class=\"tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer\">\n");
      out.write("            <div class=\"container-fluid tm-container-small\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-6 col-md-12 col-12 px-5 mb-5\">\n");
      out.write("                        <h3 class=\"tm-text-primary mb-4 tm-footer-title\">About Catalog-Z</h3>\n");
      out.write("                        <p>Catalog-Z is free <a rel=\"sponsored\" href=\"https://v5.getbootstrap.com/\">Bootstrap 5</a> Alpha 2 HTML Template for video and photo websites. You can freely use this TemplateMo layout for a front-end integration with any kind of CMS website.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5\">\n");
      out.write("                        <h3 class=\"tm-text-primary mb-4 tm-footer-title\">Our Links</h3>\n");
      out.write("                        <ul class=\"tm-footer-links pl-0\">\n");
      out.write("                            <li><a href=\"#\">Advertise</a></li>\n");
      out.write("                            <li><a href=\"#\">Support</a></li>\n");
      out.write("                            <li><a href=\"#\">Our Company</a></li>\n");
      out.write("                            <li><a href=\"#\">Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5\">\n");
      out.write("                        <ul class=\"tm-social-links d-flex justify-content-end pl-0 mb-5\">\n");
      out.write("                            <li class=\"mb-2\"><a href=\"https://facebook.com/bunnyjumb\"><i class=\"fab fa-facebook\"></i></a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"#\" class=\"tm-text-gray text-right d-block mb-2\">Terms of Use</a>\n");
      out.write("                        <a href=\"#\" class=\"tm-text-gray text-right d-block\">Privacy Policy</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-8 col-md-7 col-12 px-5 mb-3\">\n");
      out.write("                        Copyright 2020 Catalog-Z Company. All rights reserved.\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-5 col-12 px-5 text-right\">\n");
      out.write("                        Designed by <a href=\"https://templatemo.com\" class=\"tm-text-gray\" rel=\"sponsored\" target=\"_parent\">TemplateMo</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <script src=\"js/plugins.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(window).on(\"load\", function () {\n");
      out.write("                $('body').addClass('loaded');\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("i");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${images}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <div class=\"col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5\">\n");
          out.write("                        <figure class=\"effect-ming tm-video-item\">\n");
          out.write("                            <img src=\"data:image/jpg;base64,");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.base64Image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"Image\" class=\"img-fluid\">\n");
          out.write("                            <figcaption class=\"d-flex align-items-center justify-content-center\">\n");
          out.write("                                <h2>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.category}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h2>\n");
          out.write("                                <a href=\"photoDetail?name=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">View more</a>\n");
          out.write("                            </figcaption>                    \n");
          out.write("                        </figure>\n");
          out.write("                        <div class=\"d-flex justify-content-between tm-text-gray\">\n");
          out.write("                            <span class=\"tm-text-gray-light\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.author}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                        </div>\n");
          out.write("                    </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
