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
	<title>Crear Usuario</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<h3 class="blog-title"><span class="label label-success">Datos del Usuario</span></h3>  
		
		<form:form action="${ urlRoot }usuarios/save" method="post" modelAttribute="usuario">
			<spring:hasBindErrors name="usuario">
				<div class='alert alert-danger' role='alert'>
					Por favor corrija los siguientes errores:
					<ul>
						<c:forEach items="${ errors.allErrors }" var="error">
							<li><spring:message message="${error}" /></li>
						</c:forEach>
					</ul>
				</div>
			</spring:hasBindErrors>
			<div class="row">         
				<div class="col-sm-3">
					<div class="form-group">
						<label for="perfil" class="control-label">Perfil</label>              
						<select id="perfil" name="perfil" class="form-control">
							<c:forEach items="${ perfiles }" var="perfilv">
								<c:choose>
									<c:when test="${ perfilv == perfil.perfil }">
										<option value="${ perfilv }" selected="selected">${ perfilv }</option>
									</c:when>
									<c:otherwise>
										<option value="${ perfilv }">${ perfilv }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div> 
				</div>
			</div>	
			<div class="row"> 	
				<div class="col-sm-3">
					<div class="form-group">
						<label for="cuenta">Cuenta</label>
						<c:choose>
							<c:when test="${ flag == 'create' }">
			           			<form:input type="text" class="form-control" path="cuenta" id="cuenta" required="required" />
			           		</c:when>
			           		<c:otherwise>
			           			<form:hidden path="pwd"/>
			           			<form:input type="text" class="form-control" path="cuenta" id="cuenta" required="required" readonly="true" />
			           		</c:otherwise>
						</c:choose>
					</div>  
				</div>
				<c:if test="${ flag == 'create' }">
					<div class="col-sm-3">
						<div class="form-group">
							<label for="pwd">Password</label>
				           	<form:password class="form-control" path="pwd" id="pwd" />
						</div>  
					</div>
				</c:if>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="email">Email</label>
						<c:choose>
							<c:when test="${ flag == 'create' }">
			           			<form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
			           		</c:when>
			           		<c:otherwise>
			           			<form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" />
			           		</c:otherwise>
						</c:choose>
					</div>  
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="telefono">Teléfono</label>
						<c:choose>
							<c:when test="${ flag == 'create' }">
			           			<form:input type="text" class="form-control" path="telefono" id="telefono" required="required"/>
			           		</c:when>
			           		<c:otherwise>
			           			<form:input type="text" class="form-control" path="telefono" id="telefono" />
			           		</c:otherwise>
						</c:choose>
					</div>  
				</div>
				<c:if test="${ flag != 'create' }">
					<div class="col-sm-3">
						<div class="form-group">
							<label for="activo">Estatus</label>
		           			<form:select path="activo" class="form-control" id="activo">
		           				<form:option value="1">Activo</form:option>
		           				<form:option value="0">Inactivo</form:option>
		           			</form:select>
						</div>  
					</div>
				</c:if>
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