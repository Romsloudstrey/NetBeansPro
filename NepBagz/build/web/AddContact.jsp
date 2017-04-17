<%-- 
    Document   : AddContact
    Created on : Feb 24, 2017, 6:42:41 PM
    Author     : prjro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add  Contact</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
     <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                                    <i class="fa fa-dashboard"></i> Dashboard/ Add Bags
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">

                            <form role="form"  action="${pageContext.request.contextPath}/savecontact" method="POST" >

                                <div class="form-group">
                                    <label>ContactUs_title</label>
                                    <input class="form-control"  name="ContactUs_title"  value="">
                                </div>
                              
                              <div class="form-group">


                                    <label>Contact_Description</label>
                              <textarea class="form-control" rows="5"  name="Contact_Description"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Field1_Name</label>
                                    <input class="form-control"  name="Field1_Name" value="">
                                </div>
                                <div class="form-group">
                                    <label>Field2_Name</label>
                                    <input class="form-control"   name="Field2_Name" value="">
                                </div>
                                <div class="form-group">
                                    <label>Field3_Name</label>
                                    <input class="form-control"  name="Field3_Name" value="">
                                </div>
                                <div class="form-group">
                                    <label>Field4_Name</label>
                                    <input class="form-control"  name="Field4_Name" value="">
                                </div>
                                
                                <button type="submit" class="btn btn-success">Submit Button</button>
                                <button type="reset" class="btn btn-success">Reset Button</button>

                            </form>

                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->
        </div>

        <!-- jQuery -->

        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="  js/bootstrap.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/boot.jtrap.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript"src="js/jquery-ui.js"></script>
        <!-- Morris Charts JavaScript -->
        <script src="js/plugins/morris/raphael.min.js"></script>
        <script src="js/plugins/morris/morris.min.js"></script>
        <script src="js/plugins/morris/morris-data.js"></script>
        
    </body>
</html>
