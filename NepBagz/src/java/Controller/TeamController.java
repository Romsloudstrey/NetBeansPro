/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.TeamDao;
import Entity.TeamEntity;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet({"/saveteam","/displayteam","/deleteteam/","/editteam/","/editteamdetails"})
public class TeamController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
String  contextPath=request.getContextPath();
        if(request.getRequestURI().equals(contextPath+"/displayteam")){
            ArrayList<TeamEntity> te=TeamDao.displayTeamDetails();
            RequestDispatcher rd=request.getRequestDispatcher("/DisplayTeam.jsp");
            request.setAttribute("team",te);
           rd.forward(request, response);

        }
        else if(request.getRequestURI().equals(contextPath+"/deleteteam/")){
            int delid=Integer.parseInt(request.getParameter("delid"));
                        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Options", JOptionPane.OK_CANCEL_OPTION);
                if (x == 0) {
                //calling methods of PageDao for deleting the selected page (ie. obtained page id)
                    TeamDao.deleteTeam(delid);
                String message = "Deletion succeeded";
               response.sendRedirect(contextPath+"/displayteam");

            } else {
                //redirection user to intended page when user cancel deletion process
                response.sendRedirect("TeamController?action=teamdisplay");
            }
            
        }
        else if(request.getRequestURI().equals(contextPath+"/editteam/")){
            int eid=Integer.parseInt(request.getParameter("eid"));
          ArrayList<TeamEntity>te=TeamDao.editTeamInformation(eid);
               RequestDispatcher rd=request.getRequestDispatcher("/EditTeamDetails.jsp");
            request.setAttribute("eteam",te);
            rd.forward(request, response);
         
        }
        else{
                        response.sendRedirect("ErrorPage.jsp");

        }
        

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String contextPath=request.getContextPath();
        if(request.getRequestURI().equals(contextPath+"/saveteam")){
            String path=request.getServletContext().getRealPath("img");
            MultipartRequest mr=new MultipartRequest(request,path,5000000,new DefaultFileRenamePolicy());
            String  team_Member_Image=mr.getFilesystemName("Team_Member_Image");
             String  team_Title=mr.getParameter("Team_Title");
             String  team_Member_Job=mr.getParameter("Team_Member_Job");
             String  parallax1_Blockquote=mr.getParameter("Parallax1_Blockquote");
             String  parallax1_Description=mr.getParameter("Parallax1_Description");
             String  parallax2_Blockquote=mr.getParameter("Parallax2_Blockquote");
             String  parallax2_Description=mr.getParameter("Parallax2_Description");
      
             TeamEntity te=new TeamEntity(0,team_Member_Image,team_Title,team_Member_Job,parallax1_Blockquote,parallax1_Description,parallax2_Blockquote,parallax2_Description);
 
             TeamDao.insertTeamDetails(te);
           
                 response.sendRedirect(contextPath+"/AddTeam.jsp");
                       

    
          
      }  
        else if(request.getRequestURI().equals(contextPath+"/editteamdetails")){
            String path=request.getServletContext().getRealPath("img");
            MultipartRequest mr=new MultipartRequest(request,path,5000000,new DefaultFileRenamePolicy());
            int uteam_Id =Integer.parseInt(mr.getParameter("Team_Id"));
            String  uteam_Member_Image=mr.getFilesystemName("Team_Member_Image");
             String  uteam_Title=mr.getParameter("Team_Title");
             String  uteam_Member_Job=mr.getParameter("Team_Member_Job");
             String  uparallax1_Blockquote=mr.getParameter("Parallax1_Blockquote");
             String  uparallax1_Description=mr.getParameter("Parallax1_Description");
             String  uparallax2_Blockquote=mr.getParameter("Parallax2_Blockquote");
             String  uparallax2_Description=mr.getParameter("Parallax2_Description");
             TeamEntity te=new TeamEntity(uteam_Id,uteam_Member_Image,uteam_Title,uteam_Member_Job,uparallax1_Blockquote,uparallax1_Description,uparallax2_Blockquote,uparallax2_Description);
                  int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "Update Options", JOptionPane.OK_CANCEL_OPTION);
if( x==0){
            TeamDao.updateSpecificInformationDetails(te);
            response.sendRedirect(contextPath+"/displayteam");

        }
else{
                        response.sendRedirect(contextPath+"/displayteam");

        }
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
