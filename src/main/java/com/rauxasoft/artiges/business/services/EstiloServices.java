package com.rauxasoft.artiges.business.services;

import java.util.List;

import com.rauxasoft.artiges.business.model.Estilo;

public interface EstiloServices {

	Long create(Estilo estilo);
	
	Estilo read(Long codigo);
	
	List<Estilo> getAll();
	
}
