<%-- 
    Document   : postImage
    Created on : Jul 1, 2021, 11:02:56 PM
    Author     : bunny
--%>
<%@page import="dao.ImageDAO"%>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAO"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
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
        %>
        <form action="postimageservlet" method="post" enctype="multipart/form-data">
            <input type="file" name="filename">
            <input type="text" name="name"> Name of image
            <br>
            <input type="text" name="description" >description
            <br>
            <input type="text" name="category" >category 
            <br>
            <input type="submit">
        </form>
        <%} else {
                out.println("You must login to post photo");
                out.println("<a class=\"navbar-brand\" href=\"home\">Go to home page</a>");
            }
        %>     
    </body>
</html>
