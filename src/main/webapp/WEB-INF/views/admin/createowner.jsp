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
    <link rel="stylesheet" type="text/css" href="style.css">
</head>


<body>
    
    <ul class="nav">
    	<li class="nav-item">
        	<a class="nav-link" href="index2">Cats & Canines </a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="adminpetpage">Pet Page Edit</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="register">Register New</a> 
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="userlookup">User Lookup</a> 
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#"> - </a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#"> Doug Biske </a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#"> Sam Keim </a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#"> Selwa Alsomairy </a> 
        </li>
      </ul>
      
			
      
      <div class="container">
		<c:if test="${message ne null}">
	      <div class="alert alert-success" role="alert">
				<h4>${message}</h4>
		  </div>
      	</c:if>      	
      	
	    <h2>Create a New Owner</h2>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">New Owner Full Name</span>
                <input type="text" placeholder="Enter New Owner Full Name" name="ownerName" required>
              </div>
              <div class="input-box">
                <span class="details">Email Address</span>
                <input type="text" placeholder="Enter New Owner Contact Email" name="ownerEmail" required>
              </div>
              <div class="input-box">
                <span class="details">Address</span>
                <input type="text" placeholder="Enter New Owner Address" name="ownerAddress" required>
              </div>
              <div class="input-box">
                <span class="details">Phone Number</span>
                <input type="text" placeholder="Enter New Owner Phone Number" name="ownerPhoneNumber" required>
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
        </div>
      </div>

</body>


</html>