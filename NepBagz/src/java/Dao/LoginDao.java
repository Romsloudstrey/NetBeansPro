/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.LoginEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author USER
 */
@WebServlet(name = "LoginDao", urlPatterns = {"/LoginDao"})
public class LoginDao extends HttpServlet {

     public static boolean check(LoginEntity le) {
        String sql="SELECT * FROM login WHERE username='" + le.getUsername()+ "' AND password='" + le.getPassword() + "';";
         System.out.println(sql);
         boolean act=false;
         Statement stmt=DbConnection.DBConnection.connection();
        try {
            ResultSet rs=stmt.executeQuery(sql);
            System.out.println("inside execute");
            while(rs.next()){
                act=true;
            }
            
             
           }
         catch (Exception e) {
             
             
             
        }
     
     return act;       

    }
             
        
         
//             if (rs.equals("'+username+'")||(rs.equals("'+password+'"))){
//                System.out.println("You r successfully logged in");  
//                 session.setAttribute("session","TRUE"); 
//             }
//             else{
//               System.out.println("You r not logged in");  
//                 session.setAttribute("session","FALSE"); 
//
//             }
   
    }
   
