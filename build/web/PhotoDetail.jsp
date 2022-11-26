<%-- 
    Document   : PhotoDetail
    Created on : Jul 13, 2021, 2:13:20 PM
    Author     : bunny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="data:image/jpg;base64,${image.base64Image}"
             width= "1920 px" height="auto"/>       
    </body>
</html>
