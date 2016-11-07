<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookYourHotel</title>
<link rel="stylesheet"
	href="./css/app.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#checkindatepicker" ).datepicker();
    $( "#checkoutdatepicker" ).datepicker();
    
    $('#citySelect').change(function() {
	    $.ajax({
	        type:"GET",
	        url : "getHotelsForCity",
	        data : { cityId: $('#citySelect').val()},
	        success : function(data) {
	            $('#hotelSelect').empty(); //remove all child nodes
	            var newOption = "<option value='-1'>Please Select Hotel</option>";
	            $('#hotelSelect').append(newOption);
	            for(var i = 0; i < data.length; i++){
	               var newOption = $('<option value='+data[i].hotelId+'>'+data[i].hotelName+'</option>');
	                $('#hotelSelect').append(newOption);
	            }   
	        },
	        error: function() {
	            console.log("error");
	        }
	    });
	});
  } );
  
 
  </script>
</head>
<body>
	<div class="header">
		<h2>BookYourHotel.com</h2> 
	</div>
	<div class="hero-banner background expanded" 
		style="height: 550px; background-image: url('./images/imgad.jpg')"
		alt="Advertisement">
		<div
			style="    margin-left: 15%;    margin-right: 20%;    background: white;">
			<h2>Book a Room</h2>
			
			<form:form method="POST" action="bookroom">
				<table>
					<tr>
						<td><label>City:</label></td>
						<td><div class="select"><form:select id="citySelect"  path="city.cityId" >
							
							<form:option value="-1" label="Please Select City"></form:option>
							<form:options items="${allCities}" itemValue="cityId" itemLabel="cityName"/>
						</form:select></div>
							<!-- data-wizard-action="{&quot;cabinClass&quot; : &quot;$value1&quot;}"
							class="" data-select-value=""
							data-wizard-owner="advanced-preferred-class">
								<option value="f">First Class</option>
								<option value="b">Business</option>
								<option selected="selected" value="">Economy/Coach</option>
								<option value="p">Premium Economy</option>
						</select> --></td>
					</tr>
					<tr>
						<td><label>Hotel:</label></td>
						<td><div class="select">
						<form:select id="hotelSelect" path="hotel.hotelId">
							<form:option value="-1" label="Please Select Hotel"></form:option>
						</form:select>
						</div></td>
					</tr>
					<tr>
						<td><label><b>Check-in date:</b></label></td>
						<td><p>
								 <form:input path="checkinDate" type="text" style="width:90%" id="checkindatepicker"/>
							</p></td>
					</tr>
					<tr>
						<td><label>Check-out date:</label></td>
						<td><p>
								 <form:input path="checkoutDate" type="text" style="width:90%" id="checkoutdatepicker"/>
							</p></td>
					</tr>
					<tr>
						<td><label>No Of Rooms:</label></td>
						<td><p>
								 <form:input path="noOfRooms" type="text" style="width:90%" id="noOfRooms"/>
							</p></td>
					</tr>
					<tr>
						<td ><input class="button" type="submit" style="      font-weight: bold;color: #003580;  float: left;    width: 114px;"
							value="Book Room" /></td>
						<td ><input class="button" id="submit" type="button" style="    margin-left: 55%;    width: 35%;"/><a style="    position: absolute;
   margin-top: 5px;
    margin-left: -5%;
    text-decoration: none;
    font-weight: bold;
    color: #003580;" href="/hotelbooking">Cancel</a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div style="    font-size: 16px;    width: 100%;    background: #009688;">
		©2016 PN, Inc. All rights reserved.
	</div>
</body>
</html>