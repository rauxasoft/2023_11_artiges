package com.rauxasoft.artiges.business.services;

import java.util.List;

import com.rauxasoft.artiges.business.model.Artista;
import com.rauxasoft.artiges.business.model.Estilo;

public interface ArtistaServices {

	Long create(Artista artista);
	
	Artista read(Long codigo);
	
	void update(Artista artista);
	
	List<Artista> getAll();
	
	List<Artista> getByEstilo(Estilo estilo);
	
}
