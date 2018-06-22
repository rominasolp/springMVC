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
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
</head>
 
<body>

	<tiles:insertAttribute name="header" />
	<tiles:importAttribute name="showCarrusel"/>
	
	<!-- Page Content -->
    <div class="container">

        <div class="row">                        

			<tiles:insertAttribute name="menu" />
		
            <div class="col-md-9">
				
				<c:if test="${showCarrusel == 'SI'}">
    			
								
					<div id="myCarousel" class="row carousel-holder slide" data-interval="2300">
	                
	                    <div class="col-md-12">
	                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	                            <ol class="carousel-indicators">
	                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	                            </ol>
	                            <div class="carousel-inner">
	                                <div class="item active">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/static/img/teatro.jpg" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/static/img/cine.jpg" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/static/img/recital.jpg" alt="">
	                                </div>
	                            </div>
	                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
	                                <span class="glyphicon glyphicon-chevron-left"></span>
	                            </a>
	                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
	                                <span class="glyphicon glyphicon-chevron-right"></span>
	                            </a>
	                        </div>
	                    </div>
	
	                </div>
				
				
				</c:if>
				
                <div class="row">

					<tiles:insertAttribute name="body" />

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

	<tiles:insertAttribute name="footer" />
  
    <!-- jQuery -->
    <script src="<c:url value='/static/js/jquery.js' />"></script>
    

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    
    <script>
    
    $(document).ready(function(){    
    	
    	// Activate Carousel
        //$("#myCarousel").carousel();
        //$("#myCarousel").carousel("cycle");
        
    	
    });
    
    
    
    </script>
</body>
</html>