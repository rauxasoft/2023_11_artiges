package com.rauxasoft.artiges.presentation.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rauxasoft.artiges.business.services.ArtistaServices;
import com.rauxasoft.artiges.business.services.impl.ArtistaServicesImpl;

@WebServlet("/artistas")
public class SvArtistas extends HttpServlet {
	
	private ArtistaServices artistaServices = new ArtistaServicesImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setAttribute("artistas", artistaServices.getAll());
		
		request.getRequestDispatcher("listado-artistas.jsp").forward(request, response);
			
	}
	
}
