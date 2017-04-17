/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.LoginDao;
import Dao.MessageDao;
import Dao.UserDao;
import Entity.LoginEntity;
import Entity.MessageEntity;
import Entity.UserEntity;
import Utils.EncryptPassword;
import Utils.VerifyRecaptcha;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/admin-login","/admin-logout"})
public class LoginController extends HttpServlet {

   
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath=request.getContextPath();
        if (request.getRequestURI().equals(contextPath+"/admin-logout")) {
//            HttpSession se = request.getSession();
//            se.removeAttribute("loggeduser");
//            response.sendRedirect("LoginPage.jsp");
////	Cookie[] cookies = request.getCookies();
////    	if(cookies != null){
////    	for(Cookie cookie : cookies){
////    		if(cookie.getName().equals("JSESSIONID")){
////    			System.out.println("JSESSIONID="+cookie.getValue());
////    			break;
////    		}
//    	}
//    	}
    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	System.out.println("User="+session.getAttribute("user"));
    	if(session != null){
    		session.invalidate();
    	}
    	        RequestDispatcher rd= request.getRequestDispatcher("/index");
          rd.forward(request,response);
    
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath=request.getContextPath();
        if (request.getRequestURI().equals(contextPath+"/admin-login")) {

            String username = request.getParameter("username");
            String pswd = request.getParameter("password");
            String encpassword = EncryptPassword.encrypt(pswd);
//             String Decrypted = DecryptPassword.decrypt(encpassword);

            // get reCAPTCHA request param
            String gRecaptchaResponse = request
                    .getParameter("g-recaptcha-response");
            System.out.println(gRecaptchaResponse);
            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

            LoginEntity le = new LoginEntity();
            le.setUsername(username);
            le.setPassword(encpassword);
            UserEntity uefl = new UserEntity(0, username, null, null);
            boolean successfull = LoginDao.check(le);
            if (successfull && verify) {
                HttpSession session = request.getSession();
                UserEntity ue = null;
                try {
                    ue = UserDao.getLoggedUserDetails(uefl);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                String role=ue.getRole();
                session.setAttribute("loggeduser", ue);
                session.setAttribute("role", role);
                
                if(role.equals("admin")){
                    
//            ArrayList < MessageEntity> me =MessageDao.displayMessage();
//          RequestDispatcher rd= request.getRequestDispatcher(contextPath+"/displaycontactmessage");
//            
//            request.setAttribute("msg", me);
//           
//            rd.forward(request, response);
                                response.sendRedirect(contextPath+"/dashboard");

                }else{
                    
                    response.sendRedirect(contextPath+"/index");
                }
            } else {
                //response.sendRedirect("LoginPage.jsp");
                //RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginPage.jsp");
                //PrintWriter out = response.getWriter();
                if (verify) {
                    String message = "Username and password do not matched";
                    request.getSession().setAttribute("ermsg", message);
                    response.sendRedirect(contextPath+"/loginpage");
                    //out.println("<font color=red>Either user name or password is wrong.</font>");
                } else {
                    String message = "Please verify that you are not a bot";
                    request.getSession().setAttribute("ermsg", message);
                    response.sendRedirect(contextPath+"/loginpage");
                    //out.println("<font color=red>You missed the Captcha.</font>");
                }
                //rd.include(request, response);
            }
        }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
