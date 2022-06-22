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
	<link rel="stylesheet" type="text/css" href="main.css">
    <title>Cats and Canines</title>
</head>


<body>
	<%@ include file="../partials/navigation.jsp"%>
<main>
<!-- MAIN BANNER -->
<section class="banner">
	<div class="container">
		<h1>
			Cats <br class ="hide-mob"/>
			<span> & Canines </span>
			<h3> Doug B., Sam K., Selwa A. | COSC 471 </h3>
			<a href="#contact" class="button">Contact Us</a>
		</h1>
	</div>
</section>

<!-- ABOUT  -->
<section id="about" class="profile">
	<div class="container">
		<h2>About Us</h2>
		<div class="about-grid">
			<div class="about">
				<div class="content">
					<h3>About Us</h3>
					<p>
						Hello, we are Cats and Canines! We are a Veterinary clinic and we pride ourselves
						in providing compassionate care to your loved ones... Extra random words that 
						describe other things that we do. We are great: 10x better than Selwa's vet's office.
					</p>
				</div>
			</div>
			<div class="about">
				<div class="content">
					<h3>COSC 471</h3>
					<p>
						HERE WE WILL ADD WHAT TECHNOLOGY WE ARE USING
						TO DO OUR PROJECT AS WELL AS ADD WHATEVER 
						THE SITE CAN DO / NOT DO AS OF RN
					</p>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- SERVICES -->
<section id="services" class="services">
	<div class="container">
		<h2>Services</h2>

			<div class="services-grid">

				<div class="service">
					<figure class="img-box">
						<img src="vetservice.jpeg" alt=" " class="img"/>
					</figure>
					<div class="content">
						<h3>Veterinary Services</h3>
						 <p>
							Whether its wellness care, surgery, dentistry or 
							you just have an exotic pet- we have you covered.
							We provide advanced medicine and treatements that 
							are tailored to your pet specifically.
						</p>
					</div>
				</div>

				<div class="service">
					<figure class="img-box">
						<img src="onlineport.jpeg" alt=" " class="img"/>
					</figure>
					<div class="content">
						<h3>Online Portal</h3>
						 <p>
							We offer an online portal for you to book an 
							appointment, message us directly about your 
							loved ones, and check in to see which shots 
							your loved one has and needs in the near future.
							This feature allows you to have your loved 
							one's information with you always.
						</p>
					</div>
				</div>

				<div class="service">
					<figure class="img-box">
						<img src="clientedu.jpeg" alt=" " class="img"/>
					</figure>
					<div class="content">
						<h3>Client Education</h3>
						 <p>
							Need help with your little one? 
							Not sure how to properly care for your pet? 
							Well... why did you adopt it? -CHANGE-
						</p>
					</div>
				</div>

		</div>
	</div>
</section>

<!-- CONTACT -->
<section class="contact" id="contact">
	<div class="container">
		<h2>Contact</h2>

			<form>
			<div class="form-grid">
				<input type="text" name="Name" id="Name" placeholder="Name" class="form-element"/>
				<input type="text" name="Email" id="Email" placeholder="Email" class="form-element"/> 
				<textarea name="message" id="message" placeholder="Message" class="form-area"></textarea> 
			</div>
			<div class="right-align">
			<input type="submit" value="Send Message" class="button">
			</div>
		</form>
	</div>
</section>

</main>

<script src="main.js"></script>
</body>
</html>