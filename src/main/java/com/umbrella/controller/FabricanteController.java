package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.Fabricante;

public class FabricanteController {
	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public FabricanteController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(Fabricante fabricante) {

		try {
			em.getTransaction().begin();
			em.merge(fabricante);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(Fabricante fabricante) {

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE FABRICANTE FROM FABRICANTE WHERE nome =" + fabricante.getNome());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public List<Fabricante> listar() {
		em.getTransaction().begin();
		List<Fabricante> listaFabricante = null;
		listaFabricante = em.createQuery("FROM Fabricante").getResultList();
		em.close();
		return listaFabricante;

	}

}
