package com.rauxasoft.artiges.presentation.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.EstiloServices;
import com.rauxasoft.artiges.business.services.impl.EstiloServicesImpl;

@SuppressWarnings("serial")
@WebServlet("/estilos")
public class SvEstilos extends HttpServlet {
	
	private EstiloServices estiloServices = new EstiloServicesImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Estilo> estilos = estiloServices.getAll();
				
		request.setAttribute("estilos", estilos);
		
		RequestDispatcher rd = request.getRequestDispatcher("listado-estilos.jsp");
		
		rd.forward(request, response);
			
	}

}
