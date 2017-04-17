/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.BuyEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myhp
 */
public class BuyDao {
    public static void insertPurchaseDetails(BuyEntity be) {
        //creating insert sql
        String sql="INSERT INTO `buy`(`pid`, `status`, `firstname`, `middlename`, `lastname`, `address`, `zipcode`, `email`, `color`, `country`, `cardnumber`, `expiredate`, `csc`, `bgid`, `quantity`) VALUES ("+be.getPid()+",'"+be.getStatus()+"','"+be.getFirstname()+"','"+be.getMiddlename()+"','"+be.getLastname()+"','"+be.getAddress()+"',"+be.getZipcode()+",'"+be.getEmail()+"','"+be.getColor()+"','"+be.getCountry()+"',"+be.getCardnumber()+",'"+be.getExpiredate()+"',"+be.getCsc()+","+be.getBgid()+","+be.getQuantity()+")";
        System.out.println(sql);
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //for inserting we use executeUpdate() for prepared statement
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BuyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
    
//    public static ArrayList<BuyEntity> getPurchaseDetails(){
//        //creating an sql for selecting all data from table pages
//        String sql="SELECT * FROM `purchase` ";
//        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
//        Statement stmt=DbConnection.DBConnection.connection();
//        //creating arraylist for class PageEntity
//        ArrayList<BuyEntity> ape=new ArrayList();
//        try {
//            //for select sql we use executeQuery()
//            //here we are storing obtained results from executed SQL in resultset
//            ResultSet rs=stmt.executeQuery(sql);
//            //using while loop for results
//            while(rs.next()){
//                //assigning values of resultset in variables of PageEntity
//                BuyEntity be=new BuyEntity(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDate(8),rs.getString(9));
//                //adding results in arraylist
//                ape.add(be);
//            }
//        } catch (Exception e) {
//            //showing message for failure of retrieving page informations
//        }
//        //returning values  
//        return ape;
//    }
    
//    public static ArrayList<BuyEntity> getSpecificPurchaseDetails(int pid){
//        //creating an sql for selecting all data from table pages
//        String sql="SELECT * FROM `purchase` where pid="+pid;
//        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
//        Statement stmt=DbConnection.DBConnection.connection();
//        //creating arraylist for class PageEntity
//        ArrayList<BuyEntity> ble=new ArrayList();
//        try {
//            //for select sql we use executeQuery()
//            //here we are storing obtained results from executed SQL in resultset
//            ResultSet rs=stmt.executeQuery(sql);
//            //using while loop for results
//            while(rs.next()){
//                //assigning values of resultset in variables of PageEntity
//            BuyEntity be=new BuyEntity(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDate(8),rs.getString(9));    
//                //adding results in arraylist
//                ble.add(be);
//            }
//        } catch (Exception e) {
//            //showing message for failure of retrieving page informations
//            
//        }
//        //returning values  
//        return ble;
//    }
    
//    public static void updatePurchaseInformation(BuyEntity be){
//        //creating an sql for updating pages information
//    String sql="UPDATE `purchase` SET `Buyer Name`='"+be.getBuyerName() +"',`email`='"+be.getEmail()+"',`phone number`='"+be.getPhNum()+"',`bgid`="+be.getBgid()+",`quantity`="+be.getQuantity()+",`totalamount`="+be.getTotalAmount()+",`status`='"+be.getStatus()+"' WHERE `pid`="+be.getPid();
//        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
//        System.out.println(sql);    
//    Statement stmt=DbConnection.DBConnection.connection();
//
//        try {
//            //creating arraylist for class PageEntity
//            //for select sql we use executeQuery()
//            //here we are storing obtained results from executed SQL in resultset
//
//            stmt.executeUpdate(sql);
//        } catch (Exception e) {
//            
//        }
//    }
}
