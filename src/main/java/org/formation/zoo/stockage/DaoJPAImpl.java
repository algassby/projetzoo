/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;




/**
 * @author algas
 *
 */
public class DaoJPAImpl<T> implements Dao<T> {

	private Logger logger;
	private EntityManager em;
	public DaoJPAImpl() {
		logger = Logger.getLogger("logger");
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("projetzoo");
		em = emf.createEntityManager();
	}
	
	/**
	 * 
	 * @return la liste des enregistrement dans la base de données issus de la {@link PersonnePOJO}
	 */
	@SuppressWarnings("unchecked")
	
	public List<T> lireTous(){
		return em.createNamedQuery("findAll").getResultList();
	}
	
	@Override
	public void ecrireTous(List<T> elt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(int cle, T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}
	@Override
	public void modifier(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}
	
	@Override
	public void effacer(T objet) {
		try {
			if (!em.contains(objet)) {
				objet = em.merge(objet);
			}
			em.getTransaction().begin();
			em.remove(objet);
			em.getTransaction().commit();
			logger.log(Level.INFO, "Suppression reussi");
		} catch (Exception e) {
			logger.log(Level.INFO, "l'entité introuvable");
		}

	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void effacer(int cle) {
		T obj = null;
		try {
			if(!em.contains(obj)) {
				em.merge(obj);
			}
			em.getTransaction().begin();
			obj = (T) em.createNamedQuery("find").setParameter("idAnimal", cle).getSingleResult();
			em.remove(obj);
			em.getTransaction().commit();
			logger.log(Level.INFO, "Suppression reussi");
		}catch (Exception e) {
			logger.log(Level.INFO, "entité non rouvé");
		}
		
		
	}

	@Override
	public void ajouter(T obj) {
		try {
			
			if(em.contains(obj)) {
				em.merge(obj);
			}
			em.refresh(obj);
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			logger.log(Level.INFO,"a été ajouter avec succès");
		} catch (Exception e) {
			logger.log(Level.INFO, "entité existe deja");
		}
		
		
	}
	
	public int getNombreEnregistrement() {
		return em.createNamedQuery("findAll").getResultList().size();
	}
	@SuppressWarnings("unchecked")
	public T getPersonne(int cle) {
		return (T) em.createNamedQuery("find").setParameter("idAnimal", cle).getSingleResult();
	}
	
	public static void main(String []args) {
		DaoJPAImpl<CagePOJO> jp = null;
		CagePOJO tmp = null;
		tmp = new CagePOJO();
		GazellePOJO gp = new GazellePOJO();
		//l'animal
		tmp.setCle(15);
		tmp.setAge(10);
		tmp.setCodeAnimal("Gazelle");
		tmp.setNom("Marie");
		tmp.setPoids(70);
		tmp.setX(500);
		tmp.setY(500);

		//la gazelle
		gp.setId(20);
		
		
		gp.setLgCornes(12);
		
		gp.setIdAnimal(tmp.getCle());
		
		tmp.setGaz(gp);
		jp = new DaoJPAImpl<>();
		jp.ajouter(tmp);
		jp.effacer(tmp);
		//jp.effacer(tmp);
		jp.modifier(125,tmp);
		jp.effacer(80);
		
		jp.lireTous().forEach(System.out::println);
//		System.out.println(jp.getNombreEnregistrement());
//		
//		System.out.println(jp.getPersonne(9));
		
	}

	
	
}