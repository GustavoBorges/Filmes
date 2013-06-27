package br.sea.filme.beans;

import java.io.Serializable;

public class OscarBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
