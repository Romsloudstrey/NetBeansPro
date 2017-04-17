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
@WebServlet(name = "AboutEntity", urlPatterns = {"/AboutEntity"})
public class AboutEntity   {
    public int  abe;
public  String services_image,services_title,services_description,testimonial_description,testimonial_author_name;
   public String about_header,about_description;

    public AboutEntity() {
    }
   

    public AboutEntity(int abe, String services_image, String services_title, String services_description, String testimonial_description, String testimonial_author_name, String about_header, String about_description) {
        this.abe = abe;
        this.services_image = services_image;
        this.services_title = services_title;
        this.services_description = services_description;
        this.testimonial_description = testimonial_description;
        this.testimonial_author_name = testimonial_author_name;
        this.about_header = about_header;
        this.about_description = about_description;
    }

    public int getAbe() {
        return abe;
    }

    public void setAbe(int abe) {
        this.abe = abe;
    }

    public String getServices_image() {
        return services_image;
    }

    public void setServices_image(String services_image) {
        this.services_image = services_image;
    }

    public String getServices_title() {
        return services_title;
    }

    public void setServices_title(String services_title) {
        this.services_title = services_title;
    }

    public String getServices_description() {
        return services_description;
    }

    public void setServices_description(String services_description) {
        this.services_description = services_description;
    }

    public String getTestimonial_description() {
        return testimonial_description;
    }

    public void setTestimonial_description(String testimonial_description) {
        this.testimonial_description = testimonial_description;
    }

    public String getTestimonial_author_name() {
        return testimonial_author_name;
    }

    public void setTestimonial_author_name(String testimonial_author_name) {
        this.testimonial_author_name = testimonial_author_name;
    }

    public String getAbout_header() {
        return about_header;
    }

    public void setAbout_header(String about_header) {
        this.about_header = about_header;
    }

    public String getAbout_description() {
        return about_description;
    }

    public void setAbout_description(String about_description) {
        this.about_description = about_description;
    }
    
}

   
