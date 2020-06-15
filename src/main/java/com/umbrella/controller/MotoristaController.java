package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.umbrella.connection.Connection;
import com.umbrella.entity.Motorista;

public class MotoristaController {

	// Query query;

	public void Save(Motorista motorista) {

		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(motorista);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void Update(Motorista motorista) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(motorista);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		} finally {
			em.close();
		}

	}

	public void Delete(Motorista motorista) {
		EntityManager em = new Connection().getConnection();

		try {
			em.getTransaction().begin();
			Query query = em
					.createNamedQuery("DELETE MOTORISTA FROM MOTORISTA WHERE numeroCNH =" + motorista.getNumeroCNH());
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
		Motorista motorista = null;

		try {
			motorista = em.find(Motorista.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

	public List<Motorista> ListAll() {
		EntityManager em = new Connection().getConnection();
		em.getTransaction().begin();
		List<Motorista> listaMotorista = null;
		listaMotorista = em.createQuery("FROM Motorista").getResultList();
		em.close();
		return listaMotorista;

	}
}
