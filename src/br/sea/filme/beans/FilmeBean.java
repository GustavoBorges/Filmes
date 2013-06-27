package br.sea.filme.beans;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="filmes")
public class FilmeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="COD_FILME")
	private int id;
	
	@Column(name="NOME")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ASSISTIDO")
	private Date dataAssistido;
	
	@Column(name="NOTA")
	private int nota;
	
	@Column(name="OSCAR")
	private boolean oscar;

	public boolean isOscar() {
		return oscar;
	}



	public void setOscar(boolean oscar) {
		this.oscar = oscar;
	}

	@Column(name="ANO_LANCAMENTO")
	private int anoLancamento;
	
	@ManyToOne()
	@JoinColumn(name="COD_DIRETOR")
	private DiretorBean diretor;
	
	public FilmeBean(){
	 this.diretor = new DiretorBean();	
	}
	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return dataAssistido;
	}
	public void setData(Date data) {
		this.dataAssistido = data;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public DiretorBean getDiretor() {
		return diretor;
	}
	public void setDiretor(DiretorBean diretor) {
		this.diretor = diretor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataAssistido() {
		return dataAssistido;
	}



	public void setDataAssistido(Date dataAssistido) {
		this.dataAssistido = dataAssistido;
	}

}
