package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.ModeloCarro;

public class ModeloCarroController {
	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public ModeloCarroController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(ModeloCarro modelocarro) {

		try {
			em.getTransaction().begin();
			em.merge(modelocarro);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(ModeloCarro modelocarro) {

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MODELOCARRO FROM MOTORISTA WHERE MODELOCARRO =" + modelocarro.getFabricante());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public List<ModeloCarro> listar() {
		em.getTransaction().begin();
		List<ModeloCarro> listaModeloCarro = null;
		listaModeloCarro = em.createQuery("FROM ModeloCarro").getResultList();
		em.close();
		return listaModeloCarro;

	}

}
