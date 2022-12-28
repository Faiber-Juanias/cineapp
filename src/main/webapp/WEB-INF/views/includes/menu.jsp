<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <sec:authorize access="hasAnyAuthority('EDITOR','GERENTE')">
      	<a class="navbar-brand" href="${ urlRoot }admin/index">My CineSite</a>
      </sec:authorize>
      <sec:authorize access="isAnonymous()">
      	<a class="navbar-brand" href="${ urlRoot }">My CineSite</a>
      </sec:authorize>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
	  	<sec:authorize access="hasAnyAuthority('EDITOR','GERENTE')">
	        <li><a href="${ urlRoot }peliculas/index">Peliculas</a></li>
	        <li><a href="${ urlRoot }horarios/index">Horarios</a></li>
	        <li><a href="${ urlRoot }noticias/index">Noticias</a></li>
        </sec:authorize>
        <sec:authorize access="hasAnyAuthority('GERENTE')">
        	<li><a href="${ urlRoot }banners/index">Banners</a></li>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
	        <li><a href="${ urlRoot }acerca">Acerca</a></li>
	        <li><a href="${ urlRoot }contacto">Contacto</a></li>        
        	<li><a href="${ urlRoot }formLogin">Ingresar</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        	<li><a href="${ urlRoot }logout">Salir</a></li>
        </sec:authorize>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>