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
	
	    <h2>User Lookup</h2>
        <div class="content">
          <form method="post">
              <div class="input-box">
                <span class="details">Search</span>
                <input type="text" name="searchKey" required>
              </div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="column" id="name" value="name">
			  <label class="form-check-label" for="name">
			    Name
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="column" id="phone" value="phone">
			  <label class="form-check-label" for="phone">
			    Phone
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="column" id="email" value="email">
			  <label class="form-check-label" for="email">
			    Email
			  </label>
			</div>
   	         <div class="button">
              <input type="submit" value="Submit" class="btn btn-primary">
            </div>
          </form>
        </div>
		<a href="/user/create" class="btn btn-primary">Create New User</a>      
    
    <c:if test="${users ne null}">
    <h3>Users</h3>
      		<table class="table">
			<tr>
				<th>Email</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Account Type</th>
				<th></th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.email}</td>
					<td>${user.name}</td>
					<td>${user.address}</td>
					<td>${user.phone}</td>
					<td>${user.acctType}</td>
					<td><a href="/user/view/${user.email}" class="btn btn-primary">Details</a></td>
				</tr>
			</c:forEach>
		</table>
    </c:if>
    
</body>


</html>