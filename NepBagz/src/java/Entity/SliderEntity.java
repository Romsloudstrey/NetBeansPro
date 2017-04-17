/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author myhp
 */
public class SliderEntity {
    int sid;
    String slidername, location, imageName;
    

    public SliderEntity() {
    }

    public SliderEntity(int sid, String slidername, String location, String imageName) {
        this.sid = sid;
        this.slidername = slidername;
        this.location = location;
        this.imageName=imageName;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSlidername() {
        return slidername;
    }

    public void setSlidername(String slidername) {
        this.slidername = slidername;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
