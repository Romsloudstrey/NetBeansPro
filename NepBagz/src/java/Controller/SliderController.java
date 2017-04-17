/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SliderDao;
import Entity.SliderEntity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author myhp
 */
@WebServlet({"/addslider","/displayslider","/deleteslider/","/editslider/","/editsliderinformation"})
public class SliderController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath=request.getContextPath();
        if(request.getRequestURI().equals(contextPath+"/displayslider")){
            //creating arraylist for SliderEntity class and storing values obtained in it
            //here SliderDao.getSliderDetails() returns values in arraylist
            ArrayList<SliderEntity> se = SliderDao.getSliderDetails();
            //the following code extracts data to its frame
            RequestDispatcher rd= request.getRequestDispatcher("/DisplaySlider.jsp");
            //storing values obtained in a bag page
            request.setAttribute("slider", se);
            //forwarding the values obtained in intended page
            rd.forward(request, response);
        }else if(request.getRequestURI().equals(contextPath+"/deleteslider/")){
            //retrieving delete id
            int sid=Integer.parseInt(request.getParameter("delid"));
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                //calling methods of SliderDao for deleting the selected page (ie. obtained page id)
                SliderDao.deleteSlider(sid);
                //redirection user to intended page after successful execution of above line of code
                response.sendRedirect(contextPath+"/displayslider");
            }
            
            else {
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect(contextPath+"/displayslider");
            }
            
        } else if(request.getRequestURI().equals(contextPath+"/editslider/")){
                //getting values for delete id for deletion. Here delete id is actually page id
            int edit_id = Integer.parseInt(request.getParameter("eid"));
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<SliderEntity> se = SliderDao.getSpecificSliderDetails(edit_id);
            //the following code extracts data to its frame
            RequestDispatcher rd=request.getRequestDispatcher("/EditSliderInformation.jsp");
            //storing values obtained in a bag pagedetails
            request.setAttribute("sliderdetails", se);
            //forwarding the values obtained in intended page
            rd.forward(request, response);
            }else if (request.getRequestURI().equals(contextPath+"/searchslider")) {
            //getting values for search
            String slidername = request.getParameter("text");
            SliderEntity se = new SliderEntity();
            se.setSlidername(slidername);
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<SliderEntity> srchvalue = SliderDao.searchSlider(se);
            Gson gson = new Gson();
            
            JsonElement element = gson.toJsonTree(srchvalue, new TypeToken<List<SliderEntity>>() {}.getType());
            
            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
        } 
        else{
            response.sendRedirect("ErrorPage.jsp");
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String contextPath=request.getContextPath();
        if(request.getRequestURI().equals(contextPath+"/addslider")){
            String path=request.getServletContext().getRealPath("img");
            MultipartRequest mr= new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            //retrieving values from form
            System.out.println(path);
            String slidername=mr.getParameter("slidername");
              String location=mr.getParameter("location");

            String imageName=mr.getFilesystemName("imagename");
            //storing values obtained in entity
            SliderEntity se=new SliderEntity(0,slidername,location,imageName);
            //calling method of SliderDao to save values into database
            SliderDao.insertSliderDetails(se);
            response.sendRedirect(contextPath+"/AddSlider.jsp");
            
            
            
        }else if (request.getRequestURI().equals(contextPath+"/editsliderinformation")){
            String path=request.getServletContext().getRealPath("img");
            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            String imgname = mr.getFilesystemName("imagename");
            //retrieving page id obtained through form to update page information
            int sid=Integer.parseInt(mr.getParameter("sid"));
            //retrieving values sent from form
            String slidername = mr.getParameter("slidername");
            String location = mr.getParameter("location");
            //storing values obtained in variables of SliderEntity class
            SliderEntity pe = new SliderEntity(sid, slidername, location,imgname);
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                //calling methods of SliderDao class to update values obtained from form
            
            SliderDao.updateSliderInformation(pe);
            //the following line redirects user to mentioned page after successful execution of above line
            response.sendRedirect(contextPath+"/displayslider");
            } else {
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect(contextPath+"/displayslider");
            }
        }else{
            response.sendRedirect("ErrorPage.jsp");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
