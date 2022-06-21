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
    <link rel="stylesheet" type="text/css" href="/src/main/resources/static/main.css">
</head>

<body>  
<!-- <%@ include file="../partials/alert.jsp"%> -->
<header>
	<div class="container">
		<h2><span>Cats </span> & Canines</h2>
		<nav>
			<a href="#about">About</a>
			<a href="#services">Services</a>  
			<!-- <a href="#">Pet Application</a> -->
			<a href="#contact">Contact</a>
			<a href="adminlogin.jsp">Login</a>
		</nav>
	</div>
</header>
      	
	    <h2>Create a New Owner</h2>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">Full Name</span>
                <input type="text" placeholder="Enter Full Name" name="ownerName" value=${dne } required>
              </div>
              <div class="input-box">
                <span class="details">Email Address</span>
                <input type="text" placeholder="Enter Contact Email" name="ownerEmail" required>
              </div>
              <div class="input-box">
                <span class="details">Address</span>
                <input type="text" placeholder="Enter Address" name="ownerAddress" required>
              </div>
              <div class="input-box">
                <span class="details">Phone Number</span>
                <input type="text" placeholder="Enter Phone Number" name="ownerPhoneNumber" required>
              </div>
              <div class="input-box">
                <span class="details">Password</span>
                <input type="password" placeholder="Choose a password" name="ownerPassword"  required>
              </div>
            </div>
            <div class="history">
              <input type="radio" name="history" id="dot-1" value="staff">
              <input type="radio" name="history" id="dot-2" value="client">
              <span class="history-title">Owner Type</span>
              <div class="category">
                <label for="dot-1">
                <span class="dot one"></span>
                <span class="history">Staff</span>
              </label>
              <label for="dot-2">
                <span class="dot two"></span>
                <span class="history">Client</span>
              </label>
              </div>
            </div>
            <div class="button">
              <input type="submit" value="Welcome New Owner!">
            </div>
          </form>
          <a href="/user/lookup" class="btn btn-primary">Back to User Lookup</a>
        </div>

   <script src="main.js"></script>
</body>


</html>