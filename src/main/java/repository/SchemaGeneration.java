package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Empresa;

public class SchemaGeneration {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		
		EntityManager em = emf.createEntityManager();
		
		List<Empresa> empresas = em.createQuery("From Empresa", Empresa.class).getResultList();
		
		System.out.println(empresas);
		
		em.close();
		emf.close();
	}
	
}
