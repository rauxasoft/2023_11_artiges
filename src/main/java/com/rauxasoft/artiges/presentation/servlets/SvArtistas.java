package com.rauxasoft.artiges.presentation.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rauxasoft.artiges.business.model.Artista;
import com.rauxasoft.artiges.business.services.ArtistaServices;
import com.rauxasoft.artiges.business.services.impl.ArtistaServicesImpl;

// GET http://localhost:8080/artiges/artistas
// GET http://localhost:8080/artiges/artistas?codigo=1001

@WebServlet("/artistas")
public class SvArtistas extends HttpServlet {
	
	private ArtistaServices artistaServices = new ArtistaServicesImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strCodigo = request.getParameter("codigo");
		
		if(strCodigo == null) {
			request.setAttribute("artistas", artistaServices.getAll());
			request.getRequestDispatcher("listado-artistas.jsp").forward(request, response);
		} else {
			Long codigo = Long.parseLong(strCodigo);
			Artista artista = artistaServices.read(codigo);
			request.setAttribute("artista", artista);
			request.getRequestDispatcher("ficha-artista.jsp").forward(request, response);
		}	
	}
		
}
