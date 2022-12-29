<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Lista de Usuarios</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

		<h3>Listado de Usuarios</h3>
      
		<a href="${ urlRoot }usuarios/create" class="btn btn-success" role="button" title="Nuevo Usuario" >Nuevo</a><br><br>
		
		<c:if test="${ msg != null }">
			<div class='alert alert-success' role="alert">${ msg }</div>
		</c:if>
		
		<div class="table-responsive">
		  <table class="table table-hover table-striped table-bordered">
		      <tr>
		          <th>Cuenta</th>
		          <th>Estatus</th>
		          <th>Correo</th>
		          <th>Teléfono</th>
		          <th>Opciones</th>
		      </tr>
		      <c:forEach items="${ usuarios.content }" var="usuario">
		      	<tr>
		           <td>${ usuario.cuenta }</td>
		           <td>
		           		<c:choose>
			           		<c:when test="${ usuario.activo == 1 }">
			           			<span class="label label-success">Activo</span>
			           		</c:when>
			           		<c:otherwise>
			           			<span class="label label-danger">Inactivo</span>
			           		</c:otherwise>
		           		</c:choose>
		           </td>
		           <td>${ usuario.email }</td>
		           <td>${ usuario.telefono }</td>
		           <td>
		               <a href="${ urlRoot }usuarios/update/${ usuario.cuenta }" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
		               <a href="${ urlRoot }usuarios/delete/${ usuario.cuenta }" class="btn btn-danger btn-sm" role="button" title="Eliminar" onclick="return confirm('¿Desea eliminar el registro?')"><span class="glyphicon glyphicon-trash"></span></a>
		           </td>
		       </tr>
		  	</c:forEach>
		  </table>
		  	<nav aria-label="">
				<ul class="pager">
					<li><a href="${ urlRoot }usuarios/index?page=${ peliculas.number -1 }">Anterior</a></li>
					<li><a href="${ urlRoot }usuarios/index?page=${ peliculas.number + 1 }">Siguiente</a></li>
				</ul>
			</nav>
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