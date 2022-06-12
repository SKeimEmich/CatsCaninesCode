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
    
      <div class="container">
		<c:if test="${message ne null}">
	      <div class="alert alert-success" role="alert">
				<h4>${message}</h4>
		  </div>
      	</c:if>      	
      	
	    <h2>Pet Display</h2>
      <c:if test="${pets ne null}">
      		<table class="table">
			<tr>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>Species</th>
				<th>Description</th>
				<th></th>
			</tr>
			<c:forEach var="pet" items="${pets}">
				<tr>
					<td>${pet.name}</td>
					<td>${pet.dateOfBirth}</td>
					<td>${pet.species}</td>
					<td>${pet.description}</td>
					<td><a href="${pet.id}/records" class="btn btn-primary">View Records</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
    <c:if test="${pets eq null}">
      <div class="alert alert-danger" role="alert">
				<h4>Unable to find pets. Contact system administration for help.</h4>
		  </div>
      	
    </c:if>
</body>


</html>