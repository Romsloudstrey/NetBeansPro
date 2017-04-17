/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.MessageEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author prjro
 */
@WebServlet(name = "MessageDao", urlPatterns = {"/MessageDao"})
public class MessageDao {

    public static void insertMessageDetails(MessageEntity me) {
   String sql="INSERT INTO `message`( `status`, `name`, `email`, `subject`, `message`) VALUES ('"+me.getStatus()+"','"+me.getName()+"','"+me.getEmail()+"','"+me.getSubject()+"','"+me.getMessage()+"')";
   Statement stmt=DbConnection.DBConnection.connection();
   try{
       stmt.executeUpdate(sql);
       
   }
catch(Exception e){
    
}
    }

    public static ArrayList<MessageEntity> displayMessage() {
   String sql="SELECT * FROM `message`";
   Statement stmt=DbConnection.DBConnection.connection();
   ArrayList<MessageEntity> me= new ArrayList();
        try {
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                MessageEntity mse=new MessageEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
             me.add(mse);
            }
        } catch (Exception e) {
        }
  return me;
    }


       

}
