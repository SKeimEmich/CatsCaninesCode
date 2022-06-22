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

 	
      	
	    <h2>Edit Appointment for ${appointment.pet.name}</h2>
        <div class="content">
          <form method="post">
            <div class="user-details">
                        
              <div class="input-box">
                <span class="details">Date</span>
                <input type="datetime-local" name="date" value="${appointment.date }" required>    
              </div>
              
              <div class="input-box">
                <span class="details">Amount Owed</span>
                <input type="number" step=0.01 value="${appointment.amtOwed }" name="amtOwed" required>
              </div>
              <div class="input-box">
                <span class="details">Amount Paid</span>
                <input type="number" step=0.01 value="${appointment.amtPaid }" name="amtPaid" required>
              </div>
				<input type="hidden" value="${appointment.pet.id }" name="petId">
            <div class="button">
              <input type="submit" value="Update Appointment">
            </div>
            </div>
          </form>
        </div>
<a href="/appointment/view/${appointment.id}" class="btn btn-primary">Back to Appointment</a>

</body>


</html>