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
	    <h2>User Edit</h2>
        <div class="content">
          <form method="post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">Full Name</span>
                <input type="text" name="ownerName" value="${user.name }" required>
              </div>
              <div class="input-box">
                <span class="details">Email Address</span>
                <input type="text" value="${user.email }"  name="ownerEmail" required>
              </div>
              <div class="input-box">
                <span class="details">Address</span>
                <input type="text" value="${user.address }" name="ownerAddress" required>
              </div>
              <div class="input-box">
                <span class="details">Phone Number</span>
                <input type="text" value="${user.phone }" name="ownerPhoneNumber" required>
              </div>
                <input type="hidden" value="${user.password }" name="ownerPassword"  required>
            </div>
            
            
		<c:if test="${user.acctType eq 'staff'}">
            <div class="history">
              <input type="radio" name="history" id="dot-1" value="staff" checked>
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
		</c:if>
		<c:if test="${user.acctType eq 'client'}">
            <div class="history">
              <input type="radio" name="history" id="dot-1" value="staff">
              <input type="radio" name="history" id="dot-2" value="client" checked>
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
		</c:if>
            <div class="button">
              <input type="submit" value="Submit Changes">
            </div>
            </form>
       <a href="/user/view/${user.email}" class="btn btn-primary">Back to Owner</a>

        </div>
</body>


</html>