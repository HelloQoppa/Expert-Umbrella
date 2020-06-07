package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.Acessorio;


public class AcessorioController {
	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public AcessorioController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(Acessorio acessorio) {

		try {
			em.getTransaction().begin();
			em.merge(acessorio);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(Acessorio acessorio) {

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE ACESSORIO FROM ACESSORIO WHERE descricao =" + acessorio.getDescricao());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public List<Acessorio> listar() {
		em.getTransaction().begin();
		List<Acessorio> listaAcessorio = null;
		listaAcessorio = em.createQuery("FROM Acessorio").getResultList();
		em.close();
		return listaAcessorio;

	}

}
