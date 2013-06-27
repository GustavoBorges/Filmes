package br.sea.filme.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sea.filme.beans.DiretorBean;
import br.sea.filme.dao.DiretorDAO;

@FacesConverter(forClass=DiretorBean.class)
public class DiretorConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (!value.equals("")){
			DiretorBean diretor = new DiretorBean();
			diretor = (DiretorBean) new DiretorDAO().buscarPorId(DiretorBean.class, Integer.parseInt(value));
			return diretor;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if(value instanceof DiretorBean){
			DiretorBean diretor = (DiretorBean) value;
			String id = String.valueOf(diretor.getId());
			return id;
		}
		return "";


	}


}

