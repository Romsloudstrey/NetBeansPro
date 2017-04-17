<%-- 
    Document   : LoginPage
    Created on : Nov 22, 2016, 11:19:54 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <title>SB Admin - Bootstrap Admin Template</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <title>Login Page</title>
        <style type="text/css">

            .panel-success {
                width: 360px;
                padding: 4% 0 2% 0;
                margin: 12% auto;
            }
            .btn-success{
                width: 100%;
            }
            .form-group{
                color: #658B79;
            }
            #backtoblog{
                color:#2b542c;
            }


        </style>
        <c:if test="username!=${username.username} && ">
        <div class="alert alert-warning alert-dismissible fade in" role="alert"> 
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span></button> 
            <strong>Invalid username and password</strong> 
        </div>
        </c:if>
        <script src='https://www.google.com/recaptcha/api.js'></script>
    </head>
    <body style="background-color: #658B79;">

    <body style ="background-color:#658B79;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <p style="color: red;">${ermsg}</p>
                    <c:remove var="ermsg" scope="session" /> 
                </h3>
            </div>
            <div class="panel-heading">
                <h3 class="panel-title">Login</h3>
            </div>
            <div class="panel-body">
                <div class="login-page">
                    <div class="login-form">
                        <form action="${pageContext.request.contextPath}/admin-login" method="POST">

                            <div class="form-group">
                                <label>Username</label>
                                <input class="form-control" name="username" placeholder="Username" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" input type="password" name="password" placeholder="Password" required="required"/>
                            </div>
                            <div class="g-recaptcha" data-sitekey="6LdtfA4UAAAAAOwJ4iyUfYT0TrpG_sZkcnMJoGjT"></div>
                            <input type="submit" class="btn btn-lg btn-success" value="Login" >
                        </form>
                        <div class="container-fluid  createaccount text-center"style="margin-top:15px;">
                            <a href="${pageContext.request.contextPath}/register" style="color:#449D44;">Create account</a>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </div>





</body>
</html>
