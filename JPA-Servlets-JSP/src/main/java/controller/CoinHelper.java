package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;
import model.Coin;


public class CoinHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week3assignment");
	
	
	
	public List<Coin> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Coin> allItems = em.createQuery("SELECT i FROM Coin i").getResultList();
		return allItems;
	}


	public void addCoin(Coin toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}





	public List<Coin> searchForCoinByType(String coinType) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select ch from Coin ch where ch.coin = :selectedCoin", Coin.class);
		typedQuery.setParameter("selectedCoin", coinType);
		
		List<Coin> foundCoins = typedQuery.getResultList();
		em.close();
		return foundCoins;
	}





	public List<Coin> searchForCoinByYear(int year) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select ch from Coin ch where ch.year = :selectedCoin", Coin.class);
		typedQuery.setParameter("selectedCoin", year);
		
		List<Coin> foundCoins = typedQuery.getResultList();
		em.close();
		return foundCoins;
	}





	public List<Coin> searchForCoinByMint(String mintMark) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select ch from Coin ch where ch.mint = :selectedCoin", Coin.class);
		typedQuery.setParameter("selectedCoin", mintMark);
		
		List<Coin> foundCoins = typedQuery.getResultList();
		em.close();
		return foundCoins;
	}





	public Coin searchForCoinById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Coin found = em.find(Coin.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCoin(Coin toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteCoin(Coin toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select ch from Coin ch where ch.coin = :selectedCoin and ch.year = :selectedYear and ch.mint = :selectedMint", Coin.class);		
		typedQuery.setParameter("selectedCoin", toDelete.getCoin());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedMint", toDelete.getMint());
		
		typedQuery.setMaxResults(1);
		
		Coin result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	public void cleanUp() {
		emfactory.close();
	}
}

