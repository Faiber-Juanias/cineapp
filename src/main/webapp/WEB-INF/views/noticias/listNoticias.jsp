<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Lista de Noticias</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Noticias</h3>
      
      <a href="${ urlRoot }noticias/create" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
     	<c:if test="${ msg != null }">
			<div class='alert alert-success' role="alert">${ msg }</div>
		</c:if>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Fecha</th>              
                <th>Estatus</th>              
                <th>Opciones</th>              
            </tr>
            <c:forEach items="${ noticias.content }" var="noticia">
	            <tr>
	                <td>${ noticia.id }</td>
	                <td>${ noticia.titulo }</td>
	                <td><fmt:formatDate value="${ noticia.fecha }" pattern="dd-MM-yyyy" /></td>              
	                <td>
	                	<c:choose>
	                		<c:when test="${ noticia.estatus == 'Activa' }">
	                			<span class="label label-success">${ noticia.estatus }</span>
	                		</c:when>
	                		<c:otherwise>
	                			<span class="label label-danger">${ noticia.estatus }</span>
	                		</c:otherwise>
	                	</c:choose>
	                </td>
	                <td>
	                    <a href="${ urlRoot }noticias/update/${ noticia.id }" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
	                    <a href="${ urlRoot }noticias/delete/${ noticia.id }" class="btn btn-danger btn-sm" role="button" title="Eliminar" onclick="return confirm('¿Eliminar Noticia?')" ><span class="glyphicon glyphicon-trash"></span></a>
	                </td>
	            </tr>
            </c:forEach>
        </table>
        <nav>
			<ul class="pager">
				<li><a href="${ urlRoot }noticias/index?page=${ noticias.number -1 }">Anterior</a></li>
				<li><a href="${ urlRoot }noticias/index?page=${ noticias.number + 1 }">Siguiente</a></li>
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