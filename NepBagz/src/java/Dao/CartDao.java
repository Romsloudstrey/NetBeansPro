/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.CartEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author myhp
 */
public class CartDao {

    public static void insertCartDetails(CartEntity cr) {
          String sql="INSERT INTO `cart`(`cid`, `lid`, `BagId`, `BagName`, `Image`, `BagPrice`, `Shipping`, `Quantity`) VALUES ("+cr.getCid()+","+cr.getLid()+","+cr.getBagId()+",'"+cr.getBagName()+"','"+cr.getImageName()+"',"+cr.getBagPrice()+",'"+cr.getShipping()+"',"+cr.getQuantity()+")"; 
          Statement stmt=DbConnection.DBConnection.connection();
          try{
              stmt.executeUpdate(sql);
          }catch(Exception e){
              System.out.println("error");
            
              
          }
          
    }

    public static ArrayList<CartEntity> getCartDetails() {
        String sql="SELECT * FROM `cart`";
        Statement stmt=DbConnection.DBConnection.connection();
        ArrayList<CartEntity> ce=new ArrayList();
        try {
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                CartEntity cte=new CartEntity(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8));
                ce.add(cte);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Retrieving of bag information failed");
        }
        
       return ce;
//int Tax=2,SubTotal=0,Total = 0,Vat=0;
//       int qte=0;
//       String Commande="";
//       
//      for (CartEntity cte : ce){
//    	  qte= qte + cte.getQuantity();
//    	  SubTotal = SubTotal + (cte.getBagPrice() * cte.getQuantity());
//    	  Commande = Commande+" \n Product: "+cte.getBagId()+" || Qunatity: "+cte.getQuantity()+"\n";
//    	  
//      }
//       
//      System.out.println(Commande);
//      Vat = (SubTotal/100) * (17 +  1/2);
//      if(qte == 0)
//          Total = SubTotal + Vat;
//          else
//          Total = SubTotal + Tax  + Vat;
//        return ce;

    }

    public static void deleteCart(int delid) {
 String sql="DELETE FROM `cart` WHERE `cid`="+delid;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //executing prepared sql
            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            //showing message for deletion failure
        }
    }

//    public static ArrayList<CartEntity> editCartDetails(int elid) {
//String sql="SELECT * FROM `contact` WHERE cid ="+elid;
//         Statement stmt =DbConnection.DBConnection.connection();
//
//ArrayList<CartEntity> ce=new ArrayList();
//        try {
//                   ResultSet rs= stmt.executeQuery(sql);
//                   while(rs.next()){
//                CartEntity cte=new CartEntity(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8));
//                  ce.add(cte);
//                   } 
//        }        catch (Exception e) {
//                
//                }
//        return ce;
//
//
//    }

//String sql="UPDATE `cart` SET `Quantity`="+cr.getQuantity()+" WHERE `cid`="+cr.getCid();
//   Statement stmt=DbConnection.DBConnection.connection();
//        try {
//            //creating arraylist for class SliderEntity
//            //for select sql we use executeQuery()
//            //here we are storing obtained results from executed SQL in resultset
//            stmt.executeUpdate(sql);
//        } catch (Exception e) {
//        }

    public static void editCartDetails(CartEntity cr) {
String sql="UPDATE `cart` SET `Quantity`="+cr.getQuantity()+" WHERE `cid`="+cr.getCid();
Statement stmt=DbConnection.DBConnection.connection();
try{
    stmt.executeUpdate(sql);
}
catch(Exception e){
    
}
    }
    

 

    }

  
    






   

    

