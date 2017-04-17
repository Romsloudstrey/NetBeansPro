/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.AboutEntity;
import Entity.SliderEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(name = "AboutDao", urlPatterns = {"/AboutDao"})
public class AboutDao  {

    public static void insertAboutDetails(AboutEntity abe) {
        String sql="INSERT INTO `about`(`services_image`,`services_title`,`services_description`,`testimonial_description`,`testimonial_author_name`,`about_header`,`about_description`)VALUES('"+abe.getServices_image()+"','"+abe.getServices_title()+"','"+abe.getServices_description()+"','"+abe.getTestimonial_description()+"','"+abe.getTestimonial_author_name()+"','"+abe.getAbout_header()+"','"+abe.getAbout_description()+"')";
        System.out.println(sql);
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            stmt.executeUpdate(sql);
                          JOptionPane.showMessageDialog(null, "About Details Insertion success");

            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "About Details Insertion Failed");

        }
    
    }
    public static ArrayList<AboutEntity> getAboutDetails() {
        String sql="SELECT * FROM `about`";
        System.out.println(sql);

       Statement stmt=DbConnection.DBConnection.connection();
        ArrayList<AboutEntity> ae=new ArrayList();        
        try {

    ResultSet rs=stmt.executeQuery(sql);            
    while(rs.next()){
               AboutEntity ade=new AboutEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
               ae.add(ade);
       
           }
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Retrieving of about information failed");

       }
       return ae;
  }

    public static void deleteAboutDetails(int aid) {
           String sql="DELETE FROM `about` WHERE abid="+aid;
           Statement stmt=DbConnection.DBConnection.connection();
           try{
               stmt.executeUpdate(sql);
           }
           catch(Exception e){
              JOptionPane.showMessageDialog(null,"Deleted");
           }

    }


    public static ArrayList<AboutEntity> getSpecificAboutDetails(int edit_id) {
String sql="SELECT * FROM `about` where abid="+edit_id;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class SliderEntity
        ArrayList<AboutEntity> ase=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of SliderEntity
               AboutEntity ade=new AboutEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                //adding results in arraylist
                ase.add(ade);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of about information failed");
        }
        //returning values  
        return ase;


    }

    public static void updateAboutInformation(AboutEntity abe) {
          String sql="UPDATE  `about` SET `services_image`='"+abe.getServices_image()+"',`services_title`='"+abe.getServices_title()+"',`services_description`='"+abe.getServices_description()+"',`testimonial_description`='"+abe.getTestimonial_description()+"',`testimonial_author_name`='"+abe.getTestimonial_author_name()+"',`about_header`='"+abe.getAbout_header()+"',`about_description`='"+abe.getAbout_description()+"' WHERE `abid`="+abe.getAbe(); 
Statement stmt=DbConnection.DBConnection.connection();
        try {
            //creating arraylist for class SliderEntity
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to update information");
        }
    }
   

}

 


