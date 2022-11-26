<%-- 
    Document   : ShowYourPhoto
    Created on : Jul 10, 2021, 2:51:12 PM
    Author     : bunny
--%>

<%@page import="model.Image"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <section>
            <nav class="navbar navbar-expand-sm navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="home">Go to home page</a>
                    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavId">

                        <!-- <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form> -->
                        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Admin </a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="./logout">Log Out</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </section>

        <section style="padding-top: 120px">
            <div class="container">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Name Image</th>
                            <th scope="col">Image</th>
                            <th scope="col">Description</th>
                            <th scope="col">Category</th>
                            <th scope="col">Author</th>
                            <th scope="col">Comment</th>
                            <th scope="col">Upload Date</th>
                            <th scope="col">Approved</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            ArrayList<Image> images = (ArrayList<Image>) request.getAttribute("images");

                        %> 


                        <% for (Image s : images) {
                        %>
                        <tr>
                            <th scope="row"><%=s.getName()%></th>
                            <td><img src="data:image/jpg;base64,<%=s.getBase64Image()%>" width="500"></td>
                            <td><%=s.getDescription()%></td>
                            <td><%=s.getCategory()%></td>
                            <td><%=s.getAuthor()%></td>
                            <td><%=s.getComment()%></td>
                            <td><%=s.getUploaddate()%></td>
                            <td><a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete ?')"  href="deleteimage?name=<%=s.getName()%>">Delete</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>

        </section>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

</html>