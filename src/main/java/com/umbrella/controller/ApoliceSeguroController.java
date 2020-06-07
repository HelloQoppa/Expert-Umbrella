package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.ApoliceSeguro;

public class ApoliceSeguroController {
	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public ApoliceSeguroController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(ApoliceSeguro apoliceseguro) {

		try {
			em.getTransaction().begin();
			em.merge(apoliceseguro);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(ApoliceSeguro apoliceseguro) {

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE APOLICESEGURO FROM APOLICESEGURO WHERE valorFranquia =" + apoliceseguro.getValorFranquia());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public List<ApoliceSeguro> listar() {
		em.getTransaction().begin();
		List<ApoliceSeguro> listaApoliceSeguro = null;
		listaApoliceSeguro = em.createQuery("FROM ApoliceSeguro").getResultList();
		em.close();
		return listaApoliceSeguro;

	}

}
