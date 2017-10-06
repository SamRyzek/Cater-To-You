<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cater To You - ${company.name}</title>
</head>
<body class="active">
	<div id="nav-bar">
		<ul>
            <li><a href="showCart.do">Go To Cart</a></li>
            <li style="float: right"><a href="customer.do">Return Home</a></li>
            <li style="float: right"><a href="loggOut.do">Log Out</a></li>
        </ul>
	</div>
    <div id="main-section">    
    <div class="row">
    <div class="col-6">
        <h3>${company.name}</h3>
        <p>${address.street} ${address.street2} ${address.city}
        ${address.state} ${address.zip}</p>

        <c:forEach items="${menu}" var="item">
                <strong>${item.name}</strong><br>
                ${item.description}
                <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.price}"/>$

         <form action="addToCart.do" method="POST">
                <input type="hidden" name="itemId" value="${item.id}"> <input
                    type="hidden" name="company" value="${company.id}">
                Quantity <input type="number" name="quantity" value="1" /><input
                    type="submit" value="Add to Cart" />
            </form>
        </c:forEach>
    </div>
    <div class="col-6">
        <ul>
            <c:forEach items="${itemList}" var="item">
                <li>${item.count} ${item.item.name} 
                <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.item.price}"/>$
                <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.item.price * item.count}"/>$
                </li>
            </c:forEach>
        </ul>
        <p>Sub Total: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${subTotal}"/>$</p>
        <p>Tax: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tax}"/>$</p>
        <p>Fee: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${fee}"/>$</p>
        <p>Total: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tax}"/>$</p>
        
    </div>
    </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script>
        window.jQuery
                || document.write('<script src="js/jquery.min.js"><\/script>')
    </script>

    <script src="js/holder.js"></script>

    <script src="js/bootstrap.min.js"></script>
</body>
</html>