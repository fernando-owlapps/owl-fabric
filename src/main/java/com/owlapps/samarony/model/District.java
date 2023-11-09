package com.owlapps.samarony.model;

public class District {

	private Long id;	
	private String nome;
	private Municipio municipio;
	
	public District() {
		
	}
	
	public District(Long id) {
		this.id = id;
	}
	
	public District(Long id, String nome, Municipio municipio) {
		super();
		this.id = id;
		this.nome = nome;
		this.municipio = municipio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", nome=" + nome + ", municipio=" + municipio + "]";
	}
	
}
