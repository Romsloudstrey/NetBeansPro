<%-- 
    Document   : DisplayAbout
    Created on : Feb 21, 2017, 7:19:14 PM
    Author     : prjro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Display About</title>

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
                                        <i class="fa fa-dashboard"></i> Dashboard/ Display About
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
                  
                    <h2>About Details</h2>
                    <div class="table-responsive">
                        <table class="table table-hover table-striped" id="mytable">
                            <thead>
                                <tr>
                                    <th>Serial Number</th>
                                    <th>About Id</th>
                                    <th>Services Image</th>
                                    <th>Services Title</th>
                                    <th>Services Description</th>
                                    <th>Testimonial Description</th>
                                    <th>Testimonial Author Name</th>
                                    <th>About Header</th>
                                    <th>About Description</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${about}" var="ab" varStatus="counter">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${ab.abe}</td>
                                        <td>${ab.services_image}</td>
                                        <td>${ab.services_title}</td>
                                        <td>${ab.services_description}</td>
                                        <td>${ab.testimonial_description}</td>
                                        <td>${ab.testimonial_author_name}</td>
                                         <td>${ab.about_header}</td>
                                         <td>${ab.about_description}</td>


                                        <td>
                                            <a href="${pageContext.request.contextPath}/deleteabout/?delid=${ab.abe}"><button type="button" class="btn btn-xs btn-danger">Delete</button></a><br/><br/>
                                            <a href="${pageContext.request.contextPath}/editabout/?eid=${ab.abe}"><button type="button" class="btn btn-xs btn-primary">Edit</button></a>
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
