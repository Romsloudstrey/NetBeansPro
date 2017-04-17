<%-- 
    Document   : ContactEditDetail
    Created on : Feb 24, 2017, 8:57:37 PM
    Author     : prjro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Edit Contact Information</title>

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
                                   Team <small> Overview</small>
                                </h1>
                                <ol class="breadcrumb">
                                    <li class="active">
                                        <i class="fa fa-dashboard"></i> Dashboard/ Edit Contact Information
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">

                                <form action="${pageContext.request.contextPath}/editcontactdetails" method="POST">
                                <c:forEach items="${conedit}" var="cond">
                                     <div class="form-group">
                                    <label>Contact_Id</label>
                                    <input class="form-control"  name="Contact_Id"  value="${cond.conid}">
                                </div>
                                    
                                    <div class="form-group">
                                    <label>ContactUs_title</label>
                                    <input class="form-control"  name="ContactUs_title"  value="${cond.contactUs_title}">
                                </div>
                              
                              <div class="form-group">


                                    <label>Contact_Description</label>
                              <textarea class="form-control" rows="5"  name="Contact_Description">${cond.contact_Description}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Field1_Name</label>
                                    <input class="form-control"  name="Field1_Name" value="${cond.field1_Name}">
                                </div>
                                <div class="form-group">
                                    <label>Field2_Name</label>
                                    <input class="form-control"   name="Field2_Name" value="${cond.field2_Name}">
                                </div>
                                <div class="form-group">
                                    <label>Field3_Name</label>
                                    <input class="form-control"  name="Field3_Name" value="${cond.field3_Name}">
                                </div>
                                <div class="form-group">
                                    <label>Field4_Name</label>
                                    <input class="form-control"  name="Field4_Name" value="${cond.field4_Name}">
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
</html>
