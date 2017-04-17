<%-- 
    Document   : DisplayTeam
    Created on : Feb 24, 2017, 3:32:49 PM
    Author     : prjro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Display Team</title>

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
                                   Team <small> Overview</small>
                                </h1>
                                <ol class="breadcrumb">
                                    <li class="active">
                                        <i class="fa fa-dashboard"></i> Dashboard/ Display Team
                                    </li>
                                </ol>
                            </div>
                        </div>

                        <div class="col-lg-12">
                            <h2>Team Details</h2>
                            <div class="table-responsive">
                                <table class="table table-hover table-striped" id="mytable">
                                    <thead>
                                        <tr>
                                            <th>Serial Number</th>
                                           <th>Team_Id</th>

                                            <th>Team_Member_Image</th>
                                            <th>Team_Title</th>
                                            <th>Team_Member_Job</th>
                                            <th>Parallax1_Blockquote</th>
                                            <th>Parallax1_Description</th>
                                            <th>Parallax2_Blockquote</th>
                                           <th>Parallax2_Description</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${team}" var="t" varStatus="counter">
                                        <tr>
                                            <td>${counter.count}</td>
                                            <td>${t.tid}</td>
                                            <td>${t.team_Member_Image}</td>
                                            <td>${t.team_Title}</td>
                                            <td>${t.team_Member_Job}</td>
                                             <td>${t.parallax1_Blockquote}</td>
                                            <td>${t.parallax1_Description}</td>
                                            <td>${t.parallax2_Blockquote}</td>
                                            <td>${t.parallax2_Description}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/deleteteam/?delid=${t.tid}"><button type="button" class="btn btn-xs btn-danger">Delete</button></a><br/><br/>
                                                <a href="${pageContext.request.contextPath}/editteam/?eid=${t.tid}"><button type="button" class="btn btn-xs btn-primary">Edit</button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $("#mytable").DataTable();
                        });

                    </script>
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
