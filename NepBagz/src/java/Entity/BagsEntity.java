/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
/**
 *
 * @author USER
 */
public class BagsEntity  {
    public int bagId;
    public String portfolio_Name,portfolio_Description,bagName,imageName;
  public  Date date;
    public int bagPrice;
    public String bagBrand;
    public String color;
        public String shipping;
    String sellername, selleremail;
        public int  sellernum;  
          String  selleraddress;
        

//
//    public void setColor(String[] colors) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public BagsEntity() {
    }

    public BagsEntity(int bagId, String portfolio_Name, String portfolio_Description, String bagName, String imageName, Date date, int bagPrice, String bagBrand, String shipping, String color, String sellername, String selleremail, int sellernum, String selleraddress) {
        this.bagId = bagId;
        this.portfolio_Name = portfolio_Name;
        this.portfolio_Description = portfolio_Description;
        this.bagName = bagName;
        this.imageName = imageName;
        this.date = date;
        this.bagPrice = bagPrice;
        this.bagBrand = bagBrand;
        this.color = color;
        this.shipping = shipping;
        this.sellername = sellername;
        this.selleremail = selleremail;
        this.sellernum = sellernum;
        this.selleraddress = selleraddress;
    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public String getPortfolio_Name() {
        return portfolio_Name;
    }

    public void setPortfolio_Name(String portfolio_Name) {
        this.portfolio_Name = portfolio_Name;
    }

    public String getPortfolio_Description() {
        return portfolio_Description;
    }

    public void setPortfolio_Description(String portfolio_Description) {
        this.portfolio_Description = portfolio_Description;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBagPrice() {
        return bagPrice;
    }

    public void setBagPrice(int bagPrice) {
        this.bagPrice = bagPrice;
    }

    public String getBagBrand() {
        return bagBrand;
    }

    public void setBagBrand(String bagBrand) {
        this.bagBrand = bagBrand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getSelleremail() {
        return selleremail;
    }

    public void setSelleremail(String selleremail) {
        this.selleremail = selleremail;
    }

    public int getSellernum() {
        return sellernum;
    }

    public void setSellernum(int sellernum) {
        this.sellernum = sellernum;
    }

    public String getSelleraddress() {
        return selleraddress;
    }

    public void setSelleraddress(String selleraddress) {
        this.selleraddress = selleraddress;
    }



    
   
   

}