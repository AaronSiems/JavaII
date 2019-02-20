package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Collection;

public class CollectionHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA-Joins");
	
	public void insertNewCollection(Collection c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Collection> getCollections() {
		EntityManager em = emfactory.createEntityManager();
		List<Collection> allDetails = em.createQuery("SELECT d FROM Collection d").getResultList();
		return allDetails;
		
	}
	
	
	public Collection searchForCollectionById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Collection found = em.find(Collection.class, idToEdit);
		em.close();
		return found;
	}
	
	
	public void deleteCollection(Collection toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Collection> typedQuery = em.createQuery("select ch from Collection ch where ch.name = :selectedCollection", Collection.class);		
		typedQuery.setParameter("selectedCollection", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		Collection result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
