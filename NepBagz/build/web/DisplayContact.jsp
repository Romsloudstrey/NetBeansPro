<%-- 
    Document   : DisplayContact
    Created on : Feb 24, 2017, 7:58:00 PM
    Author     : prjro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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

        <title>Display Contact</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">        
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
                                        <i class="fa fa-dashboard"></i> Dashboard/ Display Contact                                   </li>
                                </ol>
                            </div>
                        </div>

                        <div class="col-lg-12">
                            <h2>Cart Details</h2>
                            <div class="table-responsive">
                                <table class="table table-hover table-striped" id="mytable">
                                    <thead>
                                        <tr>
                                            <th>Serial Number</th>
                                            <th>Contact_Id</th>
                                            <th>contactUs_title</th>
                                           <th>contactUs_Description</th>

                                            <th>field1_Name</th>
                                            <th>field2_Name</th>
                                            <th>field3_Name</th>
                                         <th>field4_Name</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${con}" var="co" varStatus="counter">
                                        <tr>
                                            <td>${counter.count}</td>
                                            <td>${co.conid}</td>
                                            <td>${co.contactUs_title}</td>
                                            <td>${co.contact_Description}</td>
                                            <td>${co.field1_Name}</td>
                                            <td>${co.field2_Name}</td>
                                             <td>${co.field3_Name}</td>
                                            <td>${co.field4_Name}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/deletecontact/?delid=${co.conid}"><button type="button" class="btn btn-xs btn-danger">Delete</button></a><br/><br/>
                                                <a href="${pageContext.request.contextPath}/editcontact/?eid=${co.conid}"><button type="button" class="btn btn-xs btn-primary">Edit</button></a>
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

                    </script>    </body>
</html>
