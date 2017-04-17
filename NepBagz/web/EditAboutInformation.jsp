<%-- 
    Document   : EditBags
    Created on : Dec 6, 2016, 12:33:41 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="utf-8">


        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Edit Page Information</title>

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
                                    Panel <small> Overview</small>
                                </h1>
                                <ol class="breadcrumb">
                                    <li class="active">
                                        <i class="fa fa-dashboard"></i> Dashboard/ Edit About Information
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">

                                <form role="form" name="editBags" action="${pageContext.request.contextPath}/editaboutdetails" method="POST" enctype="multipart/form-data">
                                <c:forEach items="${aboutdetails}" var="ad">
                                    <div class="form-group">
                                        <label>About Id:</label>${ad.abe}
                                        <input type="hidden" name="abe" value="${ad.abe}" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Services_Image</label>
                                        <img src="img/${ad.services_image}" alt="images"><br/>

                                        <input type="file" value="${ad.services_image}" name="Services_Image">${ad.services_image}
                                    </div>


                                    <div class="form-group">
                                        <label>Services_Title</label>
                                        <input class="form-control"  value="${ad.services_title}" name="Services_Title">
                                    </div>


                                    <div>
                                        <label>Services_Description</label>
                                        <textarea class="form-control" rows="5"  name="Services_Description">${ad.services_description}</textarea>
                                    </div>

                                    <div>
                                        <label>Testimonial_Description</label>
                                        <textarea class="form-control" rows="5"  name="Testimonial_Description">${ad.testimonial_description}</textarea>
                                    </div>
                                    <div class="form-group">

                                        <label>Testimonial_author_name</label>
                                        <input class="form-control" value="${ad.testimonial_author_name}" name="Testimonial_author_name">

                                    </div>
                                    <div class="form-group">

                                        <label>About_header</label>
                                        <input class="form-control" value="${ad.about_header}" name="About_header">

                                    </div>

                                    <div>
                                        <label>About_description</label>
                                        <textarea class="form-control" rows="5"  name="About_description">${ad.about_description}</textarea>
                                    </div>

                                </c:forEach>
                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>

                            </form>

                        </div>
                        <!-- /.row -->
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="js/plugins/morris/raphael.min.js"></script>
        <script src="js/plugins/morris/morris.min.js"></script>
        <script src="js/plugins/morris/morris-data.js"></script>
    </body>
</html>
