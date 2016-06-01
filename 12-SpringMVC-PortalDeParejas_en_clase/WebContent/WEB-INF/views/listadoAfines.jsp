<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="titulo.busqueda.afines" arguments="12,13"/></title>
<link rel="stylesheet" type="text/css" href='<spring:theme code="css"/>'/>
</head>
<body>
	<span><a href="?id=1&idioma=es">es</a> | <a href="?id=1&idioma=en">en</a></span>
	<span><a href="?id=1&tema=verde">verde</a> | <a href="?id=1&tema=azul">azul</a></span>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Sexo</th>
			<th>Altura</th>
		</tr>
		<c:forEach items="${afines}" var="persona">
			<tr>
				<td>${persona.nombre}</td>
				<td>${persona.apellido}</td>
				<td>${persona.edad}</td>
				<td>${persona.sexo}</td>
				<td>${persona.altura}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>