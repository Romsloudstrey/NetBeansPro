/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AboutDao;
import Dao.BagsDao;
import Dao.BuyDao;
import Dao.CartDao;
import Dao.ContactDao;
import Dao.PageDao;
import Dao.SliderDao;
import Dao.TeamDao;
import Dao.UserDao;
import Entity.AboutEntity;
import Entity.BagsEntity;
import Entity.BuyEntity;
import Entity.CartEntity;
import Entity.ContactEntity;
import Entity.PageEntity;
import Entity.SliderEntity;
import Entity.TeamEntity;
import Entity.UserEntity;
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
import javax.servlet.http.HttpSession;

@WebServlet({"/index", "/buy/", "/addtocart/", "/loginpage", "/editcartdetails", "/displaycarts", "/deletecart/","/savetocart","/checkout","/dashboard"})
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        //for displaying from backend to frontend
        if (request.getRequestURI().equals(contextPath + "/index")) {
            ArrayList<SliderEntity> se = SliderDao.getSliderDetails();
            request.setAttribute("slider", se);
            ArrayList<AboutEntity> abe = AboutDao.getAboutDetails();
            request.setAttribute("about", abe);
            ArrayList<TeamEntity> te = TeamDao.displayTeamDetails();
            request.setAttribute("team", te);
            ArrayList<BagsEntity> ble = BagsDao.getBagsDetails();
            request.setAttribute("bag", ble);
            ArrayList<ContactEntity> cone = ContactDao.displayContact();
            request.setAttribute("con", cone);
            ArrayList<PageEntity> pe = PageDao.getPageDetails();
            request.setAttribute("page", pe);
            ArrayList<UserEntity> ue = UserDao.getUserDetails();
            request.setAttribute("user", ue);
            ArrayList<CartEntity> cle = CartDao.getCartDetails();
            request.setAttribute("cart", cle);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        } //        else if (request.getRequestURI().equals(contextPath + "/indexheader")) {
        //            ArrayList<PageEntity> pe = PageDao.getPageDetails();
        //            request.setAttribute("page", pe);
        //            ArrayList<UserEntity> ue = UserDao.getUserDetails();
        //            request.setAttribute("user", ue);
        //            ArrayList<CartEntity> cle = CartDao.getCartDetails();
        //            request.setAttribute("cart", cle);
        //            RequestDispatcher rd = request.getRequestDispatcher("/IndexHeader.jsp");
        //            rd.forward(request, response);
        //        }
        //        else if (request.getRequestURI().equals(contextPath + "/indexfooter")) {
        //            RequestDispatcher rd = request.getRequestDispatcher("/IndexFooter.jsp");
        //            rd.forward(request, response);
        ////                response.sendRedirect("/IndexFooter.jsp");
        //        } 
        else if (request.getRequestURI().equals(contextPath + "/buy/")) {
            int BagId = Integer.parseInt(request.getParameter("eid"));

            ArrayList<BagsEntity> ble = BagsDao.getSpecificBagsDetails(BagId);

            request.setAttribute("EditBagsDetail", ble);
            ArrayList<PageEntity> pe = PageDao.getPageDetails();
            request.setAttribute("page", pe);
            RequestDispatcher rd = request.getRequestDispatcher("/BuyBag.jsp");

            rd.forward(request, response);
        } 
        ///CART DETAILS
        else if (request.getRequestURI().equals(contextPath + "/addtocart/")) {
            int BagId = Integer.parseInt(request.getParameter("eid"));
            int edit_id = Integer.parseInt(request.getParameter("eid"));

            ArrayList<BagsEntity> ble = BagsDao.getSpecificBagsDetails(BagId);

            request.setAttribute("EditBagsDetail", ble);
            ArrayList<PageEntity> pe = PageDao.getPageDetails();
            request.setAttribute("page", pe);
            ArrayList<UserEntity> ue = UserDao.getUserDetails();

            request.setAttribute("user", ue);
            RequestDispatcher rd = request.getRequestDispatcher("/AddToCart.jsp");

            rd.forward(request, response);

        } else if (request.getRequestURI().equals(contextPath + "/loginpage")) {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.jsp");

            rd.forward(request, response);
        }
         else if (request.getRequestURI().equals(contextPath + "/dashboard")) {
            RequestDispatcher rd = request.getRequestDispatcher("/Dashboard.jsp");

            rd.forward(request, response);
        }
         else if (request.getRequestURI().equals(contextPath + "/displaycarts")) {
            ArrayList<CartEntity> cle = CartDao.getCartDetails();
            RequestDispatcher rd = request.getRequestDispatcher(contextPath + "/displaycarts");

            request.setAttribute("cartdisplay", cle);
            rd.forward(request, response);
        } else if (request.getRequestURI().equals(contextPath + "/deletecart/")) {
            int delid = Integer.parseInt(request.getParameter("delid"));
            CartDao.deleteCart(delid);
            response.sendRedirect(contextPath + "/index");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        if (request.getRequestURI().equals(contextPath + "/checkout")) {
            long millis = System.currentTimeMillis();
            java.sql.Date expiredate = new java.sql.Date(millis);

            String status = "on Process";

            String firstname = request.getParameter("FirstName");

            String middlename = request.getParameter("MiddleName");

            String lastname = request.getParameter("LastName");

            String address = request.getParameter("Address");

            int zipcode = Integer.parseInt(request.getParameter("ZipCode"));

            String email = request.getParameter("Email");

            String[] colors = request.getParameterValues("Colors");

            String color = "";
            for (int i = 0; i < colors.length; i++) {
                color = colors[i] + "," + color;
            }
            System.out.println(color);
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            String country = request.getParameter("Country");

            int cardnumber = Integer.parseInt(request.getParameter("cardnumber"));

            int csc = Integer.parseInt(request.getParameter("csc"));

            int bgid = Integer.parseInt(request.getParameter("bgid"));

            BuyEntity be = new BuyEntity(0, status, firstname, middlename, lastname, address, zipcode, email, color, country, cardnumber, expiredate, csc, bgid, quantity);
            BuyDao.insertPurchaseDetails(be);
            response.sendRedirect(contextPath + "/buy/");
        }
        int counter = 0;
        if (request.getRequestURI().equals(contextPath + "/savetocart")) {

            String path = request.getServletContext().getRealPath("img");
            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            int uid = Integer.parseInt(mr.getParameter("uid"));
            System.out.println(uid);
            int bagid = Integer.parseInt(mr.getParameter("bagId"));
            String bagname = mr.getParameter("BagName");
            String imagename = mr.getFilesystemName("ImageName");
            int bagprice = Integer.parseInt(mr.getParameter("price"));
            String shipping = mr.getParameter("Shipping");
            int quantity = Integer.parseInt(mr.getParameter("quantity"));
            String previous = mr.getParameter("previous");

            CartEntity cr = null;
            if (imagename == null) {
                cr = new CartEntity(0, uid, bagid, bagname, previous, bagprice, shipping, quantity);
            } else {
                cr = new CartEntity(0, uid, bagid, bagname, imagename, bagprice, shipping, quantity);
            }
            CartDao.insertCartDetails(cr);
//             ArrayList<CartEntity> cle = CartDao.getCartDetails();
//               Gson gson=new Gson();
//               JsonElement element =gson.toJsonTree(cle,new TypeToken<List<CartEntity>>(){}.getType());
//               com.google.gson.JsonArray jsonArray=element.getAsJsonArray();
//               response.setContentType("application/json");
//                              response.getWriter().print(jsonArray);
//            counter++;
//            request.setAttribute("counter",counter);
       HttpSession session=request.getSession(false);
      session.setAttribute("icart", CartDao.getCartDetails());
            response.sendRedirect(contextPath + "/index");

        } else if (request.getRequestURI().equals(contextPath + "/editcartdetails")) {
            String path = request.getServletContext().getRealPath("img");

            MultipartRequest mr = new MultipartRequest(request, path, 5000000, new DefaultFileRenamePolicy());
            int cid = Integer.parseInt(mr.getParameter("cid"));

            int uid = Integer.parseInt(mr.getParameter("uid"));
//            System.out.println(uid);
            int bagid = Integer.parseInt(mr.getParameter("bagId"));
            String bagname = mr.getParameter("BagName");
            String imagename = mr.getFilesystemName("ImageName");
            int bagprice = Integer.parseInt(mr.getParameter("price"));
            String shipping = mr.getParameter("Shipping");
            int quantity = Integer.parseInt(mr.getParameter("quantity"));
            String previous = mr.getParameter("previous");

            CartEntity cr = null;
            if (imagename == null) {
                cr = new CartEntity(cid, uid, bagid, bagname, previous, bagprice, shipping, quantity);
            } else {
                cr = new CartEntity(cid, uid, bagid, bagname, imagename, bagprice, shipping, quantity);
                CartDao.editCartDetails(cr);
            }
            response.sendRedirect(contextPath+"/index");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
