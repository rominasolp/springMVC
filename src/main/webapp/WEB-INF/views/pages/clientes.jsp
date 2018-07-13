<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>


<c:url var="addAction" value="/admin/cliente/add" ></c:url>

<form:form action="${addAction}" commandName="cliente">

	<c:if test="${!empty cliente.nombre}">

		 <div class="form-group">
    		<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
    		<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
  		</div>
	</c:if>

	<div class="form-group">
		<form:label path="nombre">
			<spring:message text="Nombre:"/>
		</form:label>
	
		<form:input path="nombre" class="form-control" />
	</div>
	
	<div class="form-group">
		<form:label path="apellido">
			<spring:message text="Apellido:"/>
		</form:label>
		
		<form:input path="apellido" class="form-control" />
	</div>

	<c:if test="${!empty cliente.nombre}">
		<input type="submit" value="<spring:message text="Edit cliente"/>"  class="btn btn-default" />
	</c:if>
	<c:if test="${empty cliente.nombre}">
		<input type="submit" value="<spring:message text="Add cliente"/>"  class="btn btn-info" />
	</c:if>	
	
</form:form>

<h3>Lista de clientes</h3>

<c:if test="${!empty listClientes}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">nombre</th>
		<th width="120">apellido</th>
		<th width="60" colspan="2">Operaciones</th>

	</tr>
	<c:forEach items="${listClientes}" var="cliente">
		<tr>
			<td>${cliente.id}</td>
			<td>${cliente.nombre}</td>
			<td>${cliente.apellido}</td>
			<td colspan="2"><a href="<c:url value='/admin/cliente/edit/${cliente.id}' />" >Editar</a>
				<a class="btnEliminar" href="<c:url value='/admin/cliente/remove/${cliente.id}' />" >Borrar</a>
			</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>

<script>
	$(document).ready(function() {
				 
		$('.btnEliminar').on('click', function(event){
			if (!confirm("¿Desea confirmar la eliminación del evento?")) {
				event.preventDefault();
			}
		});
		
	});
	
</script>

