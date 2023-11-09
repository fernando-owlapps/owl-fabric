package com.owlapps.samarony.model;

public class Municipio {	

	private Long id;
	
	private String nome;
	
	
	public Municipio() {
		
	}
	
	public Municipio(Long id) {
		this.id = id;
	}
	
	public Municipio(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Municipio [id=" + id + ", nome=" + nome + "]";
	}

	
	
}
