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
    <!--  <link rel="stylesheet" href="/cnc.css"> -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>


<body>
	<%@ include file="../partials/header.jsp"%>
    <%@ include file="../partials/alert.jsp"%>
	
	    <h2>View User</h2>

		<h2>User Details</h2>
		<p>
	 		<b>Name:</b> ${user.name}<br/>
			<b>Address:</b> ${user.address}<br/>
			<b>Phone:</b> ${user.phone}<br/>
			<a href="/pet/create/${user.email}" class="btn btn-primary">Add New Pet</a><br />
			<a href="/user/edit/${user.email }" class="btn btn-primary">Edit User</a><br />
			<a href="/user/delete/${user.email }" class="btn btn-warning">Delete User</a><br />
		</p>
   
    <c:if test="${pets ne null}">
    <h3>Pets</h3>
      		<table class="table">
			<tr>
				<th>Name</th>
				<th>Species</th>
				<th>Description</th>
				<th>Date of Birth</th>
				<th></th>
			</tr>
			<c:forEach var="pet" items="${pets}">
				<tr>
					<td>${pet.name}</td>
					<td>${pet.species}</td>
					<td>${pet.description}</td>
					<td>${pet.dateOfBirth}</td>
					<td><a href="/pet/view/${pet.id}" class="btn btn-primary">Details</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
    <a href="/user/lookup" class="btn btn-primary">Back to User Lookup</a>
</body>


</html>