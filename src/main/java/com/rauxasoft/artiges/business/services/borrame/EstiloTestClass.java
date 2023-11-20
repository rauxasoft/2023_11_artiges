package com.rauxasoft.artiges.business.services.borrame;

import java.util.List;

import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.EstiloServices;
import com.rauxasoft.artiges.business.services.impl.EstiloServicesImpl;

public class EstiloTestClass {

	public static void main(String[] args) {
		
		EstiloServices estiloServices = new EstiloServicesImpl();
		
		// ************ Probamos create() *******************
		
		Estilo nuevoEstilo = new Estilo();
		nuevoEstilo.setNombre("POP");
		
		Long codigo = estiloServices.create(nuevoEstilo);
		
		System.out.println("Código otorgado por el sistema al nuevo estilo: " + codigo + "\n");
		
		// ************ Probamos read() *********************
		
		Estilo estiloObtenido = estiloServices.read(11L);
		
		System.out.println("Estilo código 11: " + estiloObtenido + "\n");
		
		// ************ Probamos getAll() *******************
		
		List<Estilo> estilos = estiloServices.getAll();
		
		for(Estilo estilo: estilos) {
			System.out.println(estilo);
		}

	}

}
