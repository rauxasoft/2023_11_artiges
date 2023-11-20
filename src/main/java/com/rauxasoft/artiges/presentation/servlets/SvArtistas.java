package com.rauxasoft.artiges.presentation.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rauxasoft.artiges.business.model.Artista;
import com.rauxasoft.artiges.business.services.ArtistaServices;
import com.rauxasoft.artiges.business.services.impl.ArtistaServicesImpl;

@SuppressWarnings("serial")
@WebServlet("/artistas")
public class SvArtistas extends HttpServlet {
	
	private ArtistaServices artistaServices = new ArtistaServicesImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Artista> artistas = artistaServices.getAll();
		
		request.setAttribute("artistas", artistas);
		
		RequestDispatcher rd = request.getRequestDispatcher("listado-artistas.jsp");
		
		rd.forward(request, response);
			
	}
	
}
