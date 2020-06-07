package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.Carro;

public class CarroController {
	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public CarroController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(Carro carro) {

		try {
			em.getTransaction().begin();
			em.merge(carro);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(Carro carro) {

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE CARRO FROM CARRO WHERE placa =" + carro.getPlaca());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public List<Carro> listar() {
		em.getTransaction().begin();
		List<Carro> listaCarro = null;
		listaCarro = em.createQuery("FROM Carro").getResultList();
		em.close();
		return listaCarro;

	}

}
