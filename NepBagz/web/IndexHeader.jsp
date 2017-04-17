  <section id="header" class="appear"></section>
    <div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="fa fa-bars color-white"></span>
                </button>
                <h1><a class="navbar-brand" href="index.html" data-0="line-height:90px;" data-300="line-height:50px;">NepBagz</a></h1>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                    <c:forEach items="${page}" var="p">
                        <li><a href=""> ${p.pageName}</a></li>
                        </c:forEach>

                    <li><a href="#section-cart" class="section-cart" data-toggle="modal" data-target="#myModal" > <i class="fa fa-shopping-cart"></i>  <span class="hidden-xs">No of Cart Items</span><span class="label label-success" style="margin-left: 10px;height:80px;width:80px;">2</span></a>
                        <div class="modal fade" id="myModal" role="dialog" >
                            <div class="modal-dialog" >

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Your Cart Details</h4>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table table-hover table-striped" id="mytable">
                                            <thead>
                                                <tr>
                                                    <th>Bag Id</th>
                                                    <th>Bag Name</th>

                                                    <th>Bag Image</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${icart}" var="cd" varStatus="counter">
                                                    <tr id="tb">


                                                        <td>${cd.bagId}</td>
                                                        <td>${cd.bagName}</td>
                                                        <td><img src="${pageContext.request.contextPath}/img/${cd.imageName}" alt="image" style="height:50px;width:50px;">
                                                            <input type="hidden" name="ImageName"  value="${cd.imageName}"></td>

                                                        <td>  <select   class="form-control"   id="quantity" name="quantity" style="background: white">

                                                                <option value="0">--Select quantity--</option>

                                                                <option value="1" <c:if test="${cd.quantity==1}"> selected</c:if>>1</option>
                                                                <option value="2" <c:if test="${cd.quantity==2}"> selected</c:if>>2</option>
                                                                <option value="3" <c:if test="${cd.quantity==3}"> selected</c:if>>3</option>
                                                                <option value="4" <c:if test="${cd.quantity==4}"> selected</c:if>>4</option>
                                                                <option value="5" <c:if test="${cd.quantity==5}"> selected</c:if>>5</option>


                                                                </select></td>
                                                            <td>&euro;${cd.bagPrice}</td>
                                                            <td><a href="${pageContext.request.contextPath}/deletecart/?delid=${cd.cid}"><button type="button" class="close" >&times;</button></a></td>
                                                            <td><a href="${pageContext.request.contextPath}/editcartdetails"><button type="button">Edit</button></a></td>

                                      
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>   
                                    </div>								

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </li>

                    <c:if test="${loggeduser==null}">
                        <li> <a href="${pageContext.request.contextPath}/loginpage"><i class="glyphicon glyphicon-user">Login</i></a></li>
                        </c:if>
                        <c:if test="${loggeduser!=null}">
                        <li><a href="#"><i class="glyphicon glyphicon-user"></i>Welcome ${loggeduser.username}</a>



                        </li>

                        <li ><a href="${pageContext.request.contextPath}/admin-logout"><span class="glyphicon glyphicon-user"></span>Logout</a>



                        </li>


                    </c:if>

                </ul>
            </div><!--/.navbar-collapse -->
        </div>
    </div>
