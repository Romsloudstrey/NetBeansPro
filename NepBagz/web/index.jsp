


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <!-- BASICS -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>NepBagz</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen" />	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- skin -->
    <link rel="stylesheet" href="skin/default.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
   
</head>

<body>
    <%@include file="IndexHeader.jsp"%>

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/mainslider/mainslide1.jpg" alt="Chania" style="height:500px;width:100%">
                <div class="carousel-caption">
                    <h3>Mevice</h3>
                    <p>Carry it off in Style</p>
                </div>
            </div>
            <c:forEach items="${slider}" var="s">
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/${s.imageName}" alt="Chania" style="height:500px;width:100%">
                    <div class="carousel-caption">
                        <h3>${s.slidername}</h3>
                        <p>${s.location}</p>
                    </div>
                </div>

            </c:forEach>

        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!-- services -->

    <section id="section-services" class="section pad-bot30 bg-white">
        <div class="container"> 
            <div class="row mar-bot40">
                <div class="col-lg-4" >
                    <div class="align-center">
                        <i class="fa fa-code fa-5x mar-bot20"></i>
                        <h4 class="text-bold">${about.get(0).services_title}</h4>
                        <p>${about.get(0).services_description}
                        </p>
                    </div>
                </div>

                <div class="col-lg-4" >
                    <div class="align-center">
                        <i class="fa fa-terminal fa-5x mar-bot20"></i>
                        <h4 class="text-bold">${about.get(1).services_title}</h4>
                        <p>${about.get(1).services_description}
                        </p>
                    </div>
                </div>

                <div class="col-lg-4" >
                    <div class="align-center">
                        <i class="fa fa-bolt fa-5x mar-bot20"></i>
                        <h4 class="text-bold">${about.get(2).services_title}</h4>
                        <p>${about.get(2).services_description}
                        </p>
                    </div>
                </div>

            </div>	
        </div>
    </section>

    <!-- spacer section:testimonial -->
    <section id="testimonials" class="section" data-stellar-background-ratio="0.5">
        <div class="container">
            <div class="row">				
                <div class="col-lg-12">
                    <div class="align-center">
                        <div class="testimonial pad-top40 pad-bot40 clearfix">
                            <h5>
                                ${about.get(0).testimonial_description}
                            </h5>
                            <br/>
                            <span class="author">&mdash; ${about.get(0).testimonial_author_name}<a href="#">www.siteurl.com</a></span>
                        </div>

                    </div>
                </div>

            </div>	
        </div>	
    </section>

    <!-- about -->
    <section id="section-about" class="section appear clearfix">
        <div class="container">

            <div class="row mar-bot40">
                <div class="col-md-offset-3 col-md-6">
                    <div class="section-header">
                        <h2 class="section-heading animated" data-animation="bounceInUp"> ${about.get(0).about_header}</h2>
                        <p>${about.get(0).about_description}</p>
                    </div>
                </div>
            </div>

            <div class="row align-center mar-bot40">
                <c:forEach items="${team}"  var="t">
                    <div class="col-md-3">
                        <div class="team-member">
                            <figure class="member-photo"><img src="${pageContext.request.contextPath}/img/${t.team_Member_Image}" alt="" /></figure>
                            <div class="team-detail">
                                <h4>${t.team_Title}</h4>
                                <span>${t.team_Member_Job}</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>
    </section>
    <!-- /about -->

    <!-- spacer section:stats -->
    <section id="parallax1" class="section pad-top40 pad-bot40" data-stellar-background-ratio="0.5">
        <div class="container">
            <div class="align-center pad-top40 pad-bot40">
                <blockquote class="bigquote color-white">${team.get(0).parallax1_Blockquote}</blockquote>
                <p class="color-white">${team.get(0).parallax1_Description}</p>
            </div>
        </div>	
    </section>

    <!-- section works -->
    <section id="section-works" class="section appear clearfix">
        <div class="container">

            <div class="row mar-bot40">
                <div class="col-md-offset-3 col-md-6">

                    <div class="section-header">
                        <h2 class="section-heading animated" data-animation="bounceInUp">${bag.get(0).portfolio_Name}</h2>
                        <p>${bag.get(0).portfolio_Description}</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <nav id="filter" class="col-md-12 text-center">
                    <ul>
                        <li><a href="#" class="current btn-theme btn-small" data-filter="*">All</a></li>
                        <li><a href="#"  class="btn-theme btn-small" data-filter=".webdesign" >Recent</a></li>
                        <li><a href="#"  class="btn-theme btn-small" data-filter=".photography">Mostly Sold</a></li>
                        <li ><a href="#" class="btn-theme btn-small" data-filter=".print">Print</a></li>
                    </ul>
                </nav>
                <div class="col-md-12">
                    <div class="row">
                        <div class="portfolio-items isotopeWrapper clearfix" id="3">
                            <c:forEach items="${bag}" var="b">

                                <article class="col-md-4 isotopeItem webdesign">

                                    <div class="thumbnail">
                                        <div>
                                            <p class="pull-left view-counts hidden-md"> 
                                                <c:if test="${loggeduser==null}">

                                                    <a href="${pageContext.request.contextPath}/loginpage"><button type="button" class="btn btn-primary btn-md">Read &AMP; shop now &Gt;</button></a>                                   
                                                </c:if>
                                                <c:if test="${loggeduser!=null}">

                                                    <a href="${pageContext.request.contextPath}/buy/?eid=${b.bagId}"><button type="button" class="btn btn-primary btn-md">Read &AMP; shop now &Gt;</button></a>                                   
                                                </c:if>
                                            </p>

                                            <p class="pull-right view-counts hidden-md">


                                                <a href="${pageContext.request.contextPath}/addtocart/?eid=${b.bagId}&&eid=${user.get(0).lid}">Add to Cart</a>
                                                <span class="glyphicon glyphicon-shopping-cart" style="color:#5B5858; padding-top: 4px;"></span> 
                                            </p>
                                        </div>

                                        <img src="${pageContext.request.contextPath}/img/${b.imageName}" class="image" alt="Lights" style="width:100%">


                                        <div class="caption">
                                            <p><strong>${b.bagName}</strong></p>
                                        </div>

                                    </div>

                                </article>
                            </c:forEach>


                        </div>
                    </div>

                </div>
            </div>

        </div>
    </section>


</section>
<section id="parallax2" class="section parallax" data-stellar-background-ratio="0.5">	
    <div class="align-center pad-top40 pad-bot40">
        <blockquote class="bigquote color-white">${team.get(0).parallax2_Blockquote}</blockquote>
        <p class="color-white">${team.get(0).parallax2_Description}</p>
    </div>
</section><!--

<!-- contact -->
<section id="section-contact" class="section appear clearfix">
    <div class="container">

        <div class="row mar-bot40">
            <div class="col-md-offset-3 col-md-6">
                <div class="section-header">
                    <h2 class="section-heading animated" data-animation="bounceInUp">${con.get(0).contactUs_title}</h2>
                    <p>${con.get(0).contact_Description}</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="cform" id="contact-form">
                    <div id="sendmessage">
                        Your message has been sent. Thank you!
                    </div>
                    <div id="errormessage"></div>
                    <form action="${pageContext.request.contextPath}/sendmessage" method="post" role="form" class="contactForm">
                        <c:forEach items= "${con}" var="c">
                            <div class="form-group">
                                <label for="name">${c.field1_Name}</label>
                                <input type="text"  name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                            <div class="form-group">
                                <label for="email">Your ${c.field2_Name}</label>
                                <input type="email"  class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email"  />
                                <div class="validation"></div>
                            </div>
                            <div class="form-group">
                                <label for="subject">${c.field3_Name}</label>
                                <input type="text"  class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                                <div class="validation"></div>
                            </div>
                            <div class="form-group">
                                <label for="message">${c.field4_Name}</label>
                                <textarea class="form-control"  name="message" rows="5" data-rule="required" data-msg="Please write something for us" ></textarea>
                                <div class="validation"></div>
                            </div>
                        </c:forEach>

                        <button type="submit" class="btn btn-theme pull-left">SEND MESSAGE</button>
                    </form>

                </div>
            </div>
            <!-- ./span12 -->
        </div>

    </div>
</section>
<!-- map -->
<section id="section-map" class="clearfix">
    <div id="google-map" data-latitude="40.713732" data-longitude="-74.0092704"></div>
</section>
<a href="#header" class="scrollup"><i class="fa fa-chevron-up"></i></a>	

    <%@include file="IndexFooter.jsp" %>


<script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="js/jquery.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://maps.google.com/maps/api/js?sensor=true"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.nicescroll.min.js"></script>
<script src="js/fancybox/jquery.fancybox.pack.js"></script>
<script src="js/skrollr.min.js"></script>		
<script src="js/jquery.scrollTo-1.4.3.1-min.js"></script>
<script src="js/jquery.localscroll-1.2.7-min.js"></script>
<script src="js/stellar.js"></script>
<script src="js/jquery.appear.js"></script>
<script src="js/main.js"></script>
<script src="contactform/contactform.js"></script>
<script>
    $(document).ready(function () {
        $("#mytable").DataTable();
    });

</script>

</body>
</html>   