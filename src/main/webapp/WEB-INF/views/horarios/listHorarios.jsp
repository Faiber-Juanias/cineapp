<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Lista de Horarios</title>
	<spring:url value="/" var="urlRoot" />
	<spring:url value="/resources" var="urlPublic" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Horarios</h3>
      
      <a href="${ urlRoot }horarios/create" class="btn btn-success" role="button" title="Nueva Horario" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Pelicula</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Sala</th>
                <th>Precio</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${ horarios }" var="horario">
	            <tr>
	                <td>titulo</td>
	                <td><fmt:formatDate value="${ horario.fecha }" pattern="dd-MM-yyyy" /></td>
	                <td>${ horario.hora }</td>
	                <td>${ horario.sala }</td>
	                <td>${ horario.precio }</td>              
	                <td>
						<a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="#" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a>
					</td>
	            </tr>
            </c:forEach>
        </table>
      </div>
      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>