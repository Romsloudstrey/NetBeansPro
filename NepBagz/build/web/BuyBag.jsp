<%-- 
    Document   : BuyBag
    Created on : Dec 19, 2016, 8:14:56 PM
    Author     : myhp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Buy Bag</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link href="${pageContext.request.contextPath}/css/datepicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/datepicker.min.css" rel="stylesheet">
        <!-- skin -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/skin/default.css">
        <title>Buy Bag</title>
        <style type="text/css">
            input[type=text]{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                box-sizing: border-box;
                border: none;
                border-bottom: 2px solid #006666;  
                color:#003333;
            }
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
    button{
                margin-top: 20px;
                background-color: #003333;
                color: #ffffff;
                width: 200px;
                height: 50px


            }
            button:hover{
                background-color: #ffffff;
                border-color:#003333;
                color: #080808;
            } 
        </style>

    </head>
    <body style="background-color: #ffffff">
        <%@include file="IndexHeader.jsp" %>
       


        <div class="Buy" id="buy" style="margin-top:200px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">

                            <div class="col-md-6">
                                <form action="BuyController?action=CheckOut" method="POST">
                                <c:forEach items="${EditBagsDetail}" var="bde">
                                 
                                    <img src="${pageContext.request.contextPath}/img/${bde.imageName}" alt="images"  style="height:300px;width:300px" readonly><br/>
                                    <div>
                                        <label>Price: </label>&euro;${bde.bagPrice}
                                        <input class="form-control" type="hidden" id="price" name="price" value="${bde.bagPrice}" readonly>
                                    </div>
                                      <div class="form-group">
                                    <label>Bag Name:</label>${bde.bagName}

                                    <input class="form-control" type="hidden" name="BagName" value="${bde.bagName}" readonly>
                                </div>
                                     <div class="form-group">
                                    <label>Available Colors:</label>

                                    <label class="checkbox-inline">

                                        <input type="checkbox" name="Colors" value="Red"  <c:if test="${bde.color.contains('Red')}">checked </c:if>disabled style="color: #990000;"><strong>Red</strong>
                                        </label>
                                        <label class="checkbox-inline">

                                            <input type="checkbox" name="Colors" value="Black"<c:if test="${bde.color.contains('Black')}">checked </c:if> disabled><strong>Black</strong>
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="Colors" value="White"<c:if test="${bde.color.contains('White')}">checked </c:if>disabled ><strong>White</strong>
                                        </label>

                                    </div><br/><br/>
                                    <div class="form-group">
                                                                      <label>Shipping:</label>
                                        <input class="form-control" type="hidden" id="Shipping" name="Shipping" value="${bde.shipping}" readonly>${bde.shipping}

                                    </div>
                                        
                                              
                                
                                    
                                 

               
                                </c:forEach>

                </form>
                                    <center><button onclick="myFunction()">Check Out >></button></center>                                   

                            </div>


                            
                                           
                            <div class="col-md-6" id="form">
                                  <form action="BuyController?action=CheckOut" method="POST" >
                                <h4 class="heading"><center><strong>Quick </strong> Shopping</center> <span></span></h4>
                                <div class="personal details">
                                    <h3 style="color:#006666;"><strong>Personal Details:</strong></h3>
                                       <c:forEach items="${EditBagsDetail}" var="bde">

                                    <input type="hidden" name="bgid" value="${bde.bagId}" readonly>
                                       </c:forEach>
                                    First Name:<input type="text" name="FirstName" placeholder="FirstName" value=""><br/>
                                    Middle Name:<input type="text" name="MiddleName" placeholder="Middle Name"value=""><br/>
                                    Last Name:<input type="text" name="LastName"placeholder="Last Name" value=""><br/>
                                    Address:<input type="text"name="Address" placeholder="Address" value=""><br/>
                                 Zip Code:<input type="text" name="ZipCode" placeholder="ZipCode" value=""><br/><br/>
                                Email:<input type="text" name="Email"placeholder="Last Name" value=""><br/>
                                
                                 <div class="form-group">
                                    <label>Colors:</label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="Colors" value="Red">Red
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="Colors" value="Black">Black
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="Colors" value="White">White
                                    </label>
                                </div>
                                  <div class="form-group col-xs-6">
                                      <label>Quantity:</label>
                                        <select class="form-control" id="quantity" name="quantity">
                                            <option value="0">--Select Quantity--</option>

                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                    </div>

                                </div><br/><br/>
                                <div class="payment" style="margin-top: 50px;">
                                    <h3 style="color:#006666;">Payment with Debit or Credit card</h3>
                                    <p>We don't share your financial details with merchants.</p>
                                    <div class="form-group col-xs-12">
                                    <label>Country:</label>
                                    <select class="form-control" id="Country" name="Country">
                                        <option value="">--Select Country--</option>

                                        <option value="Nepal">Nepal</option>
                                        <option value="India">India</option>
                                    </select>
                                </div>
                                    <div>
                                        <center> <img src="${pageContext.request.contextPath}/img/visa.jpg" style="width: 50%;" /></center>
                                    </div>
                                </div>
                               
                                   Card Number:<input type="text" name="cardnumber" placeholder="Card Number" value="">
                                                                 
                                   
                                   <div>
                                   
                                   Expires:<input type="text" placeholder="YYYY/MM/DD"  id="date" name="date" value=""/>
                                   </div>
                                   <div>
                                     CSC:<input type="text" placeholder="3-digits" name="csc" value="">
                                   </div>
                                   <br/>
                                <div><center><input type="submit" name="Happy Shopping" value="Happy Shopping!"></center></div>
                                                    </form>

                            </div>

                    </div>

                </div>
            </div>
        </div>

<section id="section-map" class="clearfix">
    <div id="google-map" data-latitude="40.713732" data-longitude="-74.0092704"></div>
</section>

                                        <%@include file="IndexFooter.jsp" %>
        <script type="text/javascript">
           
function myFunction() {
    var x = document.getElementById('form');
    
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}
</script>
    </body>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <!--<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>-->
    <script type="text/javascript" src="js/calculate.js"></script>
       <script>
            $(document).ready(function () {
                var date_input = $('input[name="date"]'); //our date input has the name "date"
                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                var options = {
                    format: 'yyyy/mm/dd',
                    container: container,
                    todayHighlight: true,
                    autoclose: true
                    
                };
                date_input.datepicker(options);
            });
        </script>
         <script src="${pageContext.request.contextPath}/js/boot.jtrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
</html>
