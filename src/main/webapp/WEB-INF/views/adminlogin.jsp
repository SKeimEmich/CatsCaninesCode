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
        <a href="admin.html">AdminPass</a>
        <a href="#"> - </a>
        <a href="#"> Doug Biske </a>
        <a href="#"> Sam Keim </a>
        <a href="#"> Selwa Alsomairy </a> 
      </div>
      
      <div class="centerbox">
        <div class="title">
           Administration
        </div>
        <form action="#">
           <div class="field">
              <input type="text" required>
              <label>Administration Login</label>
           </div>
           <div class="field">
              <input type="password" required>
              <label>Password</label>
           </div>
           <div class="field"> <br>
            <input type="submit" value="Login">
         </div>
        </form>
     </div>

</body>


</html>
