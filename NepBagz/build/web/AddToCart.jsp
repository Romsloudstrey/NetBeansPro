<%-- 
    Document   : AddToCart
    Created on : Feb 27, 2017, 3:30:42 PM
    Author     : prjro
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Add To Cart</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/isotope.css" media="screen" />	
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <!-- skin -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/skin/default.css">
        <style type="text/css">
            /*            input[type=text]{
                            width: 100%;
                            padding: 12px 20px;
                            margin: 8px 0;
                            box-sizing: border-box;
                            border: none;
                            border-bottom: 2px solid #006666;  
                            color:#003333;
                        }*/
            input[type=submit]{
                margin-top: 20px;
                background-color: #003333;
                color: #ffffff;
                width: 200px;
                height: 50px


            }
            input[type=submit]:hover{
                background-color: #ffffff;
                border-color:#003333;
                color: #080808;
            }          
            button[type=button]{
                margin-top: 20px;
                background-color: #003333;
                color: #ffffff;
                width: 200px;
                height: 50px


            }
            button[type=button]:hover{
                background-color: #ffffff;
                border-color:#003333;
                color: #080808;
            } 
        </style>
    </head>
    <body style="background-color: #ffffff">

        <%@include file="IndexHeader.jsp" %>
        <section id="addtocart" class="buy"  style="margin-top:100px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form action="${pageContext.request.contextPath}/savetocart" method="POST" enctype="multipart/form-data">
                            <div class="col-md-6">

                                <div class="form-group">
                                    <input type="hidden" id="uid" name="uid" value="${user.get(0).lid}" class="form-control">
                                </div>
                                <c:forEach items="${EditBagsDetail}" var="b">
                                    <input type="hidden" id="bagId" name="bagId" value="${b.bagId}" class="form-control">
                                    <div class="form-group">    
                                        <img src="${pageContext.request.contextPath}/img/${b.imageName}" id="bagImage" alt="image" style="height:500px;width:500px;">
                                        <input type="hidden" name="ImageName"  value="${b.imageName}">
                                        <input type="hidden" name="previous"  value="${b.imageName}">

<!--                                        <img src="img/portfolio/bags1red.png" alt="redbag" style="height: 150px;width: 150px;margin-top:10px;"/>-->

                                    </div>
                                    <!--                              <div class="otherimage">
                                                                  </div>-->
                                </div>
                                <div class="col-md-6">

                                    <div class="form-group" style="font-family: sans-serif;font-size:40px; margin-top:100px;word-spacing:2px;color:black;">

                                        <input class="form-control" type="hidden" id="bagName" name="BagName" value="${b.bagName}" readonly >${b.bagName}                                    

                                    </div>
                                    <div class="form-group" style="font-size:20px;word-spacing:2px;color:#6699ff; ">

                                        <input class="form-control" type="hidden" id="price" name="price" value="${b.bagPrice}" readonly>&euro;${b.bagPrice}
                                    </div>
                                    <div class="form-group" style="font-size: 20px;color: #6699ff;font-weight:bold">
                                        <input class="form-control" type="hidden" id="Shipping" name="Shipping" value="${b.shipping}" readonly>${b.shipping}

                                    </div>
                                </c:forEach>
                                <div class="form-group" style="background-color: #cccccc;padding: 20px;border-radius:2px; ">
                                    <label>Quantity:</label>
                                    <select class="form-control" id="quantity" name="quantity">
                                        <option value="0">--Select Quantity--</option>

                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                    </select>
                                    <input type="submit" id="addToCart" name="AddToCart" value="AddToCart" style="margin:20px;">
                                    <a href="${pageContext.request.contextPath}/index" style="margin:20px;"><button type="button">Continue Shopping >></button></a>                                  

                                </div>
                            </div>


                        </form>

                    </div>
                </div>
            </div>
        </section>
        
        <a href="#header" class="scrollup"><i class="fa fa-chevron-up"></i></a>	
        <%@include file="IndexFooter.jsp" %>

        <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="js/jquery.isotope.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/fancybox/jquery.fancybox.pack.js"></script>
        <script src="js/skrollr.min.js"></script>		
        <script src="js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="js/jquery.localscroll-1.2.7-min.js"></script>
        <script src="js/stellar.js"></script>
        <script src="js/jquery.appear.js"></script>
        <script src="js/main.js"></script>
        <script src="contactform/contactform.js"></script>
        <script>
        $("#addToCart").on("click",function(){
            var bagId=$("#bagId").val();
            var bagName=$("#bagName").val();
            var bagImage=$("#bagImage").val();
            var price=$("#price").val();
            var quantitiy=$("#quantity").val();
            var shipping=$("#Shipping").val();
            var userId=$("#uid").val();
            var data='bagId='+ encodeURIComponent(bagId)
                     +'&BagName='+ encodeURIComponent(bagName)+
                     '&ImageName='+encodeURIComponent(bagImage)+
                     '&price='+encodeURIComponent(price)+
                     '&Shipping='+encodeURIComponent(shipping)+
                     '&quantity='+encodeURIComponent(quantity)+
                     '&uid='+encodeURIComponent(userId)+;
             alert(data);
                     $.ajax({
                         url: addtocart,
                         TYPE: POST,
                         data: data,
                         success: function(response){          
//                         var cart=$("#cartid").val();
//                         var count =cart+1;
                         alert("Success");
//                         ("#cartid").html("<span class='label label-success' style=margin-left: 10px;height:80px;width:80px;' id='cartid' value="+count+">+count+</span>");
    
                         }
                         error: function(){
                             alert("Failed");
                         }
                     });
        });
        </script>

    </body>
</html>
