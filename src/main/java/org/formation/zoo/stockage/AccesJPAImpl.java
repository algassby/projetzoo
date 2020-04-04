/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formation.zoo.service.AnimalPOJO;
import org.formation.zoo.service.Gazelle;




/**
 * @author algas
 *
 */
public class AccesJPAImpl<T> implements Dao<T> {

	private Logger logger;
	private EntityManager em;
	public AccesJPAImpl() {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(T obj) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void effacer(int cle) {
		T obj = null;
		em.getTransaction().begin();
		obj = (T) em.createNamedQuery("find").setParameter("idAnimal", cle).getSingleResult();
		em.remove(obj);
	}

	@Override
	public void ajouter(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
	}
	
	public static void main(String []args) {
		AccesJPAImpl<AnimalPOJO> jp = null;
		AnimalPOJO tmp = null;
		tmp = new AnimalPOJO();
		Gazelle gp = new Gazelle();
		//l'animal
		tmp.setIdAnimal(16);
		tmp.setAge(10);
		tmp.setCodeAnimal("Gazelle");
		tmp.setNom("LouisLEN");
		tmp.setPoids(80);
		tmp.setX(600);
		tmp.setY(500);

		//la gazelle
		gp.setId(16);
		
		gp.setLgCornes(12);
		
		gp.setIdAnimal(tmp.getIdAnimal());
		
		tmp.setGazelle(gp);
		
		jp = new AccesJPAImpl<>();
		//jp.ajouter(tmp);
		//jp.effacer(16);
		
		jp.lireTous().forEach(System.out::println);
		
		
		
		
	}
	
	
}