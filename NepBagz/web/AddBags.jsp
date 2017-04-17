<%-- 
    Document   : AddPages
    Created on : Nov 29, 2016, 3:37:21 PM
    Author     : myhp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Bags</title>

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



    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
    <![endif]-->


    <head>







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

                            <form role="form"  action="${pageContext.request.contextPath}/savebags" method="POST" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Portfolio_Name</label>
                                    <input class="form-control"  name="Portfolio_Name" value="">
                                </div>
                                <div>
                                    <label>Portfolio_Description</label>
                                    <textarea class="form-control" rows="5"  name="Portfolio_Description"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Bag Name</label>
                                    <input class="form-control"  name="BagName" value="">
                                </div>
                                <div class="form-group">
                                    <label>Image Input</label>
                                    <input type="file" name="ImageName">
                                </div>
                                <div class="bootstrap-iso">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="form-group"> <!-- Date input -->
                                                <label class="control-label" for="date">Date</label>
                                                <input class="form-control" id="date" name="date" placeholder="YYYY/MM/DD" type="text"/>
                                            </div>
                                        </div>    
                                    </div>
                                </div>



                                <div class="form-group">


                                    <label>Bag Price</label>
                                    <input class="form-control" name="BagPrice" value="">

                                </div>
                                <div class="form-group">
                                    <label>Bag Brand</label>
                                    <input class="form-control" name="BagBrand" value="">
                                </div>
                                <div class="form-group">
                                    <label>Shipping</label>
                                    <select class="form-control" id="Shipping" name="Shipping">
                                        <option value="">--Select Shipping--</option>

                                        <option value="FREE Delivery">FREE Delivery</option>
                                        <option value="Prime">Prime</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Colors</label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="Colors" value="Red">Red
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="Colors" value="Black">Black
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="Colors" value="White">White
                                    </label>
                                </div>


                                <div class="form-group">
                                    <label>Seller Name</label>
                                    <input class="form-control"  name="sellername" value="">
                                </div>
                                <div class="form-group">
                                    <label>Seller Contact Number</label>
                                    <input class="form-control"  name="sellernum" value="">
                                </div>
                                <div class="form-group">
                                    <label>Seller Email</label>
                                    <input class="form-control"  name="selleremail" value="">
                                </div>
                                <div class="form-group">
                                    <label>Seller Address</label>
                                    <input class="form-control"  name="selleraddress" value="">
                                </div>
                                <div>
                                    <button type="submit" id="button" class="btn btn-success">Submit Button</button>

                                    <button type="reset" class="btn btn-success">Reset Button</button>
                                </div>
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
        <script>
            $(document).ready(function () {
                var date_input = $('input[name="date"]'); //our date input has the name "date"
                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                var options = {
                    format: 'yyyy/mm/dd',
                    container: container,
                    todayHighlight: true,
                    autoclose: true
                };
                date_input.datepicker(options);
            });
        </script>


    </body>

</html>