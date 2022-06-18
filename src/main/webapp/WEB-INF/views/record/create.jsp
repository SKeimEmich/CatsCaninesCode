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
      
			
	<%@ include file="../partials/alert.jsp"%>
     	
	    <h2>Add Record</h2>
	    <h3>Appointment for ${appointment.pet.name} on ${appointment.date}</h3>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">Service Code</span>
                <input type="text" placeholder="Enter service code" name="serviceCode" required>
              </div>
              <div class="input-box">
                <span class="details">Description</span>
                <input type="text" placeholder="Enter record description" name="description" required>
              </div>              
              <div class="input-box">
                <span class="details">Date</span>
                <input type="date" name="renewalDate" value="2022-6-22" required>    
              </div>
              <div class="input-box">
                <span class="details">Cost</span>
                <input type="number" step=0.01 placeholder="Enter cost" name="cost" required>
              </div>
            </div>
            
            <div class="button">
              <input type="submit" value="Welcome To The Family!">
            </div>
          </form>
        </div>
<a href="/appointment/view/${appointment.id}" class="btn btn-primary">Back to Appointment</a>
</body>


</html>