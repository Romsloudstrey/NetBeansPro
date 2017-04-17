<%-- 
    Document   : EditPurchaseDetails
    Created on : Dec 20, 2016, 11:50:51 AM
    Author     : myhp
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

        <title>Edit Purchase Information</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

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
                                        <i class="fa fa-dashboard"></i> Dashboard/ Edit Purchase Information
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">

                                <form action="BuyController?action=editedPurchaseInformation" method="POST">
                                <c:forEach items="${purchasedetails}" var="pc">
                                    <div class="form-group">
                                        <label>Purchase Id:</label>${pc.pid}
                                        <input type="hidden" name="pid" value="${pc.pid}" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label>Buyer Name</label>
                                        <input class="form-control" type="text" name="name" value="${pc.buyerName}">
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label><br/>
                                        <input type="text" name="email" value="${pc.email}" readonly>
                                    </div>

                                    <div class="form-group">
                                        <label>Phone Number</label>
                                        <input type="text" name="phNum" value="${pc.phNum}" class="form-control" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label>Bag Id:</label>${pc.bgid}
                                        <input type="hidden" name="bgid" value="${pc.bgid}" class="form-control">
                                    </div>
                                    <input type="hidden" id="price" value="${pc.quantity}">
                                    <div class="form-group">
                                        <label>Quantity</label>
                                        <select class="form-control" name="quantity" value="${pc.quantity}">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Total Price</label><br/>
                                        <input type="text" name="totalprice" value="${pc.totalAmount}">
                                    </div>

                                    <div class="form-group">
                                        <label>Purchased Date</label>${pc.purchasedDate}
                                        <input type="hidden" name="purchasedDate" value="${pc.purchasedDate}" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Purchased Status</label>
                                        <select class="form-control" name="status" value="${pc.status}">
                                            <option value="delivered">Delivered</option>
                                            <option value="shipping">Shipping</option>
                                            <option value="cancelled"> Canceled </option>
                                        </select>
                                    </div>
                                </c:forEach>
                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>

                            </form>

                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- jQuery -->
            <script src="js/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="js/bootstrap.min.js"></script>

            <!-- Morris Charts JavaScript -->
            <script src="js/plugins/morris/raphael.min.js"></script>
            <script src="js/plugins/morris/morris.min.js"></script>
            <script src="js/plugins/morris/morris-data.js"></script>

    </body>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <!--<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>-->
    <script type="text/javascript" src="js/calculate.js"></script>

</html>
