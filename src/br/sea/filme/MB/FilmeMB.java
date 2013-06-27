package br.sea.filme.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.sea.filme.beans.FilmeBean;
import br.sea.filme.dao.FilmeDAO;
import br.sea.filme.util.JSFMensageiro;

@ManagedBean
@SessionScoped
public class FilmeMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private FilmeBean filme;
	private List<FilmeBean> filmes;
	
	public FilmeMB(){
		this.filme = new FilmeBean();
		this.filmes = new ArrayList<FilmeBean>();
		this.filmes = new FilmeDAO().findAll(FilmeBean.class);
	}
	
	public String index(){
		this.filme = new FilmeBean();
		this.filmes = new ArrayList<FilmeBean>();
		this.filmes = new FilmeDAO().findAll(FilmeBean.class);
		return "/filme/index.xhtml";
	}
	
	public String novo(){
		this.filme = new FilmeBean();
		return "new";
	}
	
	public String criar(){
		
		if(filme.getId() == 0){
			JSFMensageiro.info("O Filme foi criado com sucesso!");
		}else{
			JSFMensageiro.info("O Filme foi alterado com sucesso!");
		}
		new FilmeDAO().saveOrUpdate(filme);
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
	
	public String buscar(){
		this.filmes = new FilmeDAO().buscarPorNome(FilmeBean.class, filme.getNome());
		return "index";
	}

	public FilmeBean getFilme() {
		return filme;
	}

	public void setFilme(FilmeBean filme) {
		this.filme = filme;
	}


	public List<FilmeBean> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<FilmeBean> filmes) {
		this.filmes = filmes;
	}
}
