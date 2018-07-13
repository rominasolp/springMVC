<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet">
	<link href="<c:url value='/static/css/admin.css' />" rel="stylesheet">
	
	<!-- jQuery -->
    <script src="<c:url value='/static/js/jquery.js' />"></script>
    

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    
</head>
 
<body>

	<tiles:insertAttribute name="header" />

	<!-- Page Content -->
    <div class="container">

        <div class="row cuerpo">                        

			<tiles:insertAttribute name="menu" />		

            <div class="col-md-9">

                <div class="row">
                	<h1><tiles:getAsString name="title" /></h1>
					
					<tiles:insertAttribute name="body" />

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->  

    
</body>
</html>