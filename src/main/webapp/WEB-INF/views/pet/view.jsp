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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>


<body>
	<%@ include file="../partials/header.jsp"%>
    

      <div class="container">
		<c:if test="${danger ne null}">
	      <div class="alert alert-danger" role="alert">
				<h4>${danger}</h4>
		  </div>
      	</c:if>   	
      </div>
      
      <c:if test="${pet ne null}">
      <h2>Pet Details</h2>
		<p>
	 		<b>Name:</b> ${pet.name}<br/>
			<b>Species:</b> ${pet.species}<br/>
			<b>Description:</b> ${pet.description}<br/>
			<b>Date of Birth:</b> ${pet.dateOfBirth}<br/>
			<a href="/appointment/create/${pet.id}" class="btn btn-primary">Add New Appointment</a>
		</p>
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
					<td>${appointment.amtOwed}</td>
					<td>${appointment.amtPaid}</td>
					<td>${appointment.amtOwed - appointment.amtPaid}</td>
					<td><a href="/appointment/view/${appointment.id}" class="btn btn-primary">Details</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
    
</body>


</html>