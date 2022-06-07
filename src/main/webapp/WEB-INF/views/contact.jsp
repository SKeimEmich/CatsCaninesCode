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
    <link rel="stylesheet" href="cnc.css">
</head>

<body>
    
  <div class="sidenav">
    <a href="index.html">Cats & Canines </a> <!--will add a logo here once I draw it out-->
    <!-- <a href="about.html">About</a> -->
    <!-- <a href="services.html">Services</a> -->
    <a href="login.html">Login</a>
    <a href="adminlogin.html">Admin</a>   
    <a href="contact.html">Contact</a>
    <a href="#"> - </a>
    <a href="#"> Doug Biske </a>
    <a href="#"> Sam Keim </a>
    <a href="#"> Selwa Alsomairy </a> 
  </div>

      
      <div class="centerbox">
        <div class="title">
           Contact Us
        </div>
        <form action="#">
           <div class="field">
              <input type="text" required>
              <label>Name</label>
           </div>
           <div class="field">
              <input type="password" required>
              <label>Email Address</label>
           </div>
           <div class="field">
            <input type="message" required>
            <label>How Can We Help?</label><br>
            We are happy to hear from you and will get back to you as soon as possible.
         </div>
           <div class="field"> <br><br><br><br>
              <input type="submit" value="Submit">
           </div>
        </form>
     </div>


</body>


</html>