/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AboutDao;
import Entity.AboutEntity;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author prjro
 */
@WebServlet({"/saveabout","/displayabout","/editabout/","/editaboutdetails","/deleteabout/"})
public class AboutController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath=request.getContextPath();
       if(request.getRequestURI().equals(contextPath+"/displayabout")){
            ArrayList<AboutEntity> abe=AboutDao.getAboutDetails();
            for(AboutEntity ae : abe){
                System.out.println(ae.getAbout_description());
            }
            RequestDispatcher rd=request.getRequestDispatcher("/DisplayAbout.jsp");
            request.setAttribute("about", abe);
           rd.forward(request, response);
   }else if(request.getRequestURI().equals(contextPath+"/deleteabout/")){
                int aid=Integer.parseInt(request.getParameter("delid"));
                System.out.println(aid);
                    AboutDao.deleteAboutDetails(aid);
                                    response.sendRedirect(contextPath+"/displayabout");

                        
            }
 
                else if(request.getRequestURI().equals(contextPath+"/editabout/")){
                //getting values for delete id for deletion. Here delete id is actually page id
            int edit_id = Integer.parseInt(request.getParameter("eid"));
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<AboutEntity> se = AboutDao.getSpecificAboutDetails(edit_id);
            //the following code extracts data to its frame
            RequestDispatcher rd=request.getRequestDispatcher("/EditAboutInformation.jsp");
            //storing values obtained in a bag pagedetails
            request.setAttribute("aboutdetails", se);
            //forwarding the values obtained in intended page
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
        if(request.getRequestURI().equals(contextPath+"/saveabout")){
            String path = request.getServletContext().getRealPath("img");
            MultipartRequest mr=new MultipartRequest(request,path,50000000,new DefaultFileRenamePolicy());
            String services_image=mr.getFilesystemName("Services_Image");
            String services_title=mr.getParameter("Services_Title");
            String services_description=mr.getParameter("Services_Description");
             String testimonial_description=mr.getParameter("Testimonial_Description");
            String testimonial_author_name=mr.getParameter("Testimonial_author_name");
            String about_header=mr.getParameter("About_header");
            String about_description=mr.getParameter("About_description");

            AboutEntity abe= new AboutEntity(0,services_image,services_title,services_description,testimonial_description,testimonial_author_name,about_header,about_description);
            AboutDao.insertAboutDetails(abe);
            response.sendRedirect(contextPath+"/AddAbout.jsp");
           
        }
        else if(request.getRequestURI().equals(contextPath+"/editaboutdetails")){
             String path = request.getServletContext().getRealPath("img");
            MultipartRequest mr=new MultipartRequest(request,path,50000000,new DefaultFileRenamePolicy());
            int uaid=Integer.parseInt(mr.getParameter("abe"));
            String uservices_image=mr.getFilesystemName("Services_Image");
            String uservices_title=mr.getParameter("Services_Title");
            String uservices_description=mr.getParameter("Services_Description");
             String utestimonial_description=mr.getParameter("Testimonial_Description");
            String utestimonial_author_name=mr.getParameter("Testimonial_author_name");
            String uabout_header=mr.getParameter("About_header");
            String uabout_description=mr.getParameter("About_description");
                        AboutEntity abe= new AboutEntity(uaid,uservices_image,uservices_title,uservices_description,utestimonial_description,utestimonial_author_name,uabout_header,uabout_description);

int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                //calling methods of SliderDao class to update values obtained from form
            
            AboutDao.updateAboutInformation(abe);
            //the following line redirects user to mentioned page after successful execution of above line
            response.sendRedirect(contextPath+"/displayabout");
            } else {
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect(contextPath+"/displayabout");
            }
        }else{
            response.sendRedirect("ErrorPage.jsp");
        }
        
        
        
        }
       
    
   

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
