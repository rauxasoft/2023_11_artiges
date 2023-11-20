package com.rauxasoft.artiges.business.services.impl;

import java.util.List;
import java.text.SimpleDateFormat;

import java.util.Map;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import com.rauxasoft.artiges.business.model.Artista;
import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.ArtistaServices;

public class ArtistaServicesImpl implements ArtistaServices {

	private final Map<Long, Artista> MAPA_ARTISTAS = new HashMap<>();
	
	public ArtistaServicesImpl() {
		
		Estilo estilo1 = new Estilo();
		estilo1.setCodigo(11L);
		estilo1.setNombre("Rock");
		
		Estilo estilo2 = new Estilo();
		estilo2.setCodigo(12L);
		estilo2.setNombre("Lounge - Easy Listening");
		
		Date fecha1Nacimiento = null;
		Date fecha1Defuncion = null;
		
		Date fecha2Nacimiento = null;
		Date fecha2Defuncion = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			fecha1Nacimiento = sdf.parse("01/01/1946");
			fecha1Defuncion = sdf.parse("03/07/2015");
			fecha2Nacimiento = sdf.parse("09/01/1921");
			fecha2Defuncion = sdf.parse("25/12/1993");
			
		} catch(Exception e) {
			
		}
		
		Artista artista1 = new Artista();
		artista1.setCodigo(1000L);
		artista1.setNombre("Paul Mauriat");
		artista1.setFechaNacimiento(fecha1Nacimiento);
		artista1.setFechaDefuncion(fecha1Defuncion);
		artista1.setPuntos(24);
		artista1.setActivo(false);
		artista1.setNacionalidad("Francia");
		artista1.setObservaciones("Vendían cassetes en gasolineras");
		artista1.setEstilos(Arrays.asList(estilo2));
		
		Artista artista2 = new Artista();
		artista2.setCodigo(1001L);
		artista2.setNombre("Prince");
		artista2.setFechaNacimiento(fecha2Nacimiento);
		artista2.setFechaDefuncion(fecha2Defuncion);
		artista2.setPuntos(93);
		artista2.setActivo(false);
		artista2.setNacionalidad("EEUU");
		artista2.setObservaciones("Muy bueno...");
		artista2.setEstilos(Arrays.asList(estilo1, estilo2));
		
		MAPA_ARTISTAS.put(artista1.getCodigo(), artista1);
		MAPA_ARTISTAS.put(artista2.getCodigo(), artista2);
		
	}
	
	@Override
	public Long create(Artista artista) {
		
		Long codigo = System.currentTimeMillis();
		artista.setCodigo(codigo);
		
		MAPA_ARTISTAS.put(codigo, artista);
		
		return codigo;
	}

	@Override
	public Artista read(Long codigo) {
		return MAPA_ARTISTAS.get(codigo);
	}

	@Override
	public void update(Artista artista) {
		
		Long codigo = artista.getCodigo();
		
		boolean existe = MAPA_ARTISTAS.containsKey(codigo);
		
		if(!existe) {
			throw new IllegalStateException("El artista " + codigo + " no existe. No se puede actualizar.");
		}
		
		MAPA_ARTISTAS.replace(codigo, artista);
	}

	@Override
	public List<Artista> getAll() {
		
		List<Artista> artistas = new ArrayList<>();
		
		for(Artista artista: MAPA_ARTISTAS.values()) {
			artistas.add(artista);
		}
		
		return artistas;
	}

	@Override
	public List<Artista> getByEstilo(Estilo estilo) {
		
		List<Artista> artistas = new ArrayList<>();
		
		for(Artista artista: MAPA_ARTISTAS.values()) {
			if(artista.getEstilos().contains(estilo)) {
				artistas.add(artista);
			}
		}
		
		return artistas;
	}

}
