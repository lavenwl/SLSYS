<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="utf-8">
	    <title>SL批发交易平台 V1.0</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="laven">
		<link rel="stylesheet" href="assets/css/orderAdd/reset.css"> <!-- CSS reset -->
		<link rel="stylesheet" href="assets/css/orderAdd/style.css"> <!-- Gem style -->
		<script src="assets/js/orderAdd/modernizr.js"></script> <!-- Modernizr -->
	</head>
	<body>
		<header>
			<div id="logo"><img src="assets/img/orderAdd/cd-logo.svg" alt="Homepage"></div>
	
			<div id="cd-hamburger-menu"><a class="cd-img-replace" href="#0">Menu</a></div>
			<div id="cd-cart-trigger"><a class="cd-img-replace" href="#0">Cart</a></div>
		</header>
	
		<nav id="main-nav">
			<ul>
				<li><a href="#0">Home</a></li>
				<li><a href="#0">About</a></li>
				<li><a class="current" href="#0">Services</a></li>
				<li><a href="#0">Gallery</a></li>
				<li><a href="#0">Contact</a></li>
			</ul>
		</nav>
	
		<main>
			<ul id="cd-gallery-items" class="cd-container">
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
					
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
	
				<li>
					<img src="assets/img/orderAdd/thumb.jpg" alt="Preview image">
				</li>
			</ul> <!-- cd-gallery-items -->
		</main>
	
		<div id="cd-shadow-layer"></div>
	
		<div id="cd-cart">
			<h2>Cart</h2>
			<ul class="cd-cart-items">
				<li>
					<span class="cd-qty">1x</span> Product Name
					<div class="cd-price">$9.99</div>
					<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
				</li>
	
				<li>
					<span class="cd-qty">2x</span> Product Name
					<div class="cd-price">$19.98</div>
					<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
				</li>
	
				<li>
					<span class="cd-qty">1x</span> Product Name
					<div class="cd-price">$9.99</div>
					<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
				</li>
			</ul> <!-- cd-cart-items -->
	
			<div class="cd-cart-total">
				<p>Total <span>$39.96</span></p>
			</div> <!-- cd-cart-total -->
	
			<a href="#0" class="checkout-btn">Checkout</a>
			
			<p class="cd-go-to-cart"><a href="#0">Go to cart page</a></p>
		</div> <!-- cd-cart -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/orderAdd/main.js"></script> <!-- Gem jQuery -->
	</body>
</html>
