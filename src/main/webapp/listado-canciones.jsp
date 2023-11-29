<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="">
<head>
	<jsp:include page="common-in-head.html"/>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		<h2>Listado de Artistas</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Título</th>
					<th style="text-align: right;">Duración (en segundos)</th>
					<th style="text-align: center;">Explícita</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="cancion" items="${canciones}">
				<tr>
					<td>${cancion.codigo}</td>
					<td>${cancion.titulo}</td>
					
					<td style="text-align: right;">${cancion.horas}:${cancion.minutos}:${cancion.segundos}</td>
					
					<td style="text-align: center;">
						<c:if test="${cancion.explicita}">
							<span style="color:red;">explicita</span>
						</c:if>
						<c:if test="${!cancion.explicita}">
							<span style="color:green;">apta</span>
						</c:if>		
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>