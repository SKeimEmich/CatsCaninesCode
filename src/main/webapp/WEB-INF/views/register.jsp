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
    <link rel="stylesheet" href="/cnc.css">
</head>


<body>
    
    <div class="sidenav">
        <a href="index2.html">Cats & Canines </a> <!--will add a logo here once I draw it out-->
        <a href="adminpetpage.html">Pet Page Edit</a>
        <a href="register.html">Register New</a> 
        <a href="#"> - </a>
        <a href="#"> Doug Biske </a>
        <a href="#"> Sam Keim </a>
        <a href="#"> Selwa Alsomairy </a> 
      </div>
      
      <div>
		<h4>${message}</h4>
	  </div>
			
      
      <div class="container">
        <div class="title">Animal Registration</div>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">Pet Parent Full Name</span>
                <input type="text" placeholder="Enter Parent name" name="ownerName" required>
              </div>
              <div class="input-box">
                <span class="details">Email Address</span>
                <input type="text" placeholder="Enter parent contact email" name="email" required>
              </div>
              <div class="input-box">
                <span class="details">Pet Name</span>
                <input type="text" placeholder="What do we call our new friend?" name="petName" required>
              </div>
              <div class="input-box">
                <span class="details">Password</span>
                <input type="hidden" placeholder="Choose a password" name="password"  required>
              </div>
            </div>
            <div class="history">
              <input type="radio" name="history" id="dot-1">
              <input type="radio" name="history" id="dot-2">
              <input type="radio" name="history" id="dot-3">
              <span class="history-title">Past Vet History</span>
              <div class="category">
                <label for="dot-1">
                <span class="dot one"></span>
                <span class="history">Yes</span>
              </label>
              <label for="dot-2">
                <span class="dot two"></span>
                <span class="history">No</span>
              </label>
              <label for="dot-3">
                <span class="dot three"></span>
                <span class="history">Not Sure</span>
                </label>
              </div>
            </div>
            <div class="button">
              <input type="submit" value="Welcome To The Family!">
            </div>
          </form>
        </div>
      </div>

</body>


</html>