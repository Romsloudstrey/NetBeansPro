/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.SliderEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author myhp
 */
public class SliderDao
{
    public static void insertSliderDetails(SliderEntity se){
        //creating insert sql
        String sql="INSERT INTO `slider`(`name`, `location`, `image`) VALUES ('"+se.getSlidername()+"','"+se.getLocation()+"','"+se.getImageName()+"')";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //for inserting we use executeUpdate() for prepared statement
            stmt.executeUpdate(sql);
            //showing message for succession of executing the prepared statement
            JOptionPane.showMessageDialog(null, "Slider Details Inserted Successfully");
        } catch (Exception e) {
            //showing message for failure of executing the prepared statement
            JOptionPane.showMessageDialog(null, "Slider Details Insertion Failed");
        }
    }
    
    public static ArrayList<SliderEntity> getSliderDetails(){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `slider` ";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class SliderEntity
        ArrayList<SliderEntity> ase=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                SliderEntity pe=new SliderEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                ase.add(pe);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of slider information failed");
        }
        //returning values  
        return ase;
    }
    
    public static void deleteSlider(int sid){
        //creating sql for deleting specific page for which id is obtained through parameter
        String sql="DELETE FROM `slider` WHERE `sid`="+sid;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //executing prepared sql
            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            //showing message for deletion failure
            JOptionPane.showMessageDialog(null, "Deletion Failed");
        }
    }
    
    public static ArrayList<SliderEntity> getSpecificSliderDetails(int sid){
        //creating an sql for selecting all data from table slider
        String sql="SELECT * FROM `slider` where sid="+sid;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class SliderEntity
        ArrayList<SliderEntity> ase=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of SliderEntity
                SliderEntity se=new SliderEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                ase.add(se);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of slider information failed");
        }
        //returning values  
        return ase;
    }
    
    public static void updateSliderInformation(SliderEntity se){
        //creating an sql for updating pages information
        String sql="UPDATE `slider` SET `name`='"+se.getSlidername()+"',`location`='"+se.getLocation()+"', `image`='"+se.getImageName()+"' WHERE `sid`="+se.getSid();
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
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

         public static ArrayList<SliderEntity> searchSlider(SliderEntity se){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `slider` WHERE `name` like '"+se.getSlidername()+"%'";
        System.out.println(sql);
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<SliderEntity> ape=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                SliderEntity sae=new SliderEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                ape.add(sae);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of slider information failed");
        }
        //returning values  
        return ape;
    }  
      
 }
       
