<%-- 
    Document   : EditPageInformation
    Created on : Nov 29, 2016, 10:22:13 PM
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

        <title>Edit Team Information</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                                   Team <small> Overview</small>
                                </h1>
                                <ol class="breadcrumb">
                                    <li class="active">
                                        <i class="fa fa-dashboard"></i> Dashboard/ Edit Team Information
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">

                                <form action="${pageContext.request.contextPath}/editteamdetails" method="POST" enctype="multipart/form-data">
                                <c:forEach items="${eteam}" var="ed">
                                     <div class="form-group">
                                    <label>Team_Id</label>
                                    <input class="form-control"  name="Team_Id" value="${ed.tid}">
                                </div>
                                     <div class="form-group">
                          <img src="img/${ed.team_Member_Image}" alt="image">

                                    <label>Team_Member_Image</label>${ed.team_Member_Image}
                                
                                    <img src="img/${ed.team_Member_Image}" alt="img">
                                    <input type="file" name="Team_Member_Image" value="${ed.team_Member_Image}">
                                </div>
                              

                           <div class="form-group">
                                    <label>Team_Title</label>
                                    <input class="form-control"  name="Team_Title" value="${ed.team_Title}">
                                </div>

                                <div class="form-group">


                                    <label>Team_Member_Job</label>
                                    <input class="form-control" name="Team_Member_Job" value="${ed.team_Member_Job}">

                                </div>
                                   <div class="form-group">


                                    <label>Parallax1_Blockquote</label>
                                    <input class="form-control" name="Parallax1_Blockquote" value="${ed.parallax1_Blockquote}">

                                </div>

 <div class="form-group">


                                    <label>Parallax1_Description</label>
                              <textarea class="form-control" rows="5"  name="Parallax1_Description">${ed.parallax1_Description}</textarea>
                                </div>
                                 <div class="form-group">

                                    <label>Parallax2_Blockquote</label>
                                    <input class="form-control" name="Parallax2_Blockquote" value="${ed.parallax2_Blockquote}">

                                </div>

                                <div class="form-group">


                                    <label>Parallax2_Description</label>
                              <textarea class="form-control" rows="5"  name="Parallax2_Description">${ed.parallax2_Description}</textarea>
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
