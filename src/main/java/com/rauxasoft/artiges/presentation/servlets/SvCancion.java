package com.rauxasoft.artiges.presentation.servlets;

import java.util.List;
import java.util.ArrayList;
import com.rauxasoft.artiges.business.model.Cancion;
import com.rauxasoft.artiges.business.services.CancionServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/canciones")
public class SvCancion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx = request.getServletContext(); // Espacio de variables "globales"
		
		CancionServices cancionServices = (CancionServices) ctx.getAttribute("cancionServices");
		
		List<Cancion> canciones = cancionServices.getAll();
		
		List<CancionDTO> cancionesDTO = new ArrayList<>();
		
		for(Cancion cancion: canciones) {
			CancionDTO cancionDTO = new CancionDTO(cancion.getCodigo(), 
					 					           cancion.getTitulo(),
					 					           cancion.isExplicita(),
					 					           cancion.getDuracion());
			cancionesDTO.add(cancionDTO);
		}
		
		request.setAttribute("canciones", cancionesDTO);
		
		request.getRequestDispatcher("listado-canciones.jsp").forward(request, response);
		
		// FIN
	}

}
