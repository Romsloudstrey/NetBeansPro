/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.ContactEntity;
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
@WebServlet(name = "ContactDao", urlPatterns = {"/ContactDao"})
public class ContactDao  {

    public static void insertContactDetails(ContactEntity cone) {
String sql="INSERT INTO `contact`( `contactUs_title`, `contact_Description`, `field1_Name`, `field2_Name`, `field3_Name`, `field4_Name`) VALUES ('"+cone.contactUs_title+"','"+cone.contact_Description+"','"+cone.field1_Name+"','"+cone.field2_Name+"','"+cone.field3_Name+"','"+cone.field4_Name+"')";
Statement stmt =DbConnection.DBConnection.connection();
        try {
            stmt.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Contact Details Inserted Successfully");

        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Contact  Details NOt Inserted Successfully");

        }

    }

    public static ArrayList<ContactEntity> displayContact() {
         String sql="SELECT * FROM `contact`";
         Statement stmt =DbConnection.DBConnection.connection();
         ArrayList<ContactEntity> cone=new ArrayList();
        try {
                   ResultSet rs= stmt.executeQuery(sql);
                   while(rs.next()){
                       ContactEntity ce=new ContactEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                  cone.add(ce);
                   } 
        }        catch (Exception e) {
                
                }
        return cone;
        }

    public static void deleteContact(int delid) {
        String sql="DELETE FROM `contact` WHERE `conid`="+delid;
                 Statement stmt =DbConnection.DBConnection.connection();
              try {
                  stmt.executeUpdate(sql);
                                          JOptionPane.showMessageDialog(null, "deleted Successfully");

        } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, " deleted  Successfully");

        }
    }

 


    public static ArrayList<ContactEntity> editContactDetails(int elid) {
String sql="SELECT * FROM `contact` WHERE conid ="+elid;
         Statement stmt =DbConnection.DBConnection.connection();

ArrayList<ContactEntity> cone=new ArrayList();
        try {
                   ResultSet rs= stmt.executeQuery(sql);
                   while(rs.next()){
                       ContactEntity ce=new ContactEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                  cone.add(ce);
                   } 
        }        catch (Exception e) {
                
                }
        return cone;

    }

    public static void contactEditDetails(ContactEntity cone) {
String sql="UPDATE `contact` SET `contactUs_title`='"+cone.getContactUs_title()+"',`contact_Description`='"+cone.getContact_Description()+"',`field1_Name`='"+cone.getField1_Name()+"',`field2_Name`='"+cone.getField2_Name()+"',`field3_Name`='"+cone.getField3_Name()+"',`field4_Name`='"+cone.getField4_Name()+"' WHERE `conid`="+cone.getConid();
        System.out.println(sql);
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

 
        
    
