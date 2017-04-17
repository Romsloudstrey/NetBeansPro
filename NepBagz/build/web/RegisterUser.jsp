<%-- 
    Document   : RegisterUser
    Created on : Dec 13, 2016, 12:01:23 PM
    Author     : myhp
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

        <title>User Registration Page</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <title>User Registration Page</title>
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
    </head>
    <body style="background-color: #658B79;">

    <body style ="background-color:#658B79;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">Provide Following details</h3>
            </div>
            <div class="panel-body">
                <div class="login-page">
                    <div class="login-form">
                        <form action="UserController?action=register&&r=2" method="POST">

                            <div class="form-group">
                                <label>Username</label>
                                <input class="form-control" name="username" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" input type="password" name="password" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label>Conform-Password</label>
                                <input class="form-control" input type="password" name="confpassword" placeholder="Re-enter Password">
                            </div>
<!--                            <div class="form-group">
                                <label>Role</label>
                                <select class="form-control" name="role">
                                    <option value="role"> User</option>
                                    <option value="admin"> Admin</option>
                                </select>
                            </div>-->
                            <input type="submit" class="btn btn-lg btn-success" value="Register" >
                        </form>
                    </div>
                </div>


            </div>
        </div>

    </div>





</body>
</html>
