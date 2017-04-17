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
@WebServlet(name = "ContactEntity", urlPatterns = {"/ContactEntity"})
public class ContactEntity {
    public int conid;
    public String contactUs_title,contact_Description,field1_Name,field2_Name,field3_Name,field4_Name;

    public ContactEntity() {
    }

    public ContactEntity(int conid, String contactUs_title, String contact_Description, String field1_Name, String field2_Name, String field3_Name, String field4_Name) {
        this.conid = conid;
        this.contactUs_title = contactUs_title;
        this.contact_Description = contact_Description;
        this.field1_Name = field1_Name;
        this.field2_Name = field2_Name;
        this.field3_Name = field3_Name;
        this.field4_Name = field4_Name;
    }

    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }

    public String getContactUs_title() {
        return contactUs_title;
    }

    public void setContactUs_title(String contactUs_title) {
        this.contactUs_title = contactUs_title;
    }

    public String getContact_Description() {
        return contact_Description;
    }

    public void setContact_Description(String contact_Description) {
        this.contact_Description = contact_Description;
    }

    public String getField1_Name() {
        return field1_Name;
    }

    public void setField1_Name(String field1_Name) {
        this.field1_Name = field1_Name;
    }

    public String getField2_Name() {
        return field2_Name;
    }

    public void setField2_Name(String field2_Name) {
        this.field2_Name = field2_Name;
    }

    public String getField3_Name() {
        return field3_Name;
    }

    public void setField3_Name(String field3_Name) {
        this.field3_Name = field3_Name;
    }

    public String getField4_Name() {
        return field4_Name;
    }

    public void setField4_Name(String field4_Name) {
        this.field4_Name = field4_Name;
    }
    

   
}
