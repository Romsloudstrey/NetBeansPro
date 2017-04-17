/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.BagsEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class BagsDao
{

    public static void insertBagsDetails(BagsEntity be) {
        //creating insert sql
//        String sql="INSERT INTO `bag`(`Portfolio_Name`,`Portfolio_Description`,`BagName`, `Image`, `BagDate`, `BagPrice`, `BagBrand`, `sellername`, `selleremail`, `sellercontactnum`, `selleraddress`) VALUES ('"+be.getPortfolio_Name()+"','"+be.getPortfolio_Description()+"','"+be.getBagName()+"','"+be.getImageName()+"','"+be.getDate()+"',"+be.getBagPrice()+",'"+be.getBagBrand()+"','"+be.getSellername()+"','"+be.getSelleremail()+"',"+be.getSellernum()+",'"+be.getSelleraddress()+"')";
        
//preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        String sql="INSERT INTO `bag`(`BagId`, `Portfolio_Name`, `Portfolio_Description`, `BagName`, `Image`, `BagDate`, `BagPrice`, `BagBrand`, `shipping`, `colors`, `sellername`, `selleremail`, `sellercontactnum`, `selleraddress`) VALUES ("+be.getBagId()+",'"+be.getPortfolio_Name()+"','"+be.getPortfolio_Description()+"','"+be.getBagName()+"','"+be.getImageName()+"','"+be.getDate()+"',"+be.getBagPrice()+",'"+be.getBagBrand()+"','"+be.getShipping()+"','"+be.getColor()+"','"+be.getSellername()+"','"+be.getSelleremail()+"',"+be.getSellernum()+",'"+be.getSelleraddress()+"')";
System.out.println(sql);
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //for inserting we use executeUpdate() for prepared statement
            stmt.executeUpdate(sql);
            //showing message for succession of executing the prepared statement

       } catch (Exception e) {
            //showing message for failure of executing the prepared statement
        }
    }
    public static ArrayList<BagsEntity> getBagsDetails(){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `bag` ";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<BagsEntity> ape=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                BagsEntity be=new BagsEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14));
                //adding results in arraylist
                System.out.println(be);
                ape.add(be);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of bag information failed");
        }
        //returning values  
        return ape;
    }
    
    public static void deleteBags(int BagId){
        //creating sql for deleting specific page for which id is obtained through parameter
        String sql="DELETE FROM `bag` WHERE `BagId`="+BagId;
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
    
    public static ArrayList<BagsEntity> getSpecificBagsDetails(int BagId){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `bag` where BagId="+BagId;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<BagsEntity> ble=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                BagsEntity be=new BagsEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14));
                //adding results in arraylist
                ble.add(be);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of page information failed");
        }
        //returning values  
        return ble;
    }
    
    public static ArrayList<BagsEntity> getSpecificBagDetails(String imgnm){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `bag` where Image='"+imgnm+"'";
        System.out.println(sql);
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<BagsEntity> ble=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                BagsEntity be=new BagsEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14));
                //adding results in arraylist
                ble.add(be);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of page information failed");
        }
        //returning values  
        return ble;
    }

   
 public static void updateBagInformation(BagsEntity be){
        //creating an sql for updating pages information
    String sql="UPDATE `bag` SET `Portfolio_Name`='"+be.getPortfolio_Name()+"',`Portfolio_Description`='"+be.getPortfolio_Description()+"',`BagName`='"+be.getBagName()+"',`Image`='"+be.getImageName()+"',`BagPrice`="+be.getBagPrice()+",`BagBrand`='"+be.getBagBrand()+"',`shipping`='"+be.getShipping()+"',`colors`='"+be.getColor()+"',`sellername`='"+be.getSellername()+"',`selleremail`='"+be.getSelleremail()+"',`sellercontactnum`='"+be.getSellernum()+"',`selleraddress`='"+be.getSelleraddress()+"' WHERE `BagId`="+ be.getBagId();
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();

        try {
            //creating arraylist for class PageEntity
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset

            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to update information");
        }
    }

        public static ArrayList<BagsEntity> searchBags(BagsEntity be){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `bag` WHERE `BagName` like '"+be.getBagName()+"%'";
        System.out.println(sql);
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<BagsEntity> ape=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                BagsEntity bae=new BagsEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14));
                //adding results in arraylist
                ape.add(bae);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of bag information failed");
        }
        //returning values  
        return ape;
    }



}