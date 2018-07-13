<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
  
  <c:url var="loguearse" value="/login/in" ></c:url>
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form:form id="loginForm" method="post" action="${loguearse}" 
        	modelAttribute="loginBean" role="login">
          <h1>Ticketero login</h1>
          
          <form:input id="username" name="username" path=""
          	placeholder="Nombre de usuario" class="form-control input-lg" />
          <br>
          
          <form:password id="password" name="password" path="" 
          placeholder="Contraseña de usuario" class="form-control input-lg" />
          <br>
                    
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Ingresar</button>
          <br>
          
          <div>
            <a href="#">Crear una cuenta</a> o <a href="#">Resetear contraseña</a>
          </div>
          
       </form:form>
       
       <font color="red">${message}</font>
      </section>  
      </div>
      
      <div class="col-md-4"></div>

  </div>
  
  <script>
	$(document).ready(function() {
		$("#username").attr('required', '');
		$("#password").attr('required', '');

		$("#username").focus();
	});
   </script>
 
