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
		<h2>Listado de Artistas</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Fecha de Nacimiento</th>
					<th>Fecha de Defunción</th>
					<th>Nacionalidad</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${artistas}" var="artista">
				<tr>
					<td>${artista.codigo}</td>
					<td>${artista.nombre}</td>
					<td><fmt:formatDate value="${artista.fechaNacimiento}" pattern="dd/MM/yyyy"/></td>
					<td>
					<c:if test="${artista.fechaDefuncion != null}">
						<fmt:formatDate value="${artista.fechaDefuncion}" pattern="dd/MM/yyyy"/>
					</c:if>
					<c:if test="${artista.fechaDefuncion == null}">
						<span>---</span>
					</c:if>
					</td>
					<td>${artista.nacionalidad}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>