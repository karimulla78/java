/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BONDoo7
 */
public class EmployeeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             HttpSession session = request.getSession();
         //    System.out.println("----------ssn is----"+session.getAttribute("ssn"));  
            
          //  String confidential = request.getParameter("confidential");
         
            
          //  String username = (String) request.getSession().getAttribute("username");
         /*   if(username == null || username.equals("")){
                 System.out.println("----------user name is null/empty-----");
                 request.getSession().invalidate();
                 RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
                 rd.forward(request, response);
            }*/
            
      /*      Cookie cookies[] = request.getCookies();
            String studentName = (String)cookies[0].getValue();
            System.out.println("----------studentName----"+studentName);
            if(studentName == null || studentName.equals("")){
                 System.out.println("----------user name is null/empty-----");
                 request.getSession().invalidate();
                 RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
                 rd.forward(request, response);
            }
            
            ServletContext context = getServletContext();
            Enumeration<String> e=context.getInitParameterNames();
            String str="";
            
            while(e.hasMoreElements()){
                str=e.nextElement();
                out.println("<br>"+context.getInitParameter(str));
            }*/
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
        //    if(confidential.equals("true")){
          //        out.println("<h1>Hello hidden value is" + confidential + "</h1>");

           // }
          //  out.println("<h1>Servlet EmployeeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("welcome to Employee Servlet");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
