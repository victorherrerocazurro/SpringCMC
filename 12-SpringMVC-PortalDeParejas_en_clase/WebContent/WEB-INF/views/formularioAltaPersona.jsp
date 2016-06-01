<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de alta de personas</title>
</head>
<body>
<c:if test="${estado ne null }">
	Se ha dado de alta correctamente el usuario
</c:if>

<form:form commandName="persona" method="POST">
	<form:errors path="*"/>
	<form:label path="nombre"><spring:message code="formulario.persona.label.nombre"/></form:label>
	<form:input path="nombre"/><form:errors path="nombre" />
	<form:label path="apellido"><spring:message code="formulario.persona.label.apellido"/></form:label>
	<form:input path="apellido"/><form:errors path="apellido" />
	<form:label path="altura"><spring:message code="formulario.persona.label.altura"/></form:label>
	<form:input path="altura"/><form:errors path="altura" />
	<form:label path="edad"><spring:message code="formulario.persona.label.edad"/></form:label>
	<form:input path="edad"/><form:errors path="edad" />
	<form:label path="sexo"><spring:message code="formulario.persona.label.sexo"/></form:label>
	<form:radiobuttons path="sexo" items="${listadoSexos}"/><form:errors path="sexo" />
	<input type="submit" value="Enviar"/>
</form:form>
</body>
</html>