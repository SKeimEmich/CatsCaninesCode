<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<c:if test="${danger ne null}">
	     <div class="alert alert-danger" role="alert">
			<h4>${danger}</h4>
	  </div>
   	</c:if>      	
	<c:if test="${success ne null}">
	     <div class="alert alert-success" role="alert">
			<h4>${success}</h4>
	  </div>
   	</c:if> 
</div>