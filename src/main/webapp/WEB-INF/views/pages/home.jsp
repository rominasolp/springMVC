<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<c:forEach items="${listaDeEventos}" var="evento">
     	
	<div class="col-sm-4 col-lg-4 col-md-4">
	
	     <div class="thumbnail">
	         <img src="http://placehold.it/320x150" alt="">
	         <div class="caption">
	             <h4 class="pull-right">${evento.precio}</h4>
	             <h4>
	             <a href="<c:url value='/evento/${evento.id}' />" >${evento.nombreEvento}</a>
	             </h4>
	             <p>
	             ${evento.descripcion}
	             </p>
	         </div>
	         <div class="ratings">
	             <p class="pull-right">15 reviews</p>
	             <p>
	                 <span class="glyphicon glyphicon-star"></span>
	                 <span class="glyphicon glyphicon-star"></span>
	                 <span class="glyphicon glyphicon-star"></span>
	                 <span class="glyphicon glyphicon-star"></span>
	                 <span class="glyphicon glyphicon-star"></span>
	             </p>
	         </div>
	     </div>
	     
	 </div>
    		
   	</c:forEach>    

 