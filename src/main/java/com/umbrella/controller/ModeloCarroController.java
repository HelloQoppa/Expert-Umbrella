package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.ModeloCarro;

public class ModeloCarroController {

	// Query query;

	public void Save(ModeloCarro modeloCarro) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(modeloCarro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(ModeloCarro modeloCarro) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(modeloCarro);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(ModeloCarro modeloCarro) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MOTORISTA FROM MODELOCARRO WHERE codigo =" + modeloCarro.getCodigo());
			query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void ListById(Long id) {
		EntityManager em = new Connection().getConnection();
		ModeloCarro modeloCarro = null;

		try {
			modeloCarro = em.find(ModeloCarro.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<ModeloCarro> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<ModeloCarro> listaModeloCarro = null;
		listaModeloCarro = em.createQuery("FROM ModeloCarro").getResultList();
		em.close();
		return listaModeloCarro;

	}
}
