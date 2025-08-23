package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;

import enums.TipoEmpresaEnum;
import models.Empresa;
import models.RamoAtividade;
import repository.Empresas;
import repository.RamoAtividades;
import service.CadastroEmpresaService;
import util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private RamoAtividades ramoAtividades;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;
	
	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	private Converter ramoAtividadeConverter;
	
	private Empresa empresa;
	
	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		
		if(houvePesquisa()) {
			pesquisar();
		}
		
		messages.info("Empresa cadastrada com sucesso!");
		
	}
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public void todasEmpresas() {
		listaEmpresas = empresas.findAll();
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
		
		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
		
		return listaRamoAtividades;
	}
	
	private boolean houvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
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
	
	public TipoEmpresaEnum[] getTipoEmpresa() {
		return TipoEmpresaEnum.values();
	}

	public Converter getRamoAtividadeConverter() {	
		return ramoAtividadeConverter;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
}
