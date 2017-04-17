/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author myhp
 */
public class DBConnection {

    public static Statement connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver loading failed");
        }
        Connection conn=null;
        Statement stmt = null;
       try {
           conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/nepbagz", "root", "");
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
       }
       try{
    stmt=conn.createStatement();
       }catch(SQLException ex){
           System.out.println("Failed to create statement");
       }
       return stmt;
    }
    
    	
}



