<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Crear Banner</title>
	<spring:url value="/" var="urlRoot" />
	<spring:url value="/resources" var="urlPublic" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">
	
	   <h3 class="blog-title"><span class="label label-success">Datos de la imagen</span></h3>
	
	   <form:form action="${ urlRoot }banners/save" method="post" enctype="multipart/form-data" modelAttribute="banner">
	      <div class="row">         
	         <div class="col-sm-6">
	            <div class="form-group">
	               <label for="titulo">Titulo</label>
	               <form:hidden path="id"/>
	               <form:hidden path="archivo"/>
	               <form:input type="text" class="form-control" path="titulo" id="titulo" required="required"/>
	            </div>
	         </div>
	         <div class="col-sm-3">
	            <div class="form-group">
	               <label for="imagen">Imagen</label>
	               <c:choose>
	               		<c:when test="${ banner.id != 0 }">
	               			<input type="file" id="archivoImagen" name="archivoImagen" accept="image/png, image/jpeg" />
	               		</c:when>
	               		<c:otherwise>
	               			<input type="file" id="archivoImagen" name="archivoImagen" required="required" accept="image/png, image/jpeg" />
	               		</c:otherwise>
	               </c:choose>
	               <p class="help-block">Tamaño recomendado: 1140 x 250 </p>
	            </div> 
	         </div> 
	         <div class="col-sm-3">
	            <div class="form-group">
	               <label for="estatus">Estatus</label>             
	               <form:select id="estatus" path="estatus" class="form-control">
	                  <form:option value="Activo">Activo</form:option>
	                  <form:option value="Inactivo">Inactivo</form:option>                
	               </form:select>  
	            </div>
	         </div>
	      </div>
	
	      <button type="submit" class="btn btn-danger" >Guardar</button>
	   </form:form> 
	
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