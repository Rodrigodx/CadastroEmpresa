package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;

import models.Empresa;
import repository.Empresas;
import util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;

	@Inject
	private FacesMessages messages;
	
	private List<Empresa> listaEmpresas;

	private String termoPesquisa;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
			
		}
	}
	
	public void todasEmpresas() {
		listaEmpresas = empresas.findAll();
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	

}
