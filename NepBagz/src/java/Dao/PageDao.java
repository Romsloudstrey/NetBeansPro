/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.PageEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author myhp
 */
public class PageDao {
    public static void insertPageDetails(PageEntity pe){
        //creating insert sql
        String sql="INSERT INTO `pages`(`pagename`, `pagedescription`, `image`) VALUES ('" +pe.getPageName()+"','" +pe.getPageDescription()+"','"+pe.getImgName()+"')";       
//preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //for inserting we use executeUpdate() for prepared statement
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<PageEntity> getPageDetails(){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `pages` ";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<PageEntity> ape=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                PageEntity pe=new PageEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                ape.add(pe);
            }
        } catch (Exception e) {
        }
        //returning values  
        return ape;
    }
    
    public static void deletePages(int pid){
        //creating sql for deleting specific page for which id is obtained through parameter
        String sql="DELETE FROM `pages` WHERE `pid`="+pid;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //executing prepared sql
            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            //showing message for deletion failure
            //JOptionPane.showMessageDialog(null, "Deletion Failed");
        }
    }
    
    public static ArrayList<PageEntity> getSpecificPageDetails(int pid){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `pages` where pid="+pid;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<PageEntity> ape=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                PageEntity pe=new PageEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                ape.add(pe);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
        }
        //returning values  
        return ape;
    }
    
    public static void updatePageInformation(PageEntity pe){
        //creating an sql for updating pages information
        String sql="UPDATE `pages` SET `pagename`= '"+pe.getPageName()+"',`pagedescription`='"+pe.getPageDescription()+"', `image`='"+pe.getImgName()+"' WHERE `pid`="+pe.getPageId();
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //creating arraylist for class PageEntity
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<PageEntity> searchPage(PageEntity pe){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `pages` WHERE `pagename` like '"+pe.getPageName()+"%'";
        System.out.println(sql);
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<PageEntity> ape=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                PageEntity pae=new PageEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                ape.add(pae);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
        }
        //returning values  
        return ape;
    }
}
