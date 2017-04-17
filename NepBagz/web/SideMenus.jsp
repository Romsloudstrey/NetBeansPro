<div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav side-nav">
        <li>
            <a href="Dashboard.jsp"><i class="fa fa-fw fa-dashboard"></i> Home</a>
        </li>
         
          <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-suitcase"></i> BAGS <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
            <a href="AddBags.jsp"><i class="fa fa-fw fa-edit"></i> Add Bags</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/displaybags"><i class="fa fa-fw fa-table"></i> Display Bags</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#dem"><i class="fa fa-fw fa-calendar"></i> PAGES <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="dem" class="collapse">
                            <li>
            <a href="AddPages.jsp"><i class="fa fa-fw fa-edit"></i> Add Pages</a>
        </li>
         <li>
             <a href="${pageContext.request.contextPath}/displaypages"><i class="fa fa-fw  fa-table"></i> Display Pages</a>
        </li>
                        </ul>
                    </li>
                     <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#third"><i class="fa fa-fw fa-dropbox"></i> ABOUT <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="third" class="collapse">
             <li>
            <a href="AddAbout.jsp"><i class="fa fa-fw fa-edit"></i> Add About</a>
        </li>
          <li>
              <a href="${pageContext.request.contextPath}/displayabout"><i class="fa fa-fw fa-table"></i> Display About</a>
        </li>
                        </ul>
                    </li>
                       <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#fourth"><i class="fa fa-fw fa-bars"></i> SLIDER <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="fourth" class="collapse">
             <li>
            <a href="AddSlider.jsp"><i class="fa fa-fw fa-edit"></i> Add slider</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/displayslider"><i class="fa fa-fw fa-table"></i> Display Slider</a>
        </li>
                        </ul>
                    </li>
                     <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#fifth"><i class="fa fa-fw fa-users"></i> TEAM <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="fifth" class="collapse">
             <li>
            <a href="AddTeam.jsp"><i class="fa fa-fw fa-edit"></i> Add Team</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/displayteam"><i class="fa fa-fw fa-table"></i> Display Team</a>
        </li>
                        </ul>
                    </li>
              
                      <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#six"><i class="fa fa-fw fa-phone"></i> CONTACT <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="six" class="collapse">
             <li>
            <a href="AddContact.jsp"><i class="fa fa-fw fa-edit"></i> Add Contact</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/displaycontact"><i class="fa fa-fw fa-table"></i> Display Contact</a>
        </li>
          <li>
              <a href="${pageContext.request.contextPath}/displaycontactmessage"><i class="fa fa-fw fa-desktop"></i>ContactUsMessage</a>
        </li>

                        </ul>
                    </li>
                        <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#seven"><i class="fa fa-fw fa-user"></i> USER <i class="fa fa-fw fa-caret-down"></i></a>
                                 <ul id="seven" class="collapse">

                 <li>
            <a href="AddUsers.jsp"><i class="fa fa-fw fa-edit"></i> Add Users</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/displayusers"><i class="fa fa-fw fa-table"></i> Display Users</a>
        </li>

                        </ul>
                    </li>
<!--        <li>
            <a href="AddBags.jsp"><i class="fa fa-fw fa-bar-chart-o"></i> Add Bags</a>
        </li>
        <li>
            <a href="BagsController?action=display"><i class="fa fa-fw fa-table"></i> Display Bags</a>
        </li>-->
<!--        <li>
            <a href="AddPages.jsp"><i class="fa fa-fw fa-edit"></i> Add Pages</a>
        </li>
         <li>
            <a href="PageController?action=display"><i class="fa fa-fw fa-desktop"></i> Display Pages</a>
        </li>-->
           
       
       
       
        <li>
            <a href="BuyController?action=displaypurchase"><i class="fa fa-fw fa-table"></i> Display Purchase</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/displaycarts"><i class="fa fa-fw fa-desktop"></i> Display Carts</a>
        </li>
        <li>
            <a href="Help.jsp"><i class="fa fa-fw fa-dashboard"></i> Get Help</a>
        </li>
    </ul>
</div>