package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.Acessorio;

public class AcessorioController {

	// Query query;

	public void Save(Acessorio acessorio) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(acessorio);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(Acessorio acessorio) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(acessorio);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(Acessorio acessorio) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MOTORISTA FROM FABRICANTE WHERE codigo =" + acessorio.getCodigo());
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
		Acessorio acessorio = null;

		try {
			acessorio = em.find(Acessorio.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<Acessorio> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<Acessorio> listaAcessorio = null;
		listaAcessorio = em.createQuery("FROM Acessorio").getResultList();
		em.close();
		return listaAcessorio;

	}
}
