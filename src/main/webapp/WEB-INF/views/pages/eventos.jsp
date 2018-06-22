<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<c:url var="addAction" value="/admin/evento/add" ></c:url>
	
<form:form action="${addAction}" commandName="evento">

	<c:if test="${!empty evento.nombreEvento}">

		 <div class="form-group">
    		<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
    		<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
  		</div>
	</c:if>

	<div class="form-group">
		<form:label path="idTipoDeEvento">
			<spring:message text="Tipo de evento"/>
		</form:label>
			
	<form:select path="idTipoDeEvento"  class="form-control" id="cmbTipo">
    	<form:option value="0" label="Seleccione un tipo de evento" />
    	<c:forEach items="${listTipoDeEventos}" var="tip">
    		<option value="${tip.id}" >${tip.nombre}</option>    		
    	</c:forEach>    
	</form:select>

<%-- 	<spring:message text="${evento.idTipoDeEvento}"/> --%>
	</div>
			
	<div class="form-group">
		<form:label path="nombreEvento">
			<spring:message text="Nombre"/>
		</form:label>
	
		<form:input path="nombreEvento" class="form-control" />
	</div>

	<div class="form-group adicionales groupteatro" >
		<label >Género de teatro</label>
		<select class="form-control cmbTeatro" name="generoteatro">
			<option value="Musical" >Musical</option>
			<option value="Drama" >Drama</option>
			<option value="Comedia" >Comedia</option>
		</select>
	</div>	
	
	<div class="form-group adicionales groupmusica" >
		<label >Género de música</label>
		<select class="form-control cmbEstilo" name="generomusica">
			<option value="Rock" >Rock</option>
			<option value="Pop" >Pop</option>
			<option value="Reggae" >reggae</option>
		</select>
	</div>
	
	<div class="form-group adicionales grouppelicula" >
		<label >Género de la película</label>
		<select class="form-control cmbGenero" name="generocine">
			<option value="Terror" >Terror</option>
			<option value="Acción" >Acción</option>
			<option value="Drama" >Drama</option>
			<option value="Comedia" >Comedia</option>
		</select>
	</div>
	
	<div class="form-group adicionales groupdeporte" >
		<label >Tipo de espectáculo</label>
		<select class="form-control cmbTipoDeporte" name="tipodeporte">
			<option value="Fútbol" >Fútbol</option>
			<option value="Básquet" >Básquet</option>
			<option value="Handball" >Handball</option>
			<option value="Tenis" >Tenis</option>
		</select>
	</div>
	
	<div class="form-group">
		<form:label path="precio">
			<spring:message text="Precio"/>
		</form:label>
	
		<form:input path="precio" class="form-control" />
	</div>
	
	<div class="form-group">
		<form:label path="descripcion">
			<spring:message text="Descripción"/>
		</form:label>
		
		<form:textarea rows="5" path="descripcion" class="form-control" />
	</div>
	
	<div class="form-group">
		<form:label path="stock">
			<spring:message text="Cantidad disponible"/>
		</form:label>
		
		<form:input path="stock" class="form-control" />
	</div>

	<div class="form-group">
		<form:label path="fechaDesde">
			<spring:message text="Fecha de inicio"/>
		</form:label>
		
		<form:input type="date" path="fechaDesde" class="form-control" />
	</div>
	
	<div class="form-group">
		<form:label path="fechaHasta">
			<spring:message text="Fecha de fin del evento"/>
		</form:label>
		
		<form:input type="date" path="fechaHasta" class="form-control" />
	</div>
	
	<div class="form-group">
		<form:label path="direccion">
			<spring:message text="Dirección"/>
		</form:label>
		
		<form:input path="direccion" class="form-control" />
	</div>	
		
	<c:if test="${!empty evento.nombreEvento}">	
		<input type="submit" value="<spring:message text="Editar evento"/>"  class="btn btn-default" />
	</c:if>
	<c:if test="${empty evento.nombreEvento}">
		<input type="submit" value="<spring:message text="Agregar evento"/>"  class="btn btn-info" />
	</c:if>	
	
</form:form>

<h3>Lista de Eventos</h3>

<c:if test="${!empty listEventos}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="120">Precio</th>
		<th width="120">descripcion</th>
		<th width="120">stock</th>
		<th width="120">fecha desde</th>
		<th width="120">fecha hasta</th>
		<th width="120">direccion</th>
		<th width="60" colspan="2">Operaciones</th>

	</tr>
	<c:forEach items="${listEventos}" var="evento">
		<tr>
			<td>${evento.id}</td>
			<td>${evento.nombreEvento}</td>			
			<td>${evento.precio}</td>
			<td>${evento.descripcion}</td>
			<td>${evento.stock}</td>
			<td>${evento.fechaDesde}</td>
			<td>${evento.fechaHasta}</td>
			<td>${evento.direccion}</td>
			<td colspan="2"><a href="<c:url value='/admin/evento/edit/${evento.id}' />" >Editar</a>
				<a href="<c:url value='/admin/evento/remove/${evento.id}' />" >Borrar</a>
			</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>

<br>
<hr>

<script>
	$(document).ready(function() {
		$(".adicionales").hide();
		
		$("#cmbTipo option[value=<spring:message text="${evento.idTipoDeEvento}"/>]").attr('selected','selected');

		$( "#cmbTipo" ).change(function() {
			console.log($( "#cmbTipo option:checked" ).text());
			$(".adicionales").hide();
			
			switch($("#cmbTipo option:checked" ).text().toLowerCase()) {
		    	case "teatro":
		    		$(".groupteatro").show();
		        break;
		    	case "música":			    		
		    		$(".groupmusica").show();
		        break;
		    	case "película":
		    		$(".grouppelicula").show();
			        break;
		    	case "deporte":
		    		$(".groupdeporte").show();
			        break;
		    	default:		        
			}				
		});
		
	});
	
</script>