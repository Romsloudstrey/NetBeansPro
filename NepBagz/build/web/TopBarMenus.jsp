<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
      
    </div>
    <!-- Top Menu Items -->
    <a class="navbar-brand">NepBagz Admin Panel</a>
    <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope" style="margin-right: 4px;"></i>Messages<span class="label label-success" style="margin-left: 4px;">2</span></a>
                    <ul class="dropdown-menu message-dropdown">
                       <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <c:forEach items="${msg}" var="m">
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>${m.name}</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>${m.subject}</p>
                                    </div>
                                    </c:forEach>
                                </div>
                            </a>
                        </li>
                         <li class="message-footer">
                            <a href="${pageContext.request.contextPath}/displaycontactmessage">Read All New Messages</a>
                        </li>
                    
                    </ul>
<!--        <li>

            <a  href="SendMessageController?action=display"><i class="fa fa-bell" ></i> <span>Notifications</span><span class="label label-success" style="position: absolute;
                                                                        top: 2px;right: -5px;">2</span>
            </a>
        </li>
              
        <li>
            <a href="LoginController?action=logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
        </li>-->
    
            
            </li>
              <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Welcome ${loggeduser.username} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                       
                       
                        <li>
                            <a href="${pageContext.request.contextPath}/admin-logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>

    </ul>

    <!--            </nav>-->
    <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
    <jsp:include page="SideMenus.jsp"></jsp:include>
    <!-- /.navbar-collapse -->
</nav>