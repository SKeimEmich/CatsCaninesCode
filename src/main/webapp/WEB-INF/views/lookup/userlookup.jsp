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
      
      <c:if test="${users ne null}">
      		<table class="table">
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th></th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.address}</td>
					<td>${user.phone}</td>
					<td><a href="${user.email}/pets" class="btn btn-primary">View Pets</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
</body>


</html>