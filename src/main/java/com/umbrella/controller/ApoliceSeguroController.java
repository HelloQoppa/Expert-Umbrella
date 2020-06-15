package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.ApoliceSeguro;

public class ApoliceSeguroController {

	// Query query;

	public void Save(ApoliceSeguro apoliceSeguro) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(apoliceSeguro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(ApoliceSeguro apoliceSeguro) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(apoliceSeguro);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(ApoliceSeguro apoliceSeguro) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MOTORISTA FROM APOLICESEGURO WHERE codigo =" + apoliceSeguro.getCodigo());
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
		ApoliceSeguro apoliceSeguro = null;

		try {
			apoliceSeguro = em.find(ApoliceSeguro.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<ApoliceSeguro> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<ApoliceSeguro> listaApoliceSeguro = null;
		listaApoliceSeguro = em.createQuery("FROM ApoliceSeguro").getResultList();
		em.close();
		return listaApoliceSeguro;

	}
}
