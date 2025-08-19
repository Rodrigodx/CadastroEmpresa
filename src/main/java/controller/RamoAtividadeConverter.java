package controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import models.RamoAtividade;

public class RamoAtividadeConverter implements Converter {

	private List<RamoAtividade> listRamoAtividades;
	
	public RamoAtividadeConverter(List<RamoAtividade> listRamoAtividades) {
		this.listRamoAtividades = listRamoAtividades;
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	
		if(value == null) {
			return null;
		}
		
		Integer id = Integer.valueOf(value);
		
		for(RamoAtividade r: listRamoAtividades) {
			if(id.equals(r.getId())) {
				return r;
			}
		}
			
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if(value == null) {
			return null;
		}
		
		RamoAtividade ramoAtividade = (RamoAtividade) value;
		
		int resultado = ramoAtividade.getId();
		
		return String.valueOf(resultado);
	}

}
