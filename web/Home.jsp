<%-- 
    Document   : Home
    Created on : Jul 10, 2021, 2:40:50 PM
    Author     : bunny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAO"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Catalog-Z Bootstrap 5.0 HTML Template</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/templatemo-style.css">
        <!--
            
        TemplateMo 556 Catalog-Z
        
        https://templatemo.com/tm-556-catalog-z
        
        -->
    </head>
    <body>
        <%
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

        %>  
        <!-- Page Loader -->
        <div id="loader-wrapper">
            <div id="loader"></div>

            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>

        </div>
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="http://localhost:8080/Project/home">
                    <i class="fas fa-film mr-2"></i>
                    Pham Duc Duy
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link nav-link-1 active" aria-current="page" href="/Project/home">Home Page</a>
                        </li>
                        <%if (name != null) {%>
                        <li class="nav-item">
                            <a class="nav-link nav-link-2" href="imagebyuser">Manage Your Photos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-3" href="postimageservlet">Post image</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-3" href="logout">Log out</a>
                        </li>
                        <%
                        } else {%>      
                        <li class="nav-item">
                            <a class="nav-link nav-link-2" href="Login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav-link-4" href="https://www.facebook.com/BuNnYjUmB/">Contact</a>
                        </li>
                        <%}%>




                    </ul>
                </div>
            </div>
        </nav>

        <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="img/hero.jpg">
            <form class="d-flex tm-search-form" action="searchimages" method="post">
                <input class="form-control " type="text" name="keyword" placeholder="Input anything you want to search" aria-label="Search" value="${keyword}">
                <button class="btn btn-outline-success tm-search-btn" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>

        <div class="container-fluid tm-container-content tm-mt-60">
            <div class="row mb-4">
                <h2 class="col-6 tm-text-primary">
                    Latest Photos
                </h2>
                <div class="col-6 d-flex justify-content-end align-items-center">
                    <form action="" class="tm-text-primary">
                        Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 1
                    </form>
                </div>
            </div>
            <div class="row tm-mb-90 tm-gallery">
                <c:forEach var="i" items="${images}" >
                    <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                        <figure class="effect-ming tm-video-item">
                            <img src="data:image/jpg;base64,${i.base64Image}" alt="Image" class="img-fluid">
                            <figcaption class="d-flex align-items-center justify-content-center">
                                <h2>${i.category}</h2>
                                <a href="photoDetail?name=${i.name}">View more</a>
                            </figcaption>                    
                        </figure>
                        <div class="d-flex justify-content-between tm-text-gray">
                            <span class="tm-text-gray-light">${i.author}</span>
                        </div>
                    </div>
                </c:forEach >
            </div> <!-- row -->
            <div class="row tm-mb-90">
                <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                    <a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                    <div class="tm-paging d-flex">
                        <a href="javascript:void(0);" class="active tm-paging-link">1</a>
                        <a href="javascript:void(0);" class="tm-paging-link">2</a>
                        <a href="javascript:void(0);" class="tm-paging-link">3</a>
                        <a href="javascript:void(0);" class="tm-paging-link">4</a>
                    </div>
                    <a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next Page</a>
                </div>            
            </div>
        </div> <!-- container-fluid, tm-container-content -->

        <footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
            <div class="container-fluid tm-container-small">
                <div class="row">
                    <div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
                        <h3 class="tm-text-primary mb-4 tm-footer-title">About Catalog-Z</h3>
                        <p>Catalog-Z is free <a rel="sponsored" href="https://v5.getbootstrap.com/">Bootstrap 5</a> Alpha 2 HTML Template for video and photo websites. You can freely use this TemplateMo layout for a front-end integration with any kind of CMS website.</p>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                        <h3 class="tm-text-primary mb-4 tm-footer-title">Our Links</h3>
                        <ul class="tm-footer-links pl-0">
                            <li><a href="#">Advertise</a></li>
                            <li><a href="#">Support</a></li>
                            <li><a href="#">Our Company</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                        <ul class="tm-social-links d-flex justify-content-end pl-0 mb-5">
                            <li class="mb-2"><a href="https://facebook.com/bunnyjumb"><i class="fab fa-facebook"></i></a></li>

                        </ul>
                        <a href="#" class="tm-text-gray text-right d-block mb-2">Terms of Use</a>
                        <a href="#" class="tm-text-gray text-right d-block">Privacy Policy</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8 col-md-7 col-12 px-5 mb-3">
                        Copyright 2020 Catalog-Z Company. All rights reserved.
                    </div>
                    <div class="col-lg-4 col-md-5 col-12 px-5 text-right">
                        Designed by <a href="https://templatemo.com" class="tm-text-gray" rel="sponsored" target="_parent">TemplateMo</a>
                    </div>
                </div>
            </div>
        </footer>

        <script src="js/plugins.js"></script>
        <script>
            $(window).on("load", function () {
                $('body').addClass('loaded');
            });
        </script>
    </body>
</html>