package com.rauxasoft.artiges.business.services.borrame;

import java.util.Arrays;
import java.util.List;

import com.rauxasoft.artiges.business.model.Artista;
import com.rauxasoft.artiges.business.model.Estilo;
import com.rauxasoft.artiges.business.services.ArtistaServices;
import com.rauxasoft.artiges.business.services.impl.ArtistaServicesImpl;

public class ArtistaTestClass {

	public static void main(String[] args) {
		
		ArtistaServices artistaServices = new ArtistaServicesImpl();

		// ************ Probamos create() *******************
		
		Artista nuevoArtista = new Artista();
		nuevoArtista.setNombre("Rosalia");
		nuevoArtista.setNacionalidad("España");
		nuevoArtista.setObservaciones("Totalmente sobrevalorada");
		
		Estilo estilo = new Estilo();
		estilo.setCodigo(100L);
		estilo.setNombre("Flamenco - POP");
		
		nuevoArtista.setEstilos(Arrays.asList(estilo));
		
		Long codigo = artistaServices.create(nuevoArtista);
		
		System.out.println("Código otorgado por el sistema al nuevo artista: " + codigo + "\n");
		
		// ************ Probamos read() *********************
		
		Artista artistaObtenido = artistaServices.read(1000L);
		
		System.out.println("El artista código 1000L: " + artistaObtenido + "\n");
		
		// ************ Probamos getAll() *******************
		
		List<Artista> artistas = artistaServices.getAll();
		
		for(Artista artista: artistas) {
			System.out.println(artista);
		}
		
		// ************ Probamos update() *******************
		
		Artista artistaParaActualizar = artistaServices.read(1000L);
		artistaParaActualizar.setNombre("***** NOMBRE ACTUALIZADO *******");
		
		artistaServices.update(artistaParaActualizar);
		
		System.out.println("\n");
		
		artistas = artistaServices.getAll();
		
		for(Artista artista: artistas) {
			System.out.println(artista);
		}
		
		// ************ Probamos getByEstilo() *******************
		
		Estilo estiloFiltro = new Estilo();
		estiloFiltro.setCodigo(100L);
		
		List<Artista> artistasFiltrados = artistaServices.getByEstilo(estiloFiltro);
		
		System.out.println("\n");
		
		for(Artista artista: artistasFiltrados) {
			System.out.println(artista);
		}
		
	}

}
