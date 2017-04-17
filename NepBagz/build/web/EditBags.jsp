<%-- 
    Document   : EditBags
    Created on : Dec 6, 2016, 12:33:41 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Edit Bag Information</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <div id="wrapper">

            <!-- Navigation -->
            <jsp:include page="TopBarMenus.jsp"></jsp:include>

                <div id="page-wrapper">

                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    Panel <small> Overview</small>
                                </h1>
                                <ol class="breadcrumb">
                                    <li class="active">
                                        <i class="fa fa-dashboard"></i> Dashboard/ Edit Page Information
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">

                                <form role="form" name="editBags" action="${pageContext.request.contextPath}/editbagsinformation" method="POST" enctype="multipart/form-data">
                                <c:forEach items="${EditBagsDetail}" var="bd">
                                <div class="form-group">
                                    <label>Bag Id</label>${bd.bagId}
                                    <input type="hidden" name="bagId" value="${bd.bagId}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Portfolio_Name</label>
                                    <input class="form-control"  name="Portfolio_Name" value="${bd.portfolio_Name}">
                                </div>
                                <div>
                                    <label>Portfolio_Description</label>
                                    <textarea class="form-control" rows="5"  name="Portfolio_Description">${bd.portfolio_Description}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Bag Name</label>

                                    <input class="form-control" type="text" name="BagName" value="${bd.bagName}">
                                </div>
                                <div class="form-group">
                                    <label>Image input</label>
                                    <img src="img/${bd.imageName}" alt="image">
                                    <input type="file" name="ImageName">${bd.imageName}
                                    <input type="hidden" name="previous"  value="${bd.imageName}">${bd.imageName}

                                </div>

                                <div class="form-group">
                                    <label> Bag Date</label>
                                    <input class="form-control" type="text" name="BagDate" value="${bd.date}">
                                </div>

                                <div class="form-group">
                                    <label> Bag Price</label>
                                    <input class="form-control" type="text" name="BagPrice" value="${bd.bagPrice}">
                                </div>
                                <div class="form-group">
                                    <label> Bag Brand</label>
                                    <input class="form-control" type="text" name="BagBrand" value="${bd.bagBrand}">
                                </div>
                           
                                <div class="form-group">
                                    <label>Shipping:</label>
                                    <select   class="form-control"   id="Shipping" name="Shipping">
                                        ${bd.shipping.equals('FREE Delivery')}
                                        ${bd.shipping.equals('Prime')}
                                        <option value="">--Select Shipping--</option>

                                        <option value="FREE Delivery" <c:if test="${bd.shipping.equals('FREE Delivery')}"> selected</c:if> >FREE Delivery</option>
                                        <option value="Prime" <c:if test="${bd.shipping.equals('Prime')}"> selected</c:if>>Prime</option>
                                    </select>
                                </div>


                                <div class="form-group">
                                    <label>Colors:</label>

                                    <label class="checkbox-inline">

                                        <input type="checkbox" name="Colors" value="Red"  <c:if test="${bd.color.contains('Red')}">checked </c:if>>Red
                                        </label>
                                        <label class="checkbox-inline">

                                            <input type="checkbox" name="Colors" value="Black"<c:if test="${bd.color.contains('Black')}">checked </c:if> >Black
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="Colors" value="White"<c:if test="${bd.color.contains('White')}">checked </c:if>>White
                                        </label>

                                    </div>

                                    <div class="form-group">
                                        <label>Seller Name</label>
                                        <input class="form-control"  name="sellername" value="${bd.sellername}">
                                </div>
                                <div class="form-group">
                                    <label>Seller Contact Number</label>
                                    <input class="form-control"  name="sellernum" value="${bd.sellernum}">
                                </div>
                                <div class="form-group">
                                    <label>Seller Email</label>
                                    <input class="form-control"  name="selleremail" value="${bd.selleremail}">
                                </div>
                                <div class="form-group">
                                    <label>Seller Address</label>
                                    <input class="form-control"  name="selleraddress" value="${bd.selleraddress}">
                                </div>
                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>

                            </form>
                                </c:forEach>

                        </div>
                        <!-- /.row -->
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
    </body>
</html>
