package com.rauxasoft.artiges.business.services;

import java.util.List;

import com.rauxasoft.artiges.business.model.Cancion;

public interface CancionServices {

	Cancion read(Long codigo);
	
	List<Cancion> getAll();
	
}
