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




/**
 * @author algas
 *
 */
public class AccesJPAImplt<T> implements Dao<T> {

	private Logger logger;
	private EntityManager em;
	public AccesJPAImplt() {
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

	@Override
	public void effacer(int cle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
	}
	
	public static void main(String []args) {
		AccesJPAImplt<AnimalPOJO> jp = null;
		AnimalPOJO tmp = null;
		tmp = new AnimalPOJO();
		
		
		jp = new AccesJPAImplt<>();
		jp.lireTous().forEach(System.out::println);
		jp.ajouter(tmp);
		
		
	}
	
	
}