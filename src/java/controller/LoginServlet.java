/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author bunny
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AccountDAO dal = new AccountDAO();
        Account account = dal.Login(email, password);
        if (account == null) {
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("accountLoginError", "Email or Pasword is incorrect ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            Cookie userCookies = new Cookie("email", email);
            Cookie nameCookies = new Cookie("username", account.getUsername());
            Cookie passwordCookies = new Cookie("password", password);
            Cookie phoneCookies = new Cookie("phone", account.getPhone());
            userCookies.setMaxAge(120);
            nameCookies.setMaxAge(120);
            passwordCookies.setMaxAge(120);
            phoneCookies.setMaxAge(120);
            response.addCookie(userCookies);
            response.addCookie(passwordCookies);
            response.addCookie(phoneCookies);
            response.addCookie(nameCookies);

            if (account.getRole().equals("admin")) {
                response.sendRedirect("http://localhost:8080/Project/admin");
            } else {
                request.setAttribute("UserLogin", account.getUsername());
                request.setAttribute("Role", account.getRole());
                response.sendRedirect("http://localhost:8080/Project/home");
            }
            processRequest(request, response);
        }
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
