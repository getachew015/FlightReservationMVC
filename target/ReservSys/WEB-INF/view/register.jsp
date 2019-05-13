<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet" href='<spring:theme code="css"/>' type="text/css" />  
<title><spring:theme code="page.title"/></title> 
<title>iTravel Booking</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/newstyle.css'/>"
	type="text/css" media="all">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" 
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
 <link rel="stylesheet" href="<c:url value='/resources/css/custom.css'/>"
	type="text/css" media="all">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<!-- SIGNUP -->
	
		<!-- SLIDER -->
	<section id="slider" class="margintop-10">
		<div id="home-carousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active" style="background-image: url(<c:url value='/resources/imgs/382266112.jpg'/>)">
					<br><br>
					<div class="container">
						<div class="col-sm-6">
								<p class="head " style="color:white">Connecting flight</p>
								<p class="carousel-content  " style="color:white">Taking more than one flight to
									get to your final destination? At iTravle Booking, we make connecting
									flights much easier!</p>
						</div>
					</div>					
				</div> 
				<div class="item" style="background-image: url(<c:url value='/resources/imgs/586266182.jpg'/>)">
					<br><br>
					<div class="container">
						<div class="col-sm-6">
								<p class="head " style="color:white">iTravle Booking Meals onboard</p>
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
							<b>Why iTravle Booking?<br></b> The leading player in online flight
							bookings in India, iTravle Booking provides great offers, some of the
							lowest airfares, exclusive discounts and a seamless online
							booking experience. Flight bookings through our website is a
							user friendly experience, and with just a few clicks you can
							complete your booking.
						</p>
						<br>

						<p>
							<b>Booking Flights with iTravle Booking<br></b> While booking flights
							with iTravle Booking, you can expect the ultimate online booking
							experience. With premium customer service, 24/7 dedicated
							helpline for support, and over 5 million delighted customers,
							iTravle Booking takes great pride in enabling user satisfaction.
						</p>
						<br>

						<p>
							<b>Domestic Flights with iTravle Booking<br></b> iTravle Booking is one of
							the leading flight booking applications, and has a dominant position
							in the sector. With the cheapest fare guaranteed,
							experience great value at the lowest price.
						</p>

					</div>
		</div>
		
	<!-- /ABOUT US -->

		<div class="container col-sm-5 col-right signup" style="width : 40%">
		
			<div class="panel panel-default">
			
				<div class="panel-heading">
				<h4 class="capital">
				<spring:message code="register.register" text="default text" /> 
				</h4>
				
				<div style="width: 100%;margin-right:-55px" align="right" class="fontstyle">
					Language : <a href="?locale=en">English</a>|<a href="?locale=hi">Hindi</a>|<a href="?locale=cn">Chinese</a>
				</div>
				<div style="width: 100%;margin-right:-35px" align="right" class="fontstyle">
					Themes : <a href="?theme=green">Green</a>|<a href="?theme=red">Red</a>|<a href="?theme=default">Default</a>
				</div>
				</div>
				<div class="panel-body">
					<form:form method="POST" action="registerUser" commandName="command" >
					    <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle" >
							<spring:message code="register.userid" text="default text"
								 />
								 <span style="color: red">*</span>
							</div>
							<div class="col-sm-6">
								<form:input path="userId" class="form-control"/>
								<br> 
								<form:errors path="userId" />
							</div>
							<br>
						</div>
						
						 <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle" >
					
							<spring:message code="register.pwd" text="default text"
								 />
							<span style="color: red">*</span>
							</div>
							<div class="col-sm-6">
								<form:password path="password" class="form-control" />
								<br> 
								<form:errors path="password" />
							</div>
							<br>
						
						</div>
						 <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle" >
					
							<spring:message code="register.name"
								text="default text" />
							<span style="color: red">*</span>
							</div>
							<div class="col-sm-6">
								<form:input path="name" class="form-control" />
								<br> 	<form:errors path="name" />
							</div>
							<br>
						</div>
						 <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle" >
						
							<spring:message code="register.address"
								text="default text" />
							<span style="color: red">*</span>
							</div>
							<div class="col-sm-6">
								<form:input path="address" class="form-control" />
								<br> 
								<form:errors path="address" />
							</div>
							<br>
						</div>
						
						 <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle" >
					
							<spring:message code="register.email"
								 text="default text" />
							<span style="color: red">*</span>
							</div>
							<div class="col-sm-6">
								<form:input path="email" class="form-control" />
								<br> 
								<form:errors path="email" />
							</div>
							<br>
						
						</div>
						 <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle" >
						
							<spring:message code="register.phone"
							text="default text" />
							<span style="color: red">*</span>
						</div>
							<div class="col-sm-6">
								<form:input path="phone" class="form-control" maxlength="10" />
								<br> 
								<form:errors path="phone" />
							</div>
							<br>
						</div>
						 <div class="row">
						<div class="form-group col-sm-offset-1 col-sm-3 text-right fontstyle" >
					
						</div>
							<div class="col-sm-6">
								<input type="submit" class="btn btn-primary"
									value="<spring:message code="register.submit"/>"/>
							</div>
							<div class="col-md-12 text-center">
            <div class="text-center text-danger">${message}</div>  
            </div></div><br>
            <c:if test="${successMessage ne null}">
				<div class="alert alert-success col-md-12" align="center">${successMessage}
				<br>
				Click <a href="login" >
                        &nbsp;here </a>to login.
                  </div>
		</c:if>		
					</form:form>

				</div>
			</div>
			
		</div>
		</div>
	<!-- /SIGNUP -->



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>