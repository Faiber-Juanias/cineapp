<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Ingresar | CineApp</title>
	<spring:url value="/" var="urlRoot" />
	<spring:url value="/resources" var="urlPublic" />
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/theme.css">
</head>
<body>
	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	<div class="container" role="main" style="width: max-content;padding-top: inherit;">
		<form class="form-horizontal" action="${ urlRoot }login" method="post">
			<div class="form-group">
				<img src="${ urlPublic }/images/login.png" width="136" height="136" class="col-sm-offset-3">
			</div>
			<div class="form-group">
				<h3 class="col-sm-offset-3">CineApp | Administración</h3>
			</div>
			<div class="form-group">
			    <label for="username" class="col-sm-3 control-label">Usuario</label>
			    <div class="col-sm-9">
			    	<input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
			    </div>
			</div>
			<div class="form-group">
			    <label for="password" class="col-sm-3 control-label">Password</label>
			    <div class="col-sm-9">
			    	<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
			    </div>
			</div>
			<div class="form-group">
			    <div class="col-sm-offset-3 col-sm-9">
			    	<button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
			    </div>
		  	</div>
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }"/>
		</form>
	</div> <!-- /container -->
	<!-- Bootstrap core JavaScript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>