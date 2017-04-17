<%-- 
    Document   : AddTeam
    Created on : Feb 24, 2017, 12:43:08 PM
    Author     : prjro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Team</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                                    <i class="fa fa-dashboard"></i> Dashboard/Add Team
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">

                            <form action="${pageContext.request.contextPath}/saveteam" method="POST" enctype="multipart/form-data">

                             
                                <div class="form-group">
                                    <label>Team_Member_Image</label>
                                

                                    <input type="file" name="Team_Member_Image" value="">
                                </div>
                              

                           <div class="form-group">
                                    <label>Team_Title</label>
                                    <input class="form-control"  name="Team_Title" value="">
                                </div>

                                <div class="form-group">


                                    <label>Team_Member_Job</label>
                                    <input class="form-control" name="Team_Member_Job" value="">

                                </div>
                                   <div class="form-group">


                                    <label>Parallax1_Blockquote</label>
                                    <input class="form-control" name="Parallax1_Blockquote" value="">

                                </div>
<!--                                    <div class="form-group">

                                    <label>Parallax1_Description</label>
                                    <input class="form-control" name="Parallax1_Description" value="">

                                </div>-->
                       <div class="form-group">


                                    <label>Parallax1_Description</label>
                              <textarea class="form-control" rows="5"  name="Parallax1_Description"></textarea>
                                </div>
                                 <div class="form-group">

                                    <label>Parallax2_Blockquote</label>
                                    <input class="form-control" name="Parallax2_Blockquote" value="">

                                </div>
<!--                                 <div class="form-group">

                                    <label>Parallax2_Description</label>
                                    <input class="form-control" name="Parallax2_Description" value="">

                                </div>-->
<div class="form-group">


                                    <label>Parallax2_Description</label>
                              <textarea class="form-control" rows="5"  name="Parallax2_Description"></textarea>
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
        </div>
        
    </body>
</html>
