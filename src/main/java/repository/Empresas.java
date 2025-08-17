package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Empresas() {

	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(int i) {
		return manager.find(Empresa.class, i);
	}

	public List<Empresa> findAll() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}

	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where razaoSocial like :razaoSocial";

		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);

		query.setParameter("razaoSocial", nome + "%");

		return query.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}
