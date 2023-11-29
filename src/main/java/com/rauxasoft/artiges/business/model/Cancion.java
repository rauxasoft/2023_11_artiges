package com.rauxasoft.artiges.business.model;

import java.util.Objects;

// POJO
public class Cancion {
	
	private Long codigo;
	private String titulo;
	private boolean explicita;
	private int duracion;
	
	public Cancion() {
		
	}
	
	public Cancion(Long codigo, String titulo, boolean explicita, int duracion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.explicita = explicita;
		this.duracion = duracion;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isExplicita() {
		return explicita;
	}

	public void setExplicita(boolean explicita) {
		this.explicita = explicita;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Cancion [codigo=" + codigo + ", titulo=" + titulo + ", explicita=" + explicita + ", duracion=" + duracion + "]";
	}
	
}
