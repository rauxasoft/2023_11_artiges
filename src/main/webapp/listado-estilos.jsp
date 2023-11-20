<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common-in-head.jsp"/>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		<h2>Listado de Estilos</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${estilos}" var="juju">
				<tr>
					<td>${juju.codigo}</td>
					<td>${juju.nombre}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>