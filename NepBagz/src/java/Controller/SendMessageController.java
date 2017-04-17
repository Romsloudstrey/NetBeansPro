/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MessageDao;
import Entity.MessageEntity;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/displaycontactmessage","/sendmessage"})
public class SendMessageController extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String contextPath=request.getContextPath();
        if(request.getRequestURI().equals(contextPath+"/displaycontactmessage")){
            ArrayList < MessageEntity> me =MessageDao.displayMessage();
            RequestDispatcher rd= request.getRequestDispatcher("ContactUsDetailsForAdmin.jsp");
            
            request.setAttribute("msg", me);
           
            rd.forward(request, response);
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
           String contextPath=request.getContextPath();
           if(request.getRequestURI().equals("/sendmessage")){
            String Status="unread";
           
         String Name=request.getParameter("name");
                   String Email=request.getParameter("email");

          String Subject=request.getParameter("subject");
         String Message=request.getParameter("message");
         MessageEntity me=new MessageEntity(0,Status,Name,Email,Subject,Message);
         MessageDao.insertMessageDetails(me);
         response.sendRedirect("IndexController");
          
         

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