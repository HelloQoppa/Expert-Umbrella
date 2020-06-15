package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.Carro;

public class CarroController {

	// Query query;

	public void Save(Carro carro) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(carro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(Carro carro) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(carro);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(Carro carro) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("DELETE MOTORISTA FROM CARRO WHERE codigo =" + carro.getCodigo());
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
		Carro carro = null;

		try {
			carro = em.find(Carro.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<Carro> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<Carro> listaCarro = null;
		listaCarro = em.createQuery("FROM Carro").getResultList();
		em.close();
		return listaCarro;

	}
}
