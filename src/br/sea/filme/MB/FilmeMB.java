package br.sea.filme.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.sea.filme.beans.DiretorBean;
import br.sea.filme.beans.FilmeBean;
import br.sea.filme.dao.DiretorDAO;
import br.sea.filme.dao.FilmeDAO;
import br.sea.filme.util.JSFMensageiro;

@ManagedBean
@SessionScoped
public class FilmeMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private FilmeBean filme;
	private DiretorBean diretor;
	private List<FilmeBean> filmes;
	
	public FilmeMB(){
		this.filme = new FilmeBean();
		this.diretor = new DiretorBean();
		this.filmes = new ArrayList<FilmeBean>();
	}
	
	public String index(){
		this.filmes = new ArrayList<FilmeBean>();
		this.filmes = new FilmeDAO().findAll(FilmeBean.class);
		return "/filme/index.xhtml";
	}
	
	public String novo(){
		this.filme = new FilmeBean();
		this.diretor = new DiretorBean();
		return "new";
	}
	
	public String criar(){
		this.diretor = this.filme.getDiretor();
		new DiretorDAO().saveOrUpdate(diretor);
		new FilmeDAO().saveOrUpdate(filme);
		JSFMensageiro.info("O Filme foi criado com sucesso!");
		return index();
	}
	
	public String show(){
		
		return "show";
	}
	
	public String edit(){
		
		return "new";
	}
	
	public String delete(){
		new FilmeDAO().delete(filme);
		this.filme = new FilmeBean();
		JSFMensageiro.info("O Filme foi deletado com sucesso!");
		return index();
	}

	public FilmeBean getFilme() {
		return filme;
	}

	public void setFilme(FilmeBean filme) {
		this.filme = filme;
	}

	public DiretorBean getDiretor() {
		return diretor;
	}

	public void setDiretor(DiretorBean diretor) {
		this.diretor = diretor;
	}

	public List<FilmeBean> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<FilmeBean> filmes) {
		this.filmes = filmes;
	}
}
