package com.rauxasoft.artiges.business.services.impl;

import java.util.List;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.EstiloServices;

public class EstiloServicesImpl implements EstiloServices {

	private final Map<Long, Estilo> MAPA_ESTILOS = new HashMap<>();
	
	public EstiloServicesImpl() {
		
		Estilo estilo1 = new Estilo();
		estilo1.setCodigo(10L);
		estilo1.setNombre("Trap");
		
		Estilo estilo2 = new Estilo();
		estilo2.setCodigo(11L);
		estilo2.setNombre("Rock");
		
		Estilo estilo3 = new Estilo();
		estilo3.setCodigo(12L);
		estilo3.setNombre("Lounge - Easy Listening");
		
		Estilo estilo4 = new Estilo();
		estilo4.setCodigo(13L);
		estilo4.setNombre("Habanera");
		
		MAPA_ESTILOS.put(estilo1.getCodigo(), estilo1);
		MAPA_ESTILOS.put(estilo2.getCodigo(), estilo2);
		MAPA_ESTILOS.put(estilo3.getCodigo(), estilo3);
		MAPA_ESTILOS.put(estilo4.getCodigo(), estilo4);
		
	}
	
	@Override
	public Long create(Estilo estilo) {
		
		Long codigo = System.currentTimeMillis();
		estilo.setCodigo(codigo);
		
		MAPA_ESTILOS.put(codigo, estilo);
		
		return codigo;
	}

	@Override
	public Estilo read(Long codigo) {		
		return MAPA_ESTILOS.get(codigo);
	}

	@Override
	public List<Estilo> getAll() {
		
		List<Estilo> estilos = new ArrayList<>();
		
		for(Estilo estilo: MAPA_ESTILOS.values()) {
			estilos.add(estilo);
		}
		
		return estilos;
	}

}
