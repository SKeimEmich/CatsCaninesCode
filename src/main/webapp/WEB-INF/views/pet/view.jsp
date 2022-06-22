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

      
      <c:if test="${pet ne null}">
      <h2>Pet Details</h2>
		<p>
	 		<b>Name:</b> ${pet.name}<br/>
			<b>Species:</b> ${pet.species}<br/>
			<b>Description:</b> ${pet.description}<br/>
			<b>Date of Birth:</b> ${pet.dateOfBirth}<br/>
			<a href="/appointment/create/${pet.id}" class="btn btn-primary">Add New Appointment</a>
		</p>
		<a href="/pet/edit/${pet.id }" class="btn btn-primary">Edit Pet</a> 
		<a href="/pet/delete/${pet.id }" class="btn btn-warning">Delete Pet</a> 
    </c:if>
    
    <c:if test="${appointments ne null}">
    <h3>Appointments</h3>
      		<table class="table">
			<tr>
				<th>Date</th>
				<th>Amount Owed</th>
				<th>Amount Paid</th>
				<th>Remaining Balance</th>
				<th></th>
			</tr>
			<c:forEach var="appointment" items="${appointments}">
				<tr>
					<td>${appointment.date}</td>
					<td><fmt:formatNumber type="currency" value="${appointment.amtOwed}" /></td>
					<td><fmt:formatNumber type="currency" value="${appointment.amtPaid}" /></td>
					<td><fmt:formatNumber type="currency" value="${appointment.amtOwed - appointment.amtPaid}" /></td>
					<td><a href="/appointment/view/${appointment.id}" class="btn btn-primary">Details</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
       <a href="/user/view/${pet.user.email}" class="btn btn-primary">Back to Owner</a>
</body>


</html>