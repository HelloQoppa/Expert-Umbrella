package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.Fabricante;

public class FabricanteController {

	// Query query;

	public void Save(Fabricante fabricante) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(fabricante);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(Fabricante fabricante) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(fabricante);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(Fabricante fabricante) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MOTORISTA FROM FABRICANTE WHERE codigo =" + fabricante.getCodigo());
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
		Fabricante fabricante = null;

		try {
			fabricante = em.find(Fabricante.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<Fabricante> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<Fabricante> listaFabricante = null;
		listaFabricante = em.createQuery("FROM Fabricante").getResultList();
		em.close();
		return listaFabricante;

	}
}
