/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ContactDao;
import Entity.ContactEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * @author prjro
 */
@WebServlet({"/savecontact","/displaycontact","/deletecontact/","/editcontact/","/editcontactdetails"})
public class ContactController extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String contextPath=request.getContextPath();
        if(request.getRequestURI().equals(contextPath+"/displaycontact")){
           
            ArrayList<ContactEntity>cone=ContactDao.displayContact();
            RequestDispatcher rd=request.getRequestDispatcher("/DisplayContact.jsp");
            request.setAttribute("con", cone);
            rd.forward(request, response);
        }
        else if(request.getRequestURI().equals(contextPath+"/deletecontact/")){
            int delid=Integer.parseInt(request.getParameter("delid"));
                            int x=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Options", JOptionPane.OK_CANCEL_OPTION);
if(x==0){
    ContactDao.deleteContact(delid);
                   response.sendRedirect(contextPath+"/displaycontact");

}
else{
                       response.sendRedirect(contextPath+"/displaycontact");

}  
        }
   else if(request.getRequestURI().equals(contextPath+"/editcontact/")){
            int elid=Integer.parseInt(request.getParameter("eid"));
            ArrayList<ContactEntity> cone=ContactDao.editContactDetails(elid);
RequestDispatcher rd=request.getRequestDispatcher("/EditContactDetails.jsp");
            request.setAttribute("conedit", cone);
            rd.forward(request, response);

        }
   else{
       response.sendRedirect("Error.jsp");
   }

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String contextPath=request.getContextPath();
        
        if(request.getRequestURI().equals(contextPath+"/savecontact")){
       String contactUs_title=request.getParameter("ContactUs_title");
              String contact_Description=request.getParameter("Contact_Description");
       String field1_Name=request.getParameter("Field1_Name");
       String field2_Name=request.getParameter("Field2_Name");
       String field3_Name=request.getParameter("Field3_Name");
       String field4_Name=request.getParameter("Field4_Name");
       ContactEntity cone=new ContactEntity(0,contactUs_title,contact_Description,field1_Name,field2_Name,field3_Name,field4_Name);
           ContactDao.insertContactDetails(cone);
           response.sendRedirect(contextPath +"/displaycontact");
   }
   else if(request.getRequestURI().equals(contextPath+"/editcontactdetails")){
                         int ucontact_Id=Integer.parseInt(request.getParameter("Contact_Id"));

                  String ucontactUs_title=request.getParameter("ContactUs_title");
              String ucontact_Description=request.getParameter("Contact_Description");
       String ufield1_Name=request.getParameter("Field1_Name");
       String ufield2_Name=request.getParameter("Field2_Name");
       String ufield3_Name=request.getParameter("Field3_Name");
       String ufield4_Name=request.getParameter("Field4_Name");
       ContactEntity cone=new ContactEntity(ucontact_Id,ucontactUs_title,ucontact_Description,ufield1_Name,ufield2_Name,ufield3_Name,ufield4_Name);
                             int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);

       
       if( x==0){
           ContactDao.contactEditDetails(cone);
            response.sendRedirect(contextPath +"/displaycontact");

        }
else{
                        response.sendRedirect(contextPath +"/displaycontact");

        }
            
        }
            
   else{
                  response.sendRedirect("Error.jsp");

   }

 
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
