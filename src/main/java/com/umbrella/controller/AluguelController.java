package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.Aluguel;

public class AluguelController {
	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public AluguelController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(Aluguel aluguel) {

		try {
			em.getTransaction().begin();
			em.merge(aluguel);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(Aluguel aluguel) {

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE ALUGUEL FROM ALUGUEL WHERE carro =" + aluguel.getCarro());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public List<Aluguel> listar() {
		em.getTransaction().begin();
		List<Aluguel> listaAluguel = null;
		listaAluguel = em.createQuery("FROM Aluguel").getResultList();
		em.close();
		return listaAluguel;

	}

}
