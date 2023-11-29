<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common-in-head.html"/>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		<h2>Alta Estilo</h2>
		<form method="POST" action="estilos">
			<table>
				<tr>
					<th>Nombre</th>
					<td><input type="text" name="nombre"/></td>
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