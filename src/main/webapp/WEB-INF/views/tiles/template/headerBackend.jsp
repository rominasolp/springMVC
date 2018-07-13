<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Administraci&oacute;n</a>
            </div>
            
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${pageContext.request.contextPath}/">Principal</a>
                    </li>
                </ul>
            
            
            	<ul class="nav navbar-nav navbar-right">
			        
			        <c:if test="${empty loginBean}">
			        <li>
			     		<a href="${pageContext.request.contextPath}/login/form">Login</a>
			     	</li>     	
			     	</c:if>
			     	
			     	<c:if test="${not empty loginBean.username}">
			        <li>
			     		<a href="${pageContext.request.contextPath}/login/out">Logout</a>
			     	</li>     	
			     	</c:if>
			     	
			     	<c:if test="${not empty loginBean.username}">     	
			     	<li>
			     		<a href="#">${loginBean.username}</a>
			        </li>        
			        </c:if>
	        	</ul>
        
			</div>
        </div>
        <!-- /.container -->
    </nav>