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
public class CartEntity {
     public int lid,bagId,cid;
     public String imageName,bagName;
     public int bagPrice;
    public String shipping;
     public int quantity;

    public CartEntity() {
    }

    public CartEntity( int cid,int lid, int bagId,  String bagName,String imageName, int bagPrice, String shipping, int quantity) {
       
        this.cid = cid;
         this.lid = lid;
        this.bagId = bagId;
        
        this.bagName = bagName;
        this.imageName = imageName;
        this.bagPrice = bagPrice;
        this.shipping = shipping;
        this.quantity = quantity;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName;
    }

    public int getBagPrice() {
        return bagPrice;
    }

    public void setBagPrice(int bagPrice) {
        this.bagPrice = bagPrice;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     

   
    
    
    
}
