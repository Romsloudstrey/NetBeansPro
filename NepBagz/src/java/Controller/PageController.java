/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.PageDao;
import Entity.PageEntity;
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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author myhp
 */
@WebServlet({"/savepages","/displaypages","/deletepages/","/editpages/","/editpageinformation","/404"})
public class PageController extends HttpServlet {

 
  

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath=request.getContextPath();
        //getting message sttached in url
      if(request.getRequestURI().equals(contextPath+"/displaypages")){
         ArrayList<PageEntity> pe = PageDao.getPageDetails();
        RequestDispatcher rd = request.getRequestDispatcher("/DisplayPages.jsp");
        request.setAttribute("page", pe);
        rd.forward(request, response);

      } 
        else if (request.getRequestURI().equals(contextPath+"/deletepages/")) {
            //getting values for delete id for deletion. Here delete id is actually page id
            int delete_id = Integer.parseInt(request.getParameter("delid"));
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                //calling methods of PageDao for deleting the selected page (ie. obtained page id)
                PageDao.deletePages(delete_id);
                String message = "Deletion succeeded";
//                request.getSession().setAttribute("msg", message);
                //redirection user to intended page after successful execution of above line of code
                                response.sendRedirect(contextPath+"/displaypages");

            } else {
                String message = "Failed to delete";
//                request.getSession().setAttribute("msg", message);
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect(contextPath+"/displaypages");
            }
        } else if(request.getRequestURI().equals(contextPath+"/editpages/")) {
            //getting values for delete id for deletion. Here delete id is actually page id
            int edit_id = Integer.parseInt(request.getParameter("eid"));
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<PageEntity> pe = PageDao.getSpecificPageDetails(edit_id);
            //the following code extracts data to its frame
            RequestDispatcher rd = request.getRequestDispatcher("/EditPageInformation.jsp");
            //storing values obtained in a bag pagedetails
            request.setAttribute("pagedetails", pe);
            //forwarding the values obtained in intended page
            rd.forward(request, response);
        } else if (request.getRequestURI().equals(contextPath+"/searchpage")) {
            //getting values for search
            String pagename = request.getParameter("text");
            System.out.println(pagename);
            PageEntity pe = new PageEntity();
            pe.setPageName(pagename);
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<PageEntity> srchvalue = PageDao.searchPage(pe);
            Gson gson = new Gson();

            JsonElement element = gson.toJsonTree(srchvalue, new TypeToken<List<PageEntity>>() {
            }.getType());

            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            System.out.println(jsonArray);
            response.getWriter().print(jsonArray);
        }
        else if(request.getRequestURI().equals(contextPath+"/404")){
            RequestDispatcher rd= request.getRequestDispatcher("/ErrorPage.jsp");
            rd.forward(request,response);
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
        //getting message sttached in url
String contextPath=request.getContextPath();
        if (request.getRequestURI().equals(contextPath+"/savepages")) {
            String path = request.getServletContext().getRealPath("img");
            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            String pagename = mr.getParameter("pagename");
            String imgname = mr.getFilesystemName("imagename");
            String pagedescription = mr.getParameter("pagedescription");
            PageEntity pe = new PageEntity(0, pagename, pagedescription, imgname);
           
                PageDao.insertPageDetails(pe);
//                HttpSession session=request.getSession(true);
//                session.setAttribute("ipage", PageDao.getPageDetails());
//              response.sendRedirect(contextPath+"/index");
          
        } else if (request.getRequestURI().equals(contextPath+"/editpageinformation")) {
            //adding images
            String path = request.getServletContext().getRealPath("img");
            //String pathh=request.getServletContext().getRequestDispatcher("images").toString();
            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            String imgname = mr.getFilesystemName("imagename");
            //retrieving page id obtained through url to update page information
            int pid = Integer.parseInt(mr.getParameter("pageId"));
            //retrieving values sent from form
            String pagename = mr.getParameter("pagename");
            String pagedescription = mr.getParameter("pagedescription");
            //storing values obtained in variables of PageEntity class
            PageEntity pe = new PageEntity(pid, pagename, pagedescription, imgname);
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                try {
                    //calling methods of PageDao class to update values obtained from form
                    PageDao.updatePageInformation(pe);
                    String message = "Page information updated successfully";
                    request.getSession().setAttribute("msg", message);
                    //the following line redirects user to mentioned page after successful execution of above line
                    response.sendRedirect(contextPath+"/displaypages");
                } catch (Exception e) {
                    String message = "Failed to update page information";
                    request.getSession().setAttribute("msg", message);
                    //the following line redirects user to mentioned page after successful execution of above line
                    response.sendRedirect(contextPath+"/displaypages");
                }
            } else {
                String message = "User cancelled updating information";
                request.getSession().setAttribute("msg", message);
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect("PageController?action=display");
            }
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