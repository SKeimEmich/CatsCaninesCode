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
     	
      	
	    <h2>Update Entry for ${pet.name }</h2>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">Pet Name</span>
                <input type="text" value="${pet.name }" name="petName" required>
              </div>
              <div class="input-box">
                <span class="details">Date of Birth</span>
                <input type="date" value="${pet.dateOfBirth }" name="petDOB" required>
                
              </div>
              <div class="input-box">
                <span class="details">Pet Species</span>
                <input type="text" value="${pet.species }" name="petSpecies" required>
              </div>
              <div class="input-box">
                <span class="details">Pet Description</span>
                <input type="text" value="${pet.description }" name="petDescription" required>
              </div>
              <input type="hidden" value="${pet.user.email }" name="email">
            </div>
 
            <div class="button">
              <input type="submit" value="Update Pet">
            </div>
          </form>
        </div>
<a href="/pet/view/${pet.id}" class="btn btn-primary">Return to View Pet</a> 
</body>


</html>