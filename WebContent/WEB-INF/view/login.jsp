
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iTravel Booking</title>

	<link rel="stylesheet" href="<c:url value='/resources/css/newstyle.css'/>"
	type="text/css" media="all">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" 
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/resources/css/custom.css'/>"
	type="text/css" media="all">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body onload="focusOnLogin()">
	<script type="text/javascript"> function focusOnLogin(){
		document.getElementById("userName").focus();
	}</script>
	
<!-- HEADER -->
	<header id="header">


		<nav class="navbar st-navbar navbar-fixed-top">

			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#st-navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="logo1" href="${pageContext.servletContext.contextPath}"><img
						src="<c:url value='/resources/images/infygonew.PNG'/>" alt=""></a>
				</div>
				</div>
				</nav>
	</header>
	<!-- /HEADER -->

 
	<!-- Login start -->
	
	
		
		<section id="slider" class="margintop-10">
		<div id="home-carousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
			
			
			
				<div class="item active" style="background-image: url(<c:url value='/resources/imgs/382266112.jpg'/>)">
					<br><br>
					<div class="container">
						<div class="col-sm-6">
								<p class="head " style="color:white">Connecting flight</p>
								<p class="carousel-content  " style="color:white">Taking more than one flight to
									get to your final destination? At InfyGo, we make connecting
									flights much easier!</p>
						</div>
					</div>					
				</div> 
				<div class="item" style="background-image: url(<c:url value='/resources/imgs/586266182.jpg'/>)">
					<br><br>
					<div class="container">
						<div class="col-sm-6">
								<p class="head " style="color:white">InfyGo Meals onboard</p>
								<p class="carousel-content " style="color:white">Tickle your taste buds and enjoy
									sumptuous meals onboard!</p>
						</div>
					</div>					
				</div> 
			
			<div class="item" style="background-image: url(<c:url value='/resources/imgs/346909778.jpg'/>)">
					<br><br>
					<div class="container">
						<div class="col-sm-6">
								<p class="head " style="color:white">Hospitality</p>
								<p class="carousel-content " style="color:white">More convenience and comfort
									with our hospitality and services!</p>
						</div>
					</div>					
				</div> 
				

			</div>
			<ol class="carousel-indicators">
				<li data-target="#home-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#home-carousel" data-slide-to="1"></li>
				<li data-target="#home-carousel" data-slide-to="2"></li>
			</ol>
		</div>
		<!--/-carousel-->

	</section>
	<!-- /SLIDER -->
		
          	<!-- ABOUT US -->
          	<div class="row marginbottom-150">
		<div class="container col-sm-offset-1 col-sm-5 col-left ">
					<h1 class="capital">
						<strong>About Us</strong>
					</h1>
					<span class="st-border"></span>
					<div class="about-us ">
						<br>
						<p>
							<b>Why iTravel?<br></b> The leading player in online flight
							bookings, iTravel provides great offers, some of the
							lowest airfares, exclusive discounts and a seamless online
							booking experience. Flight bookings through our website is a
							customer friendly experience, and with just a few clicks you can
							complete your booking.
						</p>
						<br>

						<p>
							<b>Booking Flights with iTravel<br></b> While booking flights
							with iTravel, you can expect the ultimate online booking
							experience. With premium customer service, 24/7 dedicated
							helpline for support, and over 5 million delighted customers,
							iTravel takes great pride in enabling customer satisfaction.
						</p>
						<br>

						<p>
							<b>Domestic Flights with iTravel<br></b> iTravel is the
							leading player for flight bookings, and have a dominant position
							in the flights sector. With the cheapest fare guarantee,
							experience great value at the lowest price.
						</p>

					</div>
		</div>
	<!-- /ABOUT US -->
	
		<div class="container  col-sm-5 col-right " style="width:40%">
			<br> <br> <br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="capital">Login</h4>
				</div>
				<div class="panel-body">
					<h3 class="red" id="msg2"></h3>
				
					<form:form method="POST" action="authenticateLogin"
						commandName="command">

						
							<div class="form-group">
								<form:label path="userName"
									class="control-label col-sm-offset-1 col-sm-3 text-right fontstyle">User Id<span
										class="red">*</span>
								</form:label>
								<div class="col-sm-7">
									<form:input id="userName" path="userName" class="form-control" required="true" title="User id must contain 4 to 15 characters"
									 pattern=".{4,15}" />
									<br>
									<form:errors path="userName" />
								</div>
								<br>
							</div>
							<div class="form-group">
								<form:label path="password"
									class="control-label col-sm-offset-1 col-sm-3 text-right fontstyle">Password<span
										class="red">*</span>
								</form:label>
								<div class="col-sm-7">
									<form:input type="password" path="password" required="true" title="Password must contain 8 to 15 characters"
										class="form-control" pattern=".{8,15}"/>
											<a href="forgotPassword" class="help-text pull-right">Forgot Password?</a>
									<br>
									<form:errors path="password" />
								</div>
								<br>
							</div>
							<br><br><br><br>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-7">
									<a href="register">New User?</a> &nbsp; <button
										type="submit" class="btn btn-primary fontfamily" >Login</button>
								</div>

							</div>
							
							
					</form:form>
					
					<div class="col-md-12 text-center">
            <div class="text-center text-danger">${message}</div>  
            </div>
					
					</div>
					
				</div>
			</div>
	</div>
	<!-- Login end -->

	<jsp:include page="footer.jsp"></jsp:include>
</body>


</html>
