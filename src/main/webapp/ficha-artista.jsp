<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common-in-head.html"/>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		<h2>Ficha Artista</h2>
		<table class="table">
			<tr>
				<th style="text-align: right;">Código</th>
				<td>${artista.codigo}</td>
			</tr>
			<tr>
				<th style="text-align: right;">Nombre</th>
				<td>${artista.nombre}</td>
			</tr>
			<tr>
				<th style="text-align: right;">Fecha Nacimiento</th>
				<td><fmt:formatDate value="${artista.fechaNacimiento}" pattern="dd/MM/yyyy"/></td>
			</tr>
			<tr>
				<th style="text-align: right;">Fecha Defunción</th>
				<td>
					<c:if test="${artista.fechaDefuncion != null}">
						<fmt:formatDate value="${artista.fechaDefuncion}" pattern="dd/MM/yyyy"/>
					</c:if>
					<c:if test="${artista.fechaDefuncion == null}"><span>---</span></c:if>
				</td>
			</tr>
			<tr>
				<th style="text-align: right;">Activo</th>
				<td>
					<c:choose>
						<c:when test="${artista.activo}"><span style="color:green;">Sí</span></c:when>
						<c:otherwise><span style="color:red;">No</span></c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th style="text-align: right;">Nacionalidad</th>
				<td>${artista.nacionalidad}</td>
			</tr>
			<tr>
				<th style="text-align: right;">Puntos</th>
				<td>
					<input disabled="disabled" type="range" min="0" max="100" value="${artista.puntos}"/>
				</td>
				<!--  
				<td>
					<c:forEach begin="1" step="5" end="${artista.puntos}">
						<span>*</span>
					</c:forEach>
					<span> (${artista.puntos})</span>
				</td>
				-->
			</tr>
			<tr>
				<th style="text-align: right;">Observaciones</th>
				<td>${artista.observaciones}</td>
			</tr>
			<tr>
				<th style="text-align: right;">Estilos</th>
				<td>
					<c:forEach items="${artista.estilos}" varStatus="estado"  var="estilo">
						<span>${estilo.nombre}<c:if test="${!estado.last}">, </c:if></span>
					</c:forEach>
				</td>
			</tr>
		</table>	
	</div>
</body>
</html>