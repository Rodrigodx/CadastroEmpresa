package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import models.Empresa;
import repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	private List<Empresa> listaEmpresas;
	
	
	public void todasEmpresas() {
		listaEmpresas = empresas.findAll();
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

}
