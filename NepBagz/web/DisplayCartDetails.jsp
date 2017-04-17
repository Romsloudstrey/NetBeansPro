<%-- 
    Document   : DisplayPages
    Created on : Nov 29, 2016, 3:43:57 PM
    Author     : myhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Display Carts</title>

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
                                        <i class="fa fa-dashboard"></i> Dashboard/ Display Bags
                                    </li>
                                </ol>
                            </div>
                        </div>

                        <div class="col-lg-12">
                            <h2>Bags Details</h2>
                            <div class="table-responsive">
                                <table class="table table-hover table-striped" id="mytable">
                                    <thead>
                                        <tr>
                                            <th>Serial Number</th>
                                            <th>Bag Id</th>



                                            <th>Bag Name</th>
                                            <th>Image</th>
                                            <th>Quantity</th>

                                            <th>Bag Price</th>


                                            <th>Action</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${cartdisplay}" var="cd" varStatus="counter">
                                        <tr>
                                            <td>${counter.count}</td>
                                            <td>${cd.bagId}</td>

                                            <td>${cd.bagName}</td>

                                            <td><img src="${pageContext.request.contextPath}/img/${cd.imageName}" style="height:40px;width:40px"/></td>
                                            <td>     <div class="form-group">
                                                    <select   class="form-control"   id="quantity" name="quantity" style="background: white">

                                                        <option value="0">--Select quantity--</option>

                                                        <option value="1" <c:if test="${cd.quantity==1}"> selected</c:if>>1</option>
                                                        <option value="2" <c:if test="${cd.quantity==2}"> selected</c:if>>2</option>
                                                        <option value="3" <c:if test="${cd.quantity==3}"> selected</c:if>>3</option>
                                                        <option value="4" <c:if test="${cd.quantity==4}"> selected</c:if>>4</option>
                                                        <option value="5" <c:if test="${cd.quantity==5}"> selected</c:if>>5</option>


                                                        </select>
                                                    </div></td>
                                                <td>${cd.bagPrice}</td>

                                            <td>
                                            <td><a href="CartController?action=deletecart&&delid=${cd.cid}"><button type="button" class="close" data-dismiss="modal">&times;</button></a>
                                            </td>
                                              <td><a href="CartController?action=editcart"><button type="button" class="btn-group bg-success">Update</button></a>
                                                            </td>

                                            
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
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
    <script>
        $(document).ready(function () {
            $("#mytable").DataTable();
        });

    </script>

</body>

</html>
