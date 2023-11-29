package com.rauxasoft.artiges.presentation.listeners;

import com.rauxasoft.artiges.business.services.ArtistaServices;
import com.rauxasoft.artiges.business.services.impl.ArtistaServicesImpl;
import com.rauxasoft.artiges.business.services.EstiloServices;
import com.rauxasoft.artiges.business.services.impl.EstiloServicesImpl;
import com.rauxasoft.artiges.business.services.CancionServices;
import com.rauxasoft.artiges.business.services.impl.CancionServicesImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfiguradorVariablesGlobales implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
        
    	ArtistaServices artistaServices = new ArtistaServicesImpl();
    	EstiloServices estiloServices = new EstiloServicesImpl();
    	CancionServices cancionServices = new CancionServicesImpl();
    	
    	sce.getServletContext().setAttribute("artistaServices", artistaServices);
    	sce.getServletContext().setAttribute("estiloServices", estiloServices);
    	sce.getServletContext().setAttribute("cancionServices", cancionServices);
    	    	
    }
  
    public void contextDestroyed(ServletContextEvent sce)  { 
       // not implemented  
    }
	
}
