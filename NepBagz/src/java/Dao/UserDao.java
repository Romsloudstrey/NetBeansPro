/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author myhp
 */
public class UserDao {
    public static void insertUserDetails(UserEntity ue){
        //creating insert sql
        String sql="INSERT INTO `login`(`username`, `password`, `role`) VALUES ('"+ue.getUsername()+"','"+ue.getPassword()+"','"+ue.getRole()+"')";       
        System.out.println(sql);
//preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            //for inserting we use executeUpdate() for prepared statement
            stmt.executeUpdate(sql);
            //showing message for succession of executing the prepared statement
            JOptionPane.showMessageDialog(null, "User Details Inserted Successfully");
        } catch (Exception e) {
            //showing message for failure of executing the prepared statement
            JOptionPane.showMessageDialog(null, "User Details Insertion Failed");
        }
    }
    
    public static ArrayList<UserEntity> getUserDetails(){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `login` ";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<UserEntity> aue=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                UserEntity ue=new UserEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                aue.add(ue);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of user information failed");
        }
        //returning values  
        return aue;
    }
    
    public static void deleteUser(int lid){
        //creating sql for deleting specific page for which id is obtained through parameter
        String sql="DELETE FROM `login` WHERE `lid`="+lid;
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
    
    public static ArrayList<UserEntity> getSpecificUserDetails(int lid){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `login` where lid="+lid;
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<UserEntity> aue=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                UserEntity ue=new UserEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                aue.add(ue);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of user information failed");
        }
        //returning values  
        return aue;
    }
    
    public static void updateUserInformation(UserEntity ue){
        //creating an sql for updating pages information
        String sql="UPDATE `login` SET `username`='"+ue.getUsername()+"',`password`='"+ue.getPassword()+"',`role`='"+ue.getRole()+"' WHERE `lid`="+ue.getLid();
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
    
    public static ArrayList<UserEntity> searchUser(UserEntity ue){
        //creating an sql for selecting all data from table pages
        String sql="SELECT * FROM `login` WHERE `username` like '"+ue.getUsername()+"%'";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //creating arraylist for class PageEntity
        ArrayList<UserEntity> aue=new ArrayList();
        try {
            //for select sql we use executeQuery()
            //here we are storing obtained results from executed SQL in resultset
            ResultSet rs=stmt.executeQuery(sql);
            //using while loop for results
            while(rs.next()){
                //assigning values of resultset in variables of PageEntity
                UserEntity uae=new UserEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //adding results in arraylist
                aue.add(uae);
            }
        } catch (Exception e) {
            //showing message for failure of retrieving page informations
            JOptionPane.showMessageDialog(null, "Retrieving of user information failed");
        }
        //returning values  
        return aue;
    }
    
    public static int checkUsername(UserEntity ue) throws SQLException{
       //creating an sql for selecting all data from table pages
        String sql="SELECT count(lid) from `login` WHERE `username` ='"+ue.getUsername()+"'";
        System.out.println(sql);
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //int usercount= Integer.parseInt((stmt.executeQuery(sql)).toString());
        ResultSet rs= stmt.executeQuery(sql);
        
        rs.next();
        int usercount= rs.getInt("count(lid)");
        System.out.println(usercount);
        return usercount;
    }
    
    public static UserEntity getLoggedUserDetails(UserEntity ue) throws SQLException{
       //creating an sql for selecting all data from table pages
        String sql="SELECT * from `login` WHERE `username` ='"+ue.getUsername()+"'";
        //preparation of statement where statement is returned by connection method of DBConnection class of DbConnection package 
        Statement stmt=DbConnection.DBConnection.connection();
        //int usercount= Integer.parseInt((stmt.executeQuery(sql)).toString());
        ResultSet rs= stmt.executeQuery(sql);
        UserEntity rue = null;
        while(rs.next()){
            rue = new UserEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        return rue;
    }
}
