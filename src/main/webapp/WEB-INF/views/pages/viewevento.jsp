<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

 
<%--  evento:<spring:message text="${tipoDeEvento.id}" /> --%>
 
 <div class="row"> 
 <div class="col-md-4 column productbox">
    <img src="http://placehold.it/460x250/e67e22/ffffff&text=HTML5" class="img-responsive">
    <h1 class="title">${evento.nombreEvento}</h1>
    <span>
    	<h2>${tipoDeEvento.nombre}</h2>
    	<p>${evento.descripcion}
    	</p>
    </span>
    <div class="productprice">
    	<div class="pull-right">
    		<a href="#" class="btn btn-danger btn-sm" role="button">BUY</a>
    	</div>
    	<div class="pricetext">$ ${evento.precio}</div>
    </div>
</div>
</div>