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
		<c:if test="${danger ne null}">
	      <div class="alert alert-danger" role="alert">
				<h4>${danger}</h4>
		  </div>
      	</c:if>      	
      	
	    <h2>User Lookup</h2>
        <div class="content">
          <form method="post">
              <div class="input-box">
                <span class="details">User Email</span>
                <input type="text" placeholder="Enter email address" name="email" required>
              </div>
   	         <div class="button">
              <input type="submit" value="Submit">
            </div>
          </form>
        </div>
      </div>
      
      <c:if test="${user ne null}">
      <h2>User Details</h2>
		<p>
	 		<b>Name:</b> ${user.name}<br/>
			<b>Address:</b> ${user.address}<br/>
			<b>Phone:</b> ${user.phone}<br/>
			<a href="/pet/create/${user.email}" class="btn btn-primary">Add New Pet</a>
		</p>
    </c:if>
    
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
    
</body>


</html>