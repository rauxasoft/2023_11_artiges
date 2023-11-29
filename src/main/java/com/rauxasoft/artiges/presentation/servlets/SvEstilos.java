package com.rauxasoft.artiges.presentation.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.EstiloServices;

@WebServlet("/estilos")
public class SvEstilos extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		EstiloServices estiloServices = (EstiloServices) request.getServletContext().getAttribute("estiloServices");
		
		List<Estilo> estilos = estiloServices.getAll();
				
		request.setAttribute("estilos", estilos);
		
		request.getRequestDispatcher("listado-estilos.jsp").forward(request, response);
			
	}
	
	// POST   http://localhost:8080/estilos?nombre="BALADA"
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		EstiloServices estiloServices = (EstiloServices) request.getServletContext().getAttribute("estiloServices");
		
		String nombre = request.getParameter("nombre");
		
		Estilo estilo = new Estilo();
		estilo.setNombre(nombre);
		
		estiloServices.create(estilo);
		
		response.sendRedirect("estilos");
		
	}

}
