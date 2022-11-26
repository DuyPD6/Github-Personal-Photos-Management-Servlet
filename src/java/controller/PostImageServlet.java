/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.ImageDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Account;
import model.Image;

/**
 *
 * @author bunny
 */
@MultipartConfig(maxFileSize = 26177215)
public class PostImageServlet extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostImageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostImageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("postImage.jsp").forward(request, response);
        }
        AccountDAO dao = new AccountDAO();
        Account account = dao.Login(email, passwordCookie);
        if (account == null) {
            response.sendRedirect("denied.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        String email = "";
        String passwordCookie = "";
        int check = 0;
        InputStream inputStream = null;
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
            }
        }
        AccountDAO dao = new AccountDAO();
        Account account = dao.Login(email, passwordCookie);
        if (account == null) {
            response.sendRedirect("denied.jsp");
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    String name = request.getParameter("name");
                    String description = request.getParameter("description");
                    String author = account.getUsername();
                    String category = request.getParameter("category");
                    String comment = "";
                    String approved = "1";
                    String uploaddate = dtf.format(now);
                    Part filePart = request.getPart("filename");
                    if (filePart != null) {
                        // prints out some information for debugging
                        System.out.println(filePart.getName());
                        System.out.println(filePart.getSize());
                        System.out.println(filePart.getContentType());

                        //obtains input stream of the upload file
                        //the InputStream will point to a stream that contains
                        //the contents of the file
                        inputStream = filePart.getInputStream();
                        ImageDAO idao = new ImageDAO();
                        idao.postImage(name, description, author, category, comment, approved, inputStream, uploaddate);
                        response.sendRedirect("imagebyuser");
                    }
                }
            }
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
