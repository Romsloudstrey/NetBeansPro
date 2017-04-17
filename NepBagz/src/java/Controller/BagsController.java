/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BagsDao;
import Entity.BagsEntity;
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

@WebServlet({"/savebags","/displaybags","/deletebags/","/editbags/","/editbagsinformation","/searchbags"})
public class BagsController extends HttpServlet {

  
  


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String contextPath=request.getContextPath();
        
        if (request.getRequestURI().equals(contextPath+"/displaybags")) {
           
            ArrayList<BagsEntity> ble = BagsDao.getBagsDetails();
          

            RequestDispatcher rd = request.getRequestDispatcher("/DisplayBags.jsp");

            request.setAttribute("bag", ble);
            //forwarding the values obtained in intended page
            rd.forward(request, response);
        }//checking the value for action
        else if (request.getRequestURI().equals(contextPath+"/deletebags/")) {
            //getting values for delete id for deletion. Here delete id is actually page id
            int delete_id = Integer.parseInt(request.getParameter("delid"));
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
          int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
           
            if (x == 0) {
                //calling methods of PageDao for deleting the selected page (ie. obtained page id)
                BagsDao.deleteBags(delete_id);
                //redirection user to intended page after successful execution of above line of code
                response.sendRedirect(contextPath+"/displaybags");
                
            } else {
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect(contextPath+"/displaybags");
            }
        } else if (request.getRequestURI().equals(contextPath+"/editbags/")) {
            //getting values for delete id for deletion. Here delete id is actually page id
            int BagId = Integer.parseInt(request.getParameter("eid"));
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<BagsEntity> ble = BagsDao.getSpecificBagsDetails(BagId);
            //the following code extracts data to its frame
            RequestDispatcher rd = request.getRequestDispatcher("/EditBags.jsp");
            //storing values obtained in a bag pagedetails
            request.setAttribute("EditBagsDetail", ble);
            //forwarding the values obtained in intended page
            rd.forward(request, response);
        } else if (request.getRequestURI().equals(contextPath+"/searchbags")) {
            //getting values for search
            String bagname = request.getParameter("text");
            BagsEntity be = new BagsEntity();
            be.setBagName(bagname);
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<BagsEntity> srchvalue = BagsDao.searchBags(be);
            Gson gson = new Gson();
            
            JsonElement element = gson.toJsonTree(srchvalue, new TypeToken<List<BagsEntity>>() {}.getType());
            
            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
        } 
        
        
        else {
            response.sendRedirect("ErrorPage.jsp");
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
         if(request.getRequestURI().equals(contextPath+"/savebags")){
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            String path = request.getServletContext().getRealPath("img");
            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
          String Portfolio_Name = mr.getParameter("Portfolio_Name");
            String Portfolio_Description = mr.getParameter("Portfolio_Description");
            String BagName = mr.getParameter("BagName");
            String ImageName = mr.getFilesystemName("ImageName");
            int BagPrice = Integer.parseInt(mr.getParameter("BagPrice"));
            String BagBrand = mr.getParameter("BagBrand");
          String shipping = mr.getParameter("Shipping");

            String [] colors = mr.getParameterValues("Colors");
            String color="";
            for(int i=0;i<colors.length;i++){
                color=colors[i]+","+color;
            }
            System.out.println(color);
//           List list =  Arrays.asList(colors);
          String sellername=mr.getParameter("sellername");
//            int sellernum=mr.getParameter("sellernum");
               int sellernum  =   Integer.parseInt(mr.getParameter("sellernum"));
            String selleremail=mr.getParameter("selleremail");
            String selleraddress=mr.getParameter("selleraddress");
            BagsEntity be = new BagsEntity(0,Portfolio_Name,Portfolio_Description, BagName, ImageName, date, BagPrice, BagBrand,color,shipping,sellername,selleremail,sellernum,selleraddress);
//           BagsEntity e = new BagsEntity();
//           e.setBagId(BagPrice);
//           e.setPortfolio_Name(Portfolio_Name);
//           e.setPortfolio_Description(Portfolio_Description);
//           e.setBagName(BagName);
//           e.setImageName(ImageName);
//           e.setBagPrice(BagPrice);
//           e.setBagBrand(BagBrand);
//           e.setShipping(shipping);
//           e.setColor(colors);
//           e.setSellername(sellername);
//           e.setSellernum(sellernum);
//           e.setSelleremail(selleremail);
//           e.setSelleraddress(selleraddress);
            BagsDao.insertBagsDetails(be);
            response.sendRedirect("/AddBags.jsp");
            

        } else if (request.getRequestURI().equals(contextPath+"/editbagsinformation")) {

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            String path = request.getServletContext().getRealPath("img");
            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            //retrieving page id obtained through url to update page information
            int BagId = Integer.parseInt(mr.getParameter("bagId"));
            //retrieving values sent from form
         
            String Portfolio_Name = mr.getParameter("Portfolio_Name");
            String Portfolio_Description = mr.getParameter("Portfolio_Description");
            String BagName = mr.getParameter("BagName");

            String ImageName = mr.getFilesystemName("ImageName");
               String previous=mr.getParameter("previous");
          

            int BagPrice = Integer.parseInt(mr.getParameter("BagPrice"));

            String BagBrand = mr.getParameter("BagBrand");
            String shipping = mr.getParameter("Shipping");

            String [] colors = mr.getParameterValues("Colors");
            String color="";
            for(int i=0;i<colors.length;i++){
                color=colors[i]+","+color;
            }
            System.out.println(color);
            String sellername=mr.getParameter("sellername");
               int sellernum  =   Integer.parseInt(mr.getParameter("sellernum"));
            String selleremail=mr.getParameter("selleremail");
            String selleraddress=mr.getParameter("selleraddress");
             BagsEntity pe = null;
             if(ImageName==null){
                            pe = new BagsEntity(BagId,Portfolio_Name,Portfolio_Description, BagName, previous, date, BagPrice, BagBrand,shipping,color,sellername,selleremail,sellernum,selleraddress);

               }
             else{
                                       pe=new BagsEntity(BagId,Portfolio_Name,Portfolio_Description, BagName, ImageName, date, BagPrice, BagBrand,shipping,color,sellername,selleremail,sellernum,selleraddress);

        }

            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)

            if (x == 0) {
                //calling methods of PageDao class to update values obtained from form

                BagsDao.updateBagInformation(pe);
                //the following line redirects user to mentioned page after successful execution of above line

                response.sendRedirect(contextPath+"/displaybags");

            }
        } 
        
        
        
        else {
            //redirection user to intended page when user cancel deletion process
            response.sendRedirect(contextPath+"/displaybags");

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
