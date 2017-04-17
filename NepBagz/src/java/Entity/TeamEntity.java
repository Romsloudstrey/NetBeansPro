/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prjro
 */
@WebServlet(name = "TeamEntity", urlPatterns = {"/TeamEntity"})
public class TeamEntity  {
    public int tid;
    public String team_Member_Image,team_Title,team_Member_Job;
    public String parallax1_Blockquote,parallax1_Description,parallax2_Blockquote,parallax2_Description;

    public TeamEntity() {
    }

    public TeamEntity(int tid, String team_Member_Image, String team_Title, String team_Member_Job, String parallax1_Blockquote, String parallax1_Description, String parallax2_Blockquote, String parallax2_Description) {
        this.tid = tid;
        this.team_Member_Image = team_Member_Image;
        this.team_Title = team_Title;
        this.team_Member_Job = team_Member_Job;
        this.parallax1_Blockquote = parallax1_Blockquote;
        this.parallax1_Description = parallax1_Description;
        this.parallax2_Blockquote = parallax2_Blockquote;
        this.parallax2_Description = parallax2_Description;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTeam_Member_Image() {
        return team_Member_Image;
    }

    public void setTeam_Member_Image(String team_Member_Image) {
        this.team_Member_Image = team_Member_Image;
    }

    public String getTeam_Title() {
        return team_Title;
    }

    public void setTeam_Title(String team_Title) {
        this.team_Title = team_Title;
    }

    public String getTeam_Member_Job() {
        return team_Member_Job;
    }

    public void setTeam_Member_Job(String team_Member_Job) {
        this.team_Member_Job = team_Member_Job;
    }

    public String getParallax1_Blockquote() {
        return parallax1_Blockquote;
    }

    public void setParallax1_Blockquote(String parallax1_Blockquote) {
        this.parallax1_Blockquote = parallax1_Blockquote;
    }

    public String getParallax1_Description() {
        return parallax1_Description;
    }

    public void setParallax1_Description(String parallax1_Description) {
        this.parallax1_Description = parallax1_Description;
    }

    public String getParallax2_Blockquote() {
        return parallax2_Blockquote;
    }

    public void setParallax2_Blockquote(String parallax2_Blockquote) {
        this.parallax2_Blockquote = parallax2_Blockquote;
    }

    public String getParallax2_Description() {
        return parallax2_Description;
    }

    public void setParallax2_Description(String parallax2_Description) {
        this.parallax2_Description = parallax2_Description;
    }
    

   

}
