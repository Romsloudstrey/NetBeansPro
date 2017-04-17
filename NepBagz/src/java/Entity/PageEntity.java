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
public class PageEntity {
    int pageId;
    String pageName, pageDescription, imgName;

    public PageEntity() {
    }

    public PageEntity(int pageId, String pageName, String pageDescription, String imgName) {
        this.pageId = pageId;
        this.pageName = pageName;
        this.pageDescription = pageDescription;
        this.imgName=imgName;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
