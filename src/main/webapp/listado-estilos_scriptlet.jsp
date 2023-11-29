<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rauxasoft.artiges.business.model.Estilo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common-in-head.html"/>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		<h2>Listado de Estilos</h2>
		<%
			out.println("<h3>Soy el subheader colocado desde Java</h3>");
		%>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
				</tr>
			</thead>
			<tbody>
			<%			
				List<Estilo> estilos = (List<Estilo>) request.getAttribute("estilos");
				
				for(Estilo estilo: estilos){
					out.println("<tr><td>" + estilo.getCodigo() + "</td><td>" + estilo.getNombre() + "</td></tr>");
				}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>