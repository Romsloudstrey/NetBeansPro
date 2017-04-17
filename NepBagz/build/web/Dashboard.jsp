/* global result */

<%-- 
    Document   : Dashboard
    Created on : Nov 30, 2016, 11:52:18 AM
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

        <title>Dashboard</title>

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
                                    <i class="fa fa-dashboard"></i> Dashboard
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row">
                        <!--                        begin of search form for pages-->
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Search Page</h3>
                                </div>
                                <div class="panel-body">
                                    <div id="morris-donut-chart"></div>
                                    <div class="text-right">
                                        <div class="col-lg-6">

                                            <form>

                                                <div class="form-group">
                                                    <label>Enter Page Name</label>
                                                    <input class="form-control" type="text" id="pgnm">
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--                        end of search form for pages-->
                        <!--                        form for search bags-->
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Search Bags</h3>
                                </div>
                                <div class="panel-body">
                                    <div id="morris-donut-chart"></div>
                                    <div class="text-right">
                                        <div class="col-lg-6">

                                            <form>

                                                <div class="form-group">
                                                    <label>Enter Bag Name</label>
                                                    <input class="form-control" type="text" id="bgnm">
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end of search form for bags-->
                        <!--                        form for search slider-->
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Search Slider</h3>
                                </div>
                                <div class="panel-body">
                                    <div id="morris-donut-chart"></div>
                                    <div class="text-right">
                                        <div class="col-lg-6">

                                            <form>

                                                <div class="form-group">
                                                    <label>Enter Slider Name</label>
                                                    <input class="form-control" type="text" id="slnm">
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end of search form for slider-->

                    </div>

                    <!-- /.row -->
                    <!--                table for search page-->
                    <div class="col-lg-6" id="pagetbl">
                        <h2>Page Details</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped" id="searchvalues">
                                <thead>
                                    <tr>
                                        <th>Page Id</th>
                                        <th>Page Name</th>
                                        <th>Page Description</th>
                                        <th>Image</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <!--end of table for search page-->     
                    <!--                table for search bags-->
                    <div class="col-lg-6" id="bagtbl">
                        <h2>Bag Details</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped" id="bagvalues">
                                <thead>
                                    <tr>
                                        <th>Bag Id</th>
                                        <th>Bag Name</th>
                                        <th>Image</th>
                                        <th>Price</th>
                                        <th>Brand</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <!--end of table for search bags-->     
                    <!--                table for search slider-->
                    <div class="col-lg-6" id="slidertbl">
                        <h2>Slider Details</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped" id="slidervalues">
                                <thead>
                                    <tr>
                                        <th>Slider Id</th>
                                        <th>Slider Name</th>
                                        <th>Location</th>
                                        <th>Image</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <!--end of table for search slider-->     

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
    <!--        search-->  
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <!--        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>-->
    <script type="text/javascript" src="js/search-pages.js"></script>
    <script type="text/javascript" src="js/search-bags.js"></script>
    <script type="text/javascript" src="js/search-slider.js"></script>
    <!--        end of search-->

</html>