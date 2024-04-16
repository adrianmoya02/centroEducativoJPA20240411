package JPA20240411.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;

public class Controlador {

	private static EntityManagerFactory entityManagerFactory;

	private String nombreEntidadControlada = "";
	private Class entidadControlada = null;

	

	/**
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	
	
	
	/**
	 * 
	 */
	public List<Entidad> findAll () {
		EntityManager em = getEntityManagerFactory().createEntityManager();

		TypedQuery<Entidad> q = em.createQuery("SELECT e FROM " + this.nombreEntidadControlada + " e", this.entidadControlada);

		List<Entidad> entidades = (List<Entidad>) q.getResultList();

		em.close();
		return entidades;
	}

}
