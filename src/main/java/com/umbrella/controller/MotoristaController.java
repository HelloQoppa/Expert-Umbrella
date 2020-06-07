package com.umbrella.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.umbrella.entity.Motorista;

public class MotoristaController {

	EntityManagerFactory emf;
	EntityManager em;
	// Query query;

	public MotoristaController() {
		emf = Persistence.createEntityManagerFactory("aluguel");
		em = emf.createEntityManager();
	}

	public void save(Motorista motorista) {

		try {
			em.getTransaction().begin();
			em.merge(motorista);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.err.println(e + "erro");
			em.close();
		}

	}

	public void Delete(Motorista motorista) {

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
		}

	}

	public List<Motorista> listar() {
		em.getTransaction().begin();
		List<Motorista> listaMotorista = null;
		listaMotorista = em.createQuery("FROM Motorista").getResultList();
		em.close();
		return listaMotorista;

	}
}
