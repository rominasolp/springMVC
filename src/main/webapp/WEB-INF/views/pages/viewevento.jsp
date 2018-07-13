<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<%--
<spring:message text="${id}" />
  --%>
  
 <div class="row"> 
	 <form:form action="/venta/add" commandName="venta">
	 <div class="col-md-4 column productbox">
	    <img src="http://placehold.it/460x250/e67e22/ffffff&text=HTML5" class="img-responsive">
	    <h1 class="title">${evento.nombreEvento}</h1>
	
	    	<h2>${tipoDeEvento.nombre}</h2>
	    	<p>${evento.descripcion}
	    	</p>
	    <div class="productprice">
	    	<div class="pull-right">
	    		<a href="#" class="btn btn-danger btn-sm" role="button">Comprar</a>
	    	</div>
	    	<div class="pricetext">$ ${evento.precio}</div>
	    </div>
	
	</div>
	</form:form>

</div>
