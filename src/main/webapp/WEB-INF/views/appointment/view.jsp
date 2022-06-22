<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cats and Canines Vet</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/sandstone/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ABdnjefqVzESm+f9z9hcqx2cvwvDNjfrwfW5Le9138qHCMGlNmWawyn/tt4jR4ba"
	crossorigin="anonymous">
</head>


<body>
<%@ include file="../partials/navigation.jsp"%>
<%@ include file="../partials/alert.jsp"%>

      
      <c:if test="${appointment ne null}">
      <h2>Appointment Details</h2>
		<p>
	 		<b>Pet Name:</b> ${appointment.pet.name}<br/>
			<b>Date:</b> ${appointment.date}<br/>
			<b>Amount Owed:</b> <fmt:formatNumber type="currency" value="${appointment.amtOwed}" /><br/>
			<b>Amount Paid:</b> <fmt:formatNumber type="currency" value="${appointment.amtPaid}" /><br/>
			<b>Amount Due:</b> <fmt:formatNumber type="currency" value="${appointment.amtOwed - appointment.amtPaid}" /><br/>
			<a href="/record/create/${appointment.id}" class="btn btn-primary">Add New Record</a>
		</p>
		<a href="/appointment/edit/${appointment.id}" class="btn btn-primary">Edit Appointment</a>
		<a href="/appointment/delete/${appointment.id}" class="btn btn-warning">Delete Appointment</a>
    </c:if>
    
    <c:if test="${records ne null}">
    <h3>Records</h3>
      		<table class="table">
			<tr>
				<th>Service Code</th>
				<th>Description</th>
				<th>Cost</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="record" items="${records}">
				<tr>
					<td>${record.serviceCode}</td>
					<td>${record.description}</td>
					<td><fmt:formatNumber type="currency" value="${record.cost}"/></td>
					<td><a href="/record/edit/${record.id}" class="btn btn-primary">Edit Record</a></td>
					<td><a href="/record/delete/${record.id}" class="btn btn-warning">Delete Record</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
    <a href="/pet/view/${appointment.pet.id}" class="btn btn-primary">Back to View Pet</a>
    
</body>


</html>