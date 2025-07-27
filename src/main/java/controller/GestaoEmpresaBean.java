package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import enums.TipoEmpresaEnum;
import models.Empresa;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	
	public void salvar () {
		System.out.println("Razão Social: " + empresa.getRazaoSocial()
				+ " - Nome fantasia: " + empresa.getNomeFantasia()
				+ " - Tipo: " + empresa.getTipo());
	}
	
	public String ajudaImplicita() {
		return "Escopos";
	}

	public String ajudaExplicita() {
		return "Escopos?faces-redirect=true";
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresaEnum[] getTiposEmpresa() {
		return TipoEmpresaEnum.values();
	}

}
