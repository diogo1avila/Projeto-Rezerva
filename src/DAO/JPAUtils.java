/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 12141000517
 */
public class JPAUtils {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rezerva");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
