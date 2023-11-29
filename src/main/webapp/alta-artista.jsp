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
		<h2>Alta Artista</h2>
		<form method="POST" action="alta-artistas">
			<table>
				<tr>
					<th>Nombre</th>
					<td><input type="text" name="nombre"/></td>
				</tr>
				<tr>
					<th>Nacionalidad</th>
					<td><input type="text" name="nacionalidad"/></td>
				</tr>
				<tr>
					<th>Fecha de nacimiento</th>
					<td><input type="date" name="fechaNacimiento"/></td>
				</tr>
				<tr>
					<th>Fecha de defunción</th>
					<td><input type="date" name="fechaDefuncion"/></td>
				</tr>
				<tr>
					<th>Puntos</th>
					<td><input type="range" min="0" max="100" name="puntos"/></td>
				</tr>
				<tr>
					<th>Observaciones</th>
					<td>
						<textarea name="observaciones" rows="4" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<th>Activo</th>
					<td><input type="checkbox" name="activo" checked value="true"/></td>
				</tr>
				<tr>
					<th>Estilos</th>
					<td>
						<c:forEach var="estilo" items="${estilos}">
							<div>
								<input type="checkbox" name="estilos" value="${estilo.codigo}"/>	${estilo.nombre} 
							</div>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><button type="submit">CREAR</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>