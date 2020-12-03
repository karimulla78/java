/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.EJBException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
public class LoginServlet extends HttpServlet {
 
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
            String username =request.getParameter("name");
            ServletConfig config = getServletConfig();
            String firstname = config.getInitParameter("firstname");
            String lastname = config.getInitParameter("lastname");
            ServletContext context = getServletContext();
            Enumeration<String> e=context.getInitParameterNames();
            String str="";
            
            Object age =request.getAttribute("age");
            String country =(String)request.getAttribute("country");
            
             HttpSession session = request.getSession();
             System.out.println("----------username----"+ username);  
             System.out.println("----------ssn is----"+session.getAttribute("ssn"));  
          //  String str2=sessionBean.businessMethod(str1);
        /*    while(e.hasMoreElements()){
                str=e.nextElement();
                out.println("<br>"+context.getInitParameter(str));
            }*/
          //response.sendRedirect("http://www.google.com");
          // response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
           
          
            
            session.setAttribute("token", "123");
            session.setAttribute("username",username );
            request.setAttribute("noOfRecords", "20");
        //    response.sendRedirect(request.getContextPath()+"/result.jsp");
          //  RequestDispatcher rd =request.getRequestDispatcher("/result.jsp");
         //   rd.forward(request, response);
            
          ///  Cookie myCookie = new Cookie("studentname",username);
           // response.addCookie(myCookie);
           // RequestDispatcher rd =request.getRequestDispatcher("/EmployeeServlet");
            //rd.forward(request, response);
         /*   if(username.equals("")){
                System.out.println("----------inside username----");
             //RequestDispatcher rd =request.getRequestDispatcher("/EmployeeServlet");
               // rd.forward(request, response);
            }else{*/
           
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='EmployeeServlet'>");
            out.println("<input type='hidden' name='confidential' value='true'>");
            out.println("<input type='submit' value='submit'>");
            out.println("</form>");
           //  out.println("<h1>Welcome " + username + "  to Servlet Programming</h1><br>");
            out.println("<h1>Welcome " + firstname + lastname+"  to Servlet Programming</h1>");
            out.println("<h1>your age is " + age.toString() +" your country is "+country+"  to Servlet Programming</h1>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1><a href='LogoutServlet'>logout</a></h1>");
            out.println("</body>");
            out.println("</html>");
           // }
           
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
         System.out.println("welcome to login Servlet");
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
