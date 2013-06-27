package br.sea.filme.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diretores")
public class DiretorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public DiretorBean(){
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="COD_DIRETOR")
	private int id;
	
	@Column(name="NOME")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
