/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author romy
 */
//@WebServlet({"/Test"})
public class Test extends HttpServlet {

   
   private DataSource dataSource;
	private Connection conn;
	private Statement stmt;
	
   @Override
	public void init() throws ServletException {
		try {
			// Get DataSource JNI
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/testdb");

			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//        private Connection getConnection() throws SQLException {
//  
//  
//  }

   @Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				Context ctx = null;

//		ResultSet resultSet = null;
                 conn = null;
		 stmt = null;
		try {
			// Get Connection and Statement
//			conn = getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}

        }

 
    @Override
 public void destroy() {
     try{
            conn.close();
     }
          catch(SQLException e){
              
          }                
                            
                        }

	
        

}
