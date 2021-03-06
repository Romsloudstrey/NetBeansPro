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

        <title>Display Pages</title>

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
                                        <i class="fa fa-dashboard"></i> Dashboard/ Display Pages
                                    </li>
                                </ol>
                            </div>
                        </div>

                        <div class="col-lg-12">
                        <% String msg=(String) request.getSession().getAttribute("msg"); %>
                        <script type="text/javascript">
                                var message="<%=msg%>";
                                if(message.length>5){
                                    window.alert(message);
                                }
                        </script>
                        <c:remove var="msg" scope="session" />
                  
                    <h2>Page Details</h2>
                    <div class="table-responsive">
                        <table class="table table-hover table-striped" id="mytable">
                            <thead>
                                <tr>
                                    <th>Serial Number</th>
                                    <th>Page Id</th>
                                    <th>Page Name</th>
                                    <th>Image</th>
                                    <th>Page Description</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${page}" var="p" varStatus="counter">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${p.pageId}</td>
                                        <td>${p.pageName}</td>
                                        <td>${p.imgName}</td>
                                        <td>${p.pageDescription}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/deletepages/?delid=${p.pageId}"><button type="button" class="btn btn-xs btn-danger">Delete</button></a><br/><br/>
                                            <a href="${pageContext.request.contextPath}/editpages/?eid=${p.pageId}"><button type="button" class="btn btn-xs btn-primary">Edit</button></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--writing script for datatable -->

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
<script type="text/javascript">
                    var msg = ${param.message};
                    if (msg !== null) {
                        window.alert(msg);
                    }
</script>
</body>

</html>
