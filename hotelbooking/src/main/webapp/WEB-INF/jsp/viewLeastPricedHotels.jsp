<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	$(function() {
		$("#checkindatepicker").datepicker();
		$("#checkoutdatepicker").datepicker();

		$('#citySelect').change(function() {

			document.forms['command'].submit.click();
		});
	});
</script>
</head>
<body>
	<div class="header">
		<h2>BookYourHotel.com</h2>
	</div>
	<div class="hero-banner background expanded" alt="Advertisement" style="background-image: url('./images/imgad.jpg')"">
		<div style="margin-left: 10%; margin-right: 14%;     background: white;    min-height: 500px;">
			<h2>View Least Priced Hotels</h2>

			<form:form method="POST" action="viewHotels" name="viewHotelForm">
				<table style="width: 60%; margin-bottom: 3%;">
					<tr>
						<td><label style="color: #37454d; font-size: 20px;">City:</label></td>
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
						<td><input id="submit" style="display: none" type="submit"
							value="submit" /></td>

					</tr>
				</table>
				<c:forEach items="${hotels}" var="hotel">
					<li
						style="margin: 8px; background: white; border-radius: 2px; width: 93%; display: block;
	/* height: 30%; */ float: none; clear: none; display: flex; box-sizing: inherit; box-shadow: 0 1px 4px rgba(41, 51, 57, .5); background-color: white;"
						id="${hotel.hotelId }">
						<div
							style="color: white; width: 100%; display: block; margin: 9px;">
							<div style="width: 15%; float: left; padding: 5px 4px 5px 2px;">
								<img src="./images/hotels/1.jpeg" style="    width: 120px;    height: 120px;">
							</div>

							<div style="width: 80%; float: right; height: 100%;">
								<div
									style="padding-top: 0%; width: 55%; float: left; margin: 0px; padding: 0px;">
									<h3 style="font-size: 30px; color: #37454d;">${hotel.hotelName}</h3>
									<span style="color: #37454d;">${hotel.landmark},
										${hotel.cityName}</span>
								</div>

								<div
									style="padding-top: 4%; width: 38%; float: right; color: #37454d; font-size: 15px; /* padding-top: 10%; */ border-left: 1px solid #cdd0d2; /* border-color: black; */ height: 78%; display: block;">
									<strong
										style="padding-top: 8%; margin-left: 27%; font-size: 22px;">Rs.
										${hotel.tariff} </strong>
									<p style="margin: 13%; margin-top: 2%;">Lowest starting
										price per day</p>

								</div>

							</div>

						</div>

					</li>




				</c:forEach>


			</form:form>
		</div>
	</div>
</body>
</html>