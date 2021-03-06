<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iTravel Booking</title>

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
		<link rel="stylesheet" href="<c:url value='/resources/css/custom.css'/>"
		type="text/css" media="all">
	
		<link rel="stylesheet"
			href="<c:url value='/resources/css/newstyle.css'/>" type="text/css"
			media="all">

<link rel="stylesheet"
	href="<c:url value='/resources/css/datatable-bootstrap.min.css'/>" type="text/css"
	media="all">
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatable.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatable.min.js"></script>	
<style>
.darkgrey {
	color: #ccd1d1;
	/* border-color: #ccd1d1;
	background-color: #ccd1d1;*/
	width: 100%;
}

.departborder {
	border: 5px solid rgb(232, 231, 228);
	background-color: white;
}

.departborder:hover {
	cursor: pointer;
}

.backgroundGrey {
	background-color: rgb(232, 231, 228);
	border-radius: 5px;
	border: 5px solid white;
}

</style>

</head>
<body >

	<jsp:include page="header2.jsp"></jsp:include>
	<div class="container">
	
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Search Flights</h4>
					</div>
					<div class="panel-body">

	<form:form method="POST" action="searchFlights">
		<!-- SEARCH -->
		<div class="container marginbottom-50">

			<div class="  col-sm-12 " >

						<h3 class="red" id="msg2"></h3>

						<div class=" form-group   col-sm-3" >
							<form:label path="source" class="control-label">Departure City<span
									class="red">*</span>
							</form:label>
							<br>
							<!--<form:input path="source"  class="form-control" />-->
							<form:select id="olist" path="source" class="form-control" required="true" title="Select source">
								<!-- <option>Chennai</option>
								<option>Delhi</option> -->
								 <form:option label="--Select  origin--" value=""/>
                                 <form:options items="${sourceList}"/> 
							</form:select>

							<br>
							<form:errors path="source" />
							<br>
						</div>


						<div class=" form-group col-sm-3">
							<form:label path="destination" class="control-label ">Destination City<span
									class="red">*</span>
							</form:label>
							<br>
							<!--<form:input path="destination" class="form-control" />-->
							<form:select id="dlist" path="destination" class="form-control" required="true" title="Select destination">
								<!-- <option>Pune</option>
								<option>Bangalore</option> -->
								<form:option label="--Select  destination--" value=""/>
                                <form:options items="${destinationList}"/> 
							</form:select>
							<br>
							<form:errors path="destination" />
							<br>
						</div>
						<div class="form-group col-sm-3">
							<form:label path="journeyDate" class="control-label">Travel Date<span
									class="red">*</span>
							</form:label>
							<br>
							<form:input type="text" id="datepicker" path="journeyDate"
								class="form-control" required="true" title="Journey date is mandatory" />
							<br>
							<form:errors path="journeyDate" />
							<br>
						</div>

						<div class="col-sm-3 pull-right" style="margin-top :3px">
							<br>
							<button type="submit" id="searchbtn"
								class="btn btn-primary ">Search Flights</button>
							<br>
						</div>

	</div>
	</div>
	</form:form>
	<div class="col-md-12 text-center">
    	<div class="text-center text-danger">${message}</div>  
    </div>
    
	<c:if test = "${fn:length(availableFlights) gt 0}">
			<div class="row marginbottom-150 padding-20">
				<form:form method="POST" >
				<%!Random randomValue = new Random();%>
		<!-- for filter and results -->
				<div class="row">
					<div class="col-md-3   backgroundGrey " >
							
						<div class="col-xs-12 padding-3 margintop-10 ">Departure from</div>
						<div class="col-xs-6  departborder margintop-10 " id="dep1">Before 12:00hrs</div>
						<div class="col-xs-6  departborder margintop-10 " id="dep2">After 12:00hrs</div>
						<div class="col-xs-12"><hr class="darkgrey"/></div>
						<div class="col-xs-12 padding-3 margintop-10 ">Airlines</div>
						<div class="col-xs-12  departborder margintop-10 padding-3">
						<div class="col-xs-6 text-left  ">WingMeIn</div>
						<div class="col-xs-offset-3 col-xs-3 padding-3"><input type="checkbox" value="WingMeIn" id="air1" class="chk" name="airlines"/></div>
				</div>
		<div class="col-xs-12  margintop-10 departborder padding-3">
			<div class="col-xs-8 text-left  ">Aviate </div>
			<div class="col-xs-offset-1 col-xs-3 padding-3"><input type="checkbox" value="Aviate" id="air2" class="chk" name="airlines"/></div>
		</div>						
		<div class="col-xs-12  margintop-10 departborder padding-3">
			<div class="col-xs-6 text-left  ">FlyWithMe</div>
			<div class="col-xs-offset-3 col-xs-3 padding-3"><input type="checkbox" value="FlyWithMe" id="air3" class="chk" name="airlines"/></div>
		</div>
		<div class="col-xs-12"><hr class="darkgrey"/></div>	
		<div class="col-xs-12 padding-10 margintop-10  ">Price Range</div>
		<div class="col-xs-12 departborder margintop-10 marginbottom-10">
			<div class="row">
				<div class="col-xs-6 text-left" id="min1">
				</div>
				<div class="col-xs-6 text-right" id="max1"></div>
			</div>
			<div class="row padding-10 ">
				 <p id="amount" style="font-size:80%;border:0; color:#487757; ">
				 </p>			 
				 <div id="slider-range"></div>
			</div>	
		</div>
			<div class="col-xs-12">
		</div>			
		</div>
		
		<div class="col-md-9  backgroundGrey" >
					<table id="flightDetails1" class="display table  table-striped"
						style="width: 100%" hidden="hidden">
					<thead>
						<tr>
							<th ><font class=" "><b>Airline</b></font></th>	
						<th ><font class=" "><b>Departure Time</b></font></th>		
						<th ><font class=" "><b>Arrival Time</b></font></th>								
							<th ><font class=" "><b> Seats</b></font></th>
							<th ><font class=" "><b>Fare(In Rs)</b></font></th>
							<th ><font class=" "><b>Book</b></font></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
		
		
		
			    <table id="flightDetails" class="display table  table-striped" style="width: 200%">
		
					<thead> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Time with 24-hour clock
						<tr>
							<th ><b>Airline</b></th>	
						<th ><b>Departure Time</b></th>		
						<th ><b>Arrival Time</b></th>								
							<th ><b> Seats</b></th>
							<th ><b>Fare(In Rs)</b></th>
							<th ><b>Book</b></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="flight" items="${availableFlights}">
							
							&nbsp;&nbsp;&nbsp;&nbsp;
							<tr>
								<td><form:label style="font-weight:300" path="airlines">${flight.airlines}-${flight.flightId} </form:label></td>
								<td><form:label style="font-weight:300" path="departureTime">${flight.departureTime}</form:label></td>	
								<td><form:label style="font-weight:300" path="departureTime">${flight.arrivalTime}</form:label></td>										
								<td><form:label path="departureTime">&nbsp;&nbsp;&nbsp;&nbsp;11:00</form:label></td>
								<td><form:label style="font-weight:300" path="seatCount">${flight.seatCount}</form:label></td>
								<td><form:label style="font-weight:300" path="fare">${flight.fare}</form:label></td>
								<td><%-- <a
									href="Proceed.htm?fare=${flight.fare}&from=${flight.source}&to=${flight.destination}&jdate=${flight.flightAvailableDate}&time=<%=(new SimpleDateFormat("HH:mm:ss")).format(data.getTime())%>&seat=${flight.seatCount}&user=${userName}&fid=${flight.flightId}">Book</a></td> --%>
									
								<a	href="bookFlight?flightid=${flight.flightId}">Book</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		</div>
		</form:form>
			</div>
			</div>
	</c:if>
	
	</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<!-- /FOOTER -->

	<script type="text/javascript">
	  	$( document ).ready(function() {
	
		$("#datepicker").datepicker({ dateFormat: 'dd-mm-yy' });
	
	 
		  $( "#slider-range" ).slider({
		      range: true,
		      min: 2000,
		      max: 15000,
		      values: [ 3000, 5000 ],
		      slide: function( event, ui ) {
		        $( "#amount" ).html( "Rs." + ui.values[ 0 ] + " - Rs." + ui.values[ 1 ] );
		        
		  
		      }
		      
		    });
		    $( "#amount" ).html( "Rs." + $( "#slider-range" ).slider( "values", 0 ) +
		      " - Rs." + $( "#slider-range" ).slider( "values", 1 ) );
		 
		    $( "#slider-range" ).slider({
		    	  change: function( event, ui ) {
		    		  
		    		  console.log("Rs." + ui.values[ 0 ] + " - Rs." + ui.values[ 1 ]);
		    		  var airlinesarr=[];
		    		  <c:forEach var="listValue" items="${availableFlights}">
			    		  var flightdict={};
			    		  var flid='${listValue.flightId}';
			    		  flightdict.airlines='${listValue.airlines}'+"-"+'${listValue.flightId}';
			    		  flightdict.departureTime='${listValue.departureTime}';
			    		  flightdict.arrivalTime='${listValue.arrivalTime}';
			    		  flightdict.seatcount='${listValue.seatCount}';
			    		  flightdict.fare='${listValue.fare}';
			    		  flightdict.book='<a href="bookFlight?flightid='+flid+'">Book</a>';
			    		  airlinesarr.push(flightdict);
	    		      </c:forEach>
		    			console.log(airlinesarr);
		    		 	var childarray=[];
		    			 $.each(airlinesarr, function( index, value ) {
		    				  	if((value.fare>=ui.values[ 0 ]) && (value.fare<=ui.values[ 1 ]))
		    				  		{childarray.push(value);}
		    				});
		    			console.log("child array price");
		    			console.log(childarray);
		    			 $('#flightDetails').hide();
		    			 $('#flightDetails1').show();
		    			 console.log(childarray);
		    			 var datatable = new DataTable(document.querySelector('#flightDetails1'), {sort: [true, true, true, true,true],
		    				    data:childarray
		    			 }); 
		    	  }
		 }); 
		  
		 $("#dep1").on("click", function() {
			  alert('in dep1');
			  var airlinesarr=[];
			  <c:forEach var="listValue" items="${availableFlights}">
				  var flightdict={};
				  var flid='${listValue.flightId}';
				  flightdict.airlines='${listValue.airlines}'+'-'+'${listValue.flightId}';
				  flightdict.departureTime='${listValue.departureTime}';
				  flightdict.arrivalTime='${listValue.arrivalTime}';
				  flightdict.seatcount='${listValue.seatCount}';
				  flightdict.fare='${listValue.fare}';
				  flightdict.book='<a href="bookFlight?flightid='+flid+'">Book</a>';
				  airlinesarr.push(flightdict);
		      </c:forEach>
			      
			      
				console.log(airlinesarr);
			 	var childarray=[];
				 $.each(airlinesarr, function( index, value ) {
					 var deptime=value.departureTime;
					 var res = deptime.split(":");
					 console.log(res);
					  	if(res[0]<=12){
					  		childarray.push(value);
					  	}
					  		
					});
				 $('#flightDetails').hide();
				 $('#flightDetails1').show();
				 console.log(childarray);
				 var datatable = new DataTable(document.querySelector('#flightDetails1'), {    sort: [true, true, true, true,true,true,true],
					    data:childarray
					});
				
				});
	
		 $("#dep2").on("click", function() {
			 alert('in dep2');
			 var airlinesarr=[];
			  <c:forEach var="listValue" items="${availableFlights}">
				  var flightdict={};
				  var flid='${listValue.flightId}';
				  flightdict.airlines='${listValue.airlines}'+'-'+'${listValue.flightId}';
				  flightdict.departureTime='${listValue.departureTime}';
				  flightdict.arrivalTime='${listValue.arrivalTime}';
				  flightdict.seatcount='${listValue.seatCount}';
				  flightdict.fare='${listValue.fare}';
				  flightdict.book='<a href="bookFlight?flightid='+flid+'">Book</a>';
				  airlinesarr.push(flightdict);
		      </c:forEach>
				console.log(airlinesarr);
			 	var childarray=[];
				 $.each(airlinesarr, function( index, value ) {
					 var deptime=value.departureTime;
					 var res = deptime.split(":");
					 console.log(res);
					  	if(res[0]>=12){
					  		childarray.push(value);
					  	}
					  		
					});
				 $('#flightDetails').hide();
				 $('#flightDetails1').show();
				 console.log(childarray);
				 var datatable = new DataTable(document.querySelector('#flightDetails1'), {    sort: [true, true, true, true,true,true,true],
					    data:childarray
					});
				
				});
		 
		 $(".chk").on("click", function(){
			 //adding flight details retrieved from the database to the dictionalry arry just like it is stored in dummydata
			function create(htmlStr) {
		    var frag = document.createDocumentFragment(),
		        temp = document.createElement('a');
		    temp.innerHTML = htmlStr;
		    while (temp.firstChild) {
		        frag.appendChild(temp.firstChild);
		    }
		    return frag;
		}
			var airlinesarr=[];
			  <c:forEach var="listValue" items="${availableFlights}">
	              var flightdict={};
				  var flid='${listValue.flightId}';
	     		  flightdict.airlines='${listValue.airlines}'+'-'+'${listValue.flightId}'; 
				  flightdict.departureTime='${listValue.departureTime}';
				  flightdict.arrivalTime='${listValue.arrivalTime}';		  
				  flightdict.seatcount='${listValue.seatCount}';
				  flightdict.fare='${listValue.fare}';
				  flightdict.book='<a href="bookFlight?flightid='+flid+'">Book</a>';
				  airlinesarr.push(flightdict);
			  </c:forEach>
			      
			  var $airlines = $('input[name=airlines]:checked');
			  var localarray=[];
			
	 		  console.log("all flights:");
			  console.log(airlinesarr); //data from database
				
			  if(($airlines.length==0) || ($airlines.length==3))
			  { 
				 localarray=airlinesarr;}
				else
				{
				
				console.log("inside else");
				
					if($('#air1').is(':checked'))
						{
						console.log("inside if #air1");
						console.log(airlinesarr);
							$.each(airlinesarr, function( index, value ) {
								console.log(value.airlines);
								console.log(value);
							  	if((value.airlines.indexOf("WingMeIn"))>=0){
							  		/* value.airlines=value.airlines+"-"+flid; */
							  		/* console.log("value is");
							  		console.log(value.airlines.indexOf("WingMeIn"));
							  		console.log(value.airlines);
							  		console.log(value); */
							  		localarray.push(value);
							  		
							  	}
							  			
							});
						}
						  if($('#air2').is(':checked'))
							{
								$.each(airlinesarr, function( index, value ) {
								  	if((value.airlines.indexOf("Aviate"))>=0)
								  			/* value.airlines=value.airlines+"-"+flid; */
								  			localarray.push(value);
								});
							}
						  if($('#air3').is(':checked'))
							{
							  console.log("inside air3");
								$.each(airlinesarr, function( index, value ) {
								  	if((value.airlines.indexOf("FlyWithMe"))>=0)
								  			/* value.airlines=value.airlines+"-"+flid; */
								  			localarray.push(value);
								});
							}
						 
						  console.log(localarray);
					
				}
		
			 $('#flightDetails').hide();
			 $('#flightDetails1').show();
	
			 var datatable = new DataTable(document.querySelector('#flightDetails1'), {    sort: [true, true, true, true,true,true,true],
				    data:localarray
				});
			 
		 });
	  });
  </script>


</body>

</html>
