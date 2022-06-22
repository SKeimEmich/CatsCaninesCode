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
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/sandstone/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ABdnjefqVzESm+f9z9hcqx2cvwvDNjfrwfW5Le9138qHCMGlNmWawyn/tt4jR4ba"
	crossorigin="anonymous">
</head>


<body>
	<%@ include file="../partials/navigation.jsp"%>
    <%@ include file="../partials/alert.jsp"%>     	
      	
	    <h2>Create a New Pet</h2>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">Pet Name</span>
                <input type="text" placeholder="Enter Pet Name" name="petName" required>
              </div>
              <div class="input-box">
                <span class="details">Date of Birth</span>
                <input type="date" name="petDOB" value="2022-6-22" required>
                
              </div>
              <div class="input-box">
                <span class="details">Pet Species</span>
                <input type="text" placeholder="Enter Pet Species" name="petSpecies" required>
              </div>
              <div class="input-box">
                <span class="details">Pet Description</span>
                <input type="text" placeholder="Enter Pet Description" name="petDescription" required>
              </div>
            </div>
 
            <div class="button">
              <input type="submit" value="Welcome New Pet!">
            </div>
          </form>
        </div>
       <a href="/user/view/${email}" class="btn btn-primary">Back to Owner</a>

</body>


</html>