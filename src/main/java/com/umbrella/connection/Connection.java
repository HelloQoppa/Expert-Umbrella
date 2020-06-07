package com.umbrella.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aluguel");

	public EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
