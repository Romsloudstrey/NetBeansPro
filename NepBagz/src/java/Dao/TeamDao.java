/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.TeamEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author prjro
 */
public class TeamDao  {

    public static void insertTeamDetails(TeamEntity te) {
   String sql="INSERT INTO `team`( `team_member_image`, `team_member_name`, `team_member_job`, `parallax1_blockquote`, `parallax1_description`, `parallax2_blockquote`, `parallax2_description`) VALUES ('"+te.getTeam_Member_Image()+"','"+te.getTeam_Title()+"','"+te.getTeam_Member_Job()+"','"+te.getParallax1_Blockquote()+"','"+te.getParallax1_Description()+"','"+te.getParallax2_Blockquote()+"','"+te.getParallax2_Description()+"') ";
   Statement stmt=DbConnection.DBConnection.connection();
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            
        }
    }

    public static ArrayList<TeamEntity> displayTeamDetails() {
  String sql="SELECT * FROM `team`";
  Statement stmt=DbConnection.DBConnection.connection();
  ArrayList<TeamEntity> te=new ArrayList();
        try {
            ResultSet rs=stmt.executeQuery(sql);
          while(rs.next()){
              TeamEntity dte=new TeamEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                te.add(dte);
          
          }
        } catch (Exception e) {
            
            
        }
    return te;

    }

    public static ArrayList<TeamEntity> editTeamInformation(int eid) {
          String sql="SELECT * FROM `team` WHERE tmid="+eid;
          Statement stmt=DbConnection.DBConnection.connection();
          ArrayList<TeamEntity> te=new ArrayList();
        try {
            ResultSet rs=stmt.executeQuery(sql);
          while(rs.next()){
              TeamEntity dte=new TeamEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                te.add(dte);
          
          }
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Retrieving of  information failed");

            
        }
    return te;

    }

    public static void updateSpecificInformationDetails(TeamEntity te) {
 String sql="UPDATE `team` SET `team_member_image`='"+te.team_Member_Image+"',`team_member_name`='"+te.getTeam_Title()+"',`team_member_job`='"+te.getTeam_Member_Job()+"',`parallax1_blockquote`='"+te.getParallax1_Blockquote()+"',`parallax1_description`='"+te.getParallax1_Description()+"',`parallax2_blockquote`='"+te.getParallax2_Blockquote()+"',`parallax2_description`='"+te.getParallax2_Description()+"' WHERE `tmid`="+te.getTid();
   Statement stmt=DbConnection.DBConnection.connection();
        try {
            stmt.executeUpdate(sql);
             JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "NOT Updated successfully");
        }
        }

 

    public static void deleteTeam(int delid) {
     String sql="DELETE FROM `team` WHERE tmid="+delid;
        Statement stmt=DbConnection.DBConnection.connection();
        try {
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Deletion Failed");
        }


    }

   
}