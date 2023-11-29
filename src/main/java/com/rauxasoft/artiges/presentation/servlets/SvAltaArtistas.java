package com.rauxasoft.artiges.presentation.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rauxasoft.artiges.business.model.Artista;
import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.ArtistaServices;
import com.rauxasoft.artiges.business.services.EstiloServices;

// GET http://localhost:8080/artiges/artistas
// GET http://localhost:8080/artiges/artistas?codigo=1001

@WebServlet("/alta-artistas")
public class SvAltaArtistas extends HttpServlet {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// Para obtener el formulario
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstiloServices estiloServices = (EstiloServices) request.getServletContext().getAttribute("estiloServices");
		
		// 1.- Necesitamos la lista de estilos
		
		List<Estilo> estilos = estiloServices.getAll();
		
		// 2.- Adjuntamos la lista de estilos al request
		
		request.setAttribute("estilos", estilos);
		
		// 3.- Devolvemos el formulario
		
		request.getRequestDispatcher("alta-artista.jsp").forward(request, response);
		
	}
	
	// Para crear el artista nuevo
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArtistaServices artistaServices = (ArtistaServices) request.getServletContext().getAttribute("artistaServices");
		
		// 1.- Obtención de parámetros
		
		String nombre = request.getParameter("nombre");
		String nacionalidad = request.getParameter("nacionalidad");
		String strFechaNacimiento = request.getParameter("fechaNacimiento");
		String strFechaDefuncion = request.getParameter("fechaDefuncion");
		String strPuntos = request.getParameter("puntos");
		String observaciones = request.getParameter("observaciones");
		String strActivo = request.getParameter("activo");
		
		//String[] estilos = request.getParameterValues("estilos");
		
		// 2.- Parseo de parámetros (y validación)
		
		Date fechaNacimiento = null;
		Date fechaDefuncion = null;
		int puntos = 0;
		boolean activo = false;
		
		try {
			
			if(!strFechaNacimiento.equals("")) {
				fechaNacimiento = sdf.parse(strFechaNacimiento);
			}
			
			if(!strFechaDefuncion.equals("")) {
				fechaDefuncion = sdf.parse(strFechaDefuncion);
			}
			
			puntos = Integer.parseInt(strPuntos);
			
			if(strActivo != null) {
				activo = Boolean.parseBoolean(strActivo);
			}
			
		} catch(Exception e) {
			
		}
		
		// 3.- Instanciación del modelo
		
		Artista artista = new Artista();
		artista.setCodigo(null);
		artista.setNombre(nombre);
		artista.setNacionalidad(nacionalidad);
		artista.setFechaNacimiento(fechaNacimiento);
		artista.setFechaDefuncion(fechaDefuncion);
		artista.setObservaciones(observaciones);
		artista.setPuntos(puntos);
		artista.setActivo(activo);
		
		// 4.- Persistencia del modelo
		
		artistaServices.create(artista);
		
		// 5.- Respuesta HTTP (redirección al listado de artistas)
		
		response.sendRedirect("artistas");  //
	}
		
}
