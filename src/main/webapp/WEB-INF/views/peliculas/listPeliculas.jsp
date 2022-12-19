<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Lista de Peliculas</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>
      
		<a href="${ urlRoot }peliculas/create" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
		
		<c:if test="${ msg != null }">
			<div class='alert alert-success' role="alert">${ msg }</div>
		</c:if>
		
		<div class="table-responsive">
		  <table class="table table-hover table-striped table-bordered">
		      <tr>
		          <th>Titulo</th>
		          <th>Genero</th>
		          <th>Clasificacion</th>
		          <th>Duracion</th>
		          <th>Fecha Estreno</th>
		          <th>Estatus</th>
		          <th>Opciones</th>
		      </tr>
		      <c:forEach items="${ peliculas }" var="pelicula">
		      	<tr>
		           <td>${ pelicula.titulo }</td>
		           <td>${ pelicula.genero }</td>
		           <td>${ pelicula.clasificacion }</td>
		           <td>${ pelicula.duracion } min.</td>
		           <td><fmt:formatDate value="${ pelicula.fechaEstreno }" pattern="dd-MM-yyyy" /></td>
		           <td>
		           	<c:choose>
		           		<c:when test="${ pelicula.estatus == 'Activa' }">
		           			<span class="label label-success">${ pelicula.estatus }</span>
		           		</c:when>
		           		<c:otherwise>
		           			<span class="label label-danger">${ pelicula.estatus }</span>
		           		</c:otherwise>
		           	</c:choose>
		           </td>
		           <td>
		               <a href="${ urlRoot }peliculas/update/${ pelicula.id }" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
		               <a href="${ urlRoot }peliculas/delete/${ pelicula.id }" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
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