<%-- 
    Document   : AddAbout
    Created on : Feb 21, 2017, 12:48:41 PM
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

        <title>Add About</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">
        <link href="css/datepicker.css" rel="stylesheet">
        <link href="css/datepicker.min.css" rel="stylesheet">




        <!-- Custom Fonts -->
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
                                        <i class="fa fa-dashboard"></i> Dashboard/AddAbout
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">

                                <form action="${pageContext.request.contextPath}/saveabout" method="POST" enctype="multipart/form-data">


                                <div style="margin-bottom: 25px" class="form-group">
                                    <label>Services_Image</label>

                                    <input type="file" name="Services_Image">
                                </div>


                                <div  class="form-group">

                                    <label>Services_Title</label>

                                    <input class="form-control"  name="Services_Title" value="">
                                </div>


                                <div>
                                    <label>Services_Description</label>
                                    <textarea class="form-control" rows="8"  name="Services_Description" value=""></textarea>
                                </div>


                                <div>
                                    <label>Testimonial_Description</label>
                                    <textarea class="form-control" rows="8"  name="Testimonial_Description" value=""></textarea>
                                </div>
                                <div  class="form-group">

                                    <label>Testimonial_author_name</label>

                                    <input class="form-control"  name="Testimonial_author_name" value="">
                                </div>

                                <div  class="form-group">

                                    <label>About_header</label>

                                    <input class="form-control"  name="About_header" value="">
                                </div>
                                <div>
                                    <label>About_description</label>
                                    <textarea class="form-control" rows="8"  name="About_description" value=""></textarea>
                                </div>

                                <button   type="submit"  class="btn btn-success" >Submit Button</button>
                                <button type="reset" class="btn btn-success">Reset Button</button>

                            </form>

                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="  js/bootstrap.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/boot.jtrap.min.js"></script>



    </body>
</html>
