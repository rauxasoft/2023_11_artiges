package com.rauxasoft.artiges.business.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.rauxasoft.artiges.business.model.Cancion;
import com.rauxasoft.artiges.business.services.CancionServices;

public class CancionServicesImpl implements CancionServices {

	private final Map<Long, Cancion> MAPA_CANCIONES = new HashMap<>();
	
	public CancionServicesImpl() {
		initObjects();
	}
	
	@Override
	public Cancion read(Long codigo) {
		return MAPA_CANCIONES.get(codigo);
	}

	@Override
	public List<Cancion> getAll() {
		return new ArrayList<Cancion>(MAPA_CANCIONES.values());
	}
	
	// **********************************************
	//
	// Private Methods
	//
	// **********************************************
	
	private void initObjects() {
		
		Cancion cancion1 = new Cancion(10L,"Subeme La Radio",false, 570);
		Cancion cancion2 = new Cancion(11L,"One Nation Under a Groove",false, 670);
		Cancion cancion3 = new Cancion(12L,"Macarena",true, 370);
		Cancion cancion4 = new Cancion(13L,"Baila Baila!",false, 623);
		
		MAPA_CANCIONES.put(cancion1.getCodigo(), cancion1);
		MAPA_CANCIONES.put(cancion2.getCodigo(), cancion2);
		MAPA_CANCIONES.put(cancion3.getCodigo(), cancion3);
		MAPA_CANCIONES.put(cancion4.getCodigo(), cancion4);
		
	}

}
