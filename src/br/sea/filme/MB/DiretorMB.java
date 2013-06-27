package br.sea.filme.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.sea.filme.beans.DiretorBean;
import br.sea.filme.dao.DiretorDAO;
import br.sea.filme.util.JSFMensageiro;

@ManagedBean
@SessionScoped
public class DiretorMB implements Serializable{
	
	private DiretorBean diretor;
	private List<DiretorBean> diretores;

	private static final long serialVersionUID = 1L;

	public DiretorMB(){
		diretor = new DiretorBean();
		diretores = new ArrayList<DiretorBean>();
		this.diretores = new DiretorDAO().findAll(DiretorBean.class);
	}
	
	public String index(){
		this.diretor = new DiretorBean();
		diretores = new ArrayList<DiretorBean>();
		this.diretores = new DiretorDAO().findAll(DiretorBean.class);
		return "/diretor/index.xhtml";
	}
	
	public String novo(){
		this.diretor = new DiretorBean();
		return "new";
	}
	
	public String criar(){
		
		if(diretor.getId() == 0){
			JSFMensageiro.info("O Diretor foi criado com sucesso!");
		}else{
			JSFMensageiro.info("O Diretor foi alterado com sucesso!");
		}
		new DiretorDAO().saveOrUpdate(diretor);
		
		return index();
	}
	
	public String show(){
		
		return "show";
	}
	
	public String edit(){
		
		return "new";
	}
	
	public String delete(){
		new DiretorDAO().delete(diretor);
		this.diretor = new DiretorBean();
		JSFMensageiro.info("O Diretor foi deletado com sucesso!");
		return index();
	}
	
	public String buscar(){
		this.diretores = new DiretorDAO().buscarPorNome(DiretorBean.class, diretor.getNome());
		return "index";
	}


	public DiretorBean getDiretor() {
		return diretor;
	}

	public void setDiretor(DiretorBean diretor) {
		this.diretor = diretor;
	}

	public List<DiretorBean> getDiretores() {
		return diretores;
	}

	public void setDiretores(List<DiretorBean> diretores) {
		this.diretores = diretores;
	}

}
