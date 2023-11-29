package com.rauxasoft.artiges.presentation.servlets;

public class CancionDTO {

	private Long codigo;
	private String titulo;
	private boolean explicita;
	private String horas;
	private String minutos;
	private String segundos;
		
	public CancionDTO(Long codigo, String titulo, boolean explicita, int duracion) {
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.explicita = explicita;
		
		String segundos = ("0" + duracion % 60);
		String minutos = ("0" +(duracion % 3600) / 60);
		String horas = ("0" + duracion / 3600);
		
		// input.substring(input.length() - 4);
		
		this.segundos = segundos.substring(segundos.length() - 2);
		this.minutos =  minutos.substring(minutos.length() - 2);
		this.horas =    horas.substring(horas.length() - 2);
		
		
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public boolean isExplicita() {
		return explicita;
	}

	public String getHoras() {
		return horas;
	}

	public String getMinutos() {
		return minutos;
	}

	public String getSegundos() {
		return segundos;
	}
	
	
}
