package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.Aluguel;

public class AluguelController {

	// Query query;

	public void Save(Aluguel aluguel) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(aluguel);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(Aluguel aluguel) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(aluguel);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(Aluguel aluguel) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MOTORISTA FROM ALUGUEL WHERE codigo =" + aluguel.getCodigo());
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
		Aluguel aluguel = null;

		try {
			aluguel = em.find(Aluguel.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<Aluguel> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<Aluguel> listaAluguel = null;
		listaAluguel = em.createQuery("FROM Aluguel").getResultList();
		em.close();
		return listaAluguel;

	}
}
