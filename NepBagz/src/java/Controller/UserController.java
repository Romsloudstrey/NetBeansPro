/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Entity.UserEntity;
import Utils.EncryptPassword;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet({"/adduser/","/displayusers","/deleteuser/","/edituser/","/edituserinformation","/register"})
public class UserController extends HttpServlet {

   
   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //getting message sttached in url
String contextPath=request.getContextPath();

        //checking the value for action
        if (request.getRequestURI().equals(contextPath+"/displayusers")) {
             //here PageDao.getPageDetails() returns values in arraylist
        ArrayList<UserEntity> ue = UserDao.getUserDetails();
        //the following code extracts data to its frame
        RequestDispatcher rd = request.getRequestDispatcher("/DisplayUsers.jsp");
        //storing values obtained in a bag page
        request.setAttribute("user", ue);

        //forwarding the values obtained in intended page
        rd.forward(request, response);
        }//checking the value for action
        else if (request.getRequestURI().equals(contextPath+"/deleteuser/")) {
            //getting values for delete id for deletion. Here delete id is actually page id
            int delete_id = Integer.parseInt(request.getParameter("delid"));
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                //calling methods of PageDao for deleting the selected page (ie. obtained page id)
                UserDao.deleteUser(delete_id);
            } else {
            }
        }
        else if(request.getRequestURI().equals(contextPath+"/register")){
             RequestDispatcher rd = request.getRequestDispatcher("/RegisterUser.jsp");
         
            rd.forward(request, response);
        }
        else if (request.getRequestURI().equals(contextPath+"/edituser/")) {
            //getting values for delete id for deletion. Here delete id is actually page id
            int edit_id = Integer.parseInt(request.getParameter("eid"));
            //retrieving the page details for obtained edit id (here edit id indicates page id)
            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
            ArrayList<UserEntity> ue = UserDao.getSpecificUserDetails(edit_id);
            //the following code extracts data to its frame
            RequestDispatcher rd = request.getRequestDispatcher("/EditUserInformation.jsp");
            //storing values obtained in a bag pagedetails
            request.setAttribute("userdetails", ue);
            //forwarding the values obtained in intended page
            rd.forward(request, response);
//        } else if (action.equals("search")) {
//            //getting values for search
//            String username = request.getParameter("text");
//            UserEntity ue = new UserEntity();
//            ue.setUsername(username);
//            //retrieving the page details for obtained edit id (here edit id indicates page id)
//            //thus retrieved value is stored in arraylist of PageEntity class as PageDao.getSpecificPageDetails(edit_id) returns arraylist
//            ArrayList<UserEntity> srchvalue = UserDao.searchUser(ue);
//            Gson gson = new Gson();
//
//            JsonElement element = gson.toJsonTree(srchvalue, new TypeToken<List<UserEntity>>() {
//            }.getType());
//            com.google.gson.JsonArray jsonArray = element.getAsJsonArray();
//            response.setContentType("application/json");
//            response.getWriter().print(jsonArray);
//        } else {
            response.sendRedirect("ErrorPage.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int count = 0;
        //getting message sttached in url
String contextPath=request.getContextPath();
        //checking the value for action
        if (request.getRequestURI().equals("/adduser/")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confpassword = request.getParameter("confpassword");
            String encpassword = EncryptPassword.encrypt(password);
            System.out.println(encpassword);
            int r=Integer.parseInt(request.getParameter("r"));
            String role = "user";
            //storing values obtained in variables of PageEntity class
            UserEntity ue = new UserEntity(0, username, encpassword, role);
            try {
                count = UserDao.checkUsername(ue);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (count < 1) {
                if (password.equals(confpassword)) {
                    //calling methods of PageDao class to insert values obtained from form
                    UserDao.insertUserDetails(ue);
                    if(r==1){
                        response.sendRedirect(contextPath+"/AddUsers.jsp");
                    }else{
                        response.sendRedirect(contextPath+"/LoginPage.jsp");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Password do not matched");
                    if(r==1){
                        response.sendRedirect(contextPath+"/AddUsers.jsp");
                    }else{
                        response.sendRedirect(contextPath+"/RegisterUser.jsp");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username already exists");
                //the following line redirects user to mentioned page after successful execution of above line
                if(r==1){
                        response.sendRedirect(contextPath+"/AddUsers.jsp");
                    }else{
                        response.sendRedirect(contextPath+"/RegisterUser.jsp");
                    }
            }
        } else if (request.getRequestURI().equals(contextPath+"/edituserinformation")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            int lid = Integer.parseInt(request.getParameter("lid"));
            //storing values obtained in variables of PageEntity class
            UserEntity ue = new UserEntity(lid, username, password, role);
            //asking to make sure that the user wants to delete the selected page
            //the values for the selected options will be obtained in integer and is stored in integer x (for following case)
            int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);
            //ok option has value of 0(zero) and cancel option has value of 1(one)
            if (x == 0) {
                try {
                    count = UserDao.checkUsername(ue);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (count < 2) {
                    //calling methods of PageDao class to update values obtained from form
                    UserDao.updateUserInformation(ue);
                    //the following line redirects user to mentioned page after successful execution of above line
                    response.sendRedirect(contextPath+"/displayusers");
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exixts");
                    response.sendRedirect(contextPath+"/displayusers");
                }
            } else {
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect(contextPath+"/displayusers");
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
