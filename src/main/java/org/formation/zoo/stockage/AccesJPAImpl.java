/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;
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
	
	
		
	}
	@Override
	public void modifier(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	@Override
	public void effacer(T obj) {
		
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void effacer(int cle) {
		T obj = null;
		em.getTransaction().begin();
		obj = (T) em.createNamedQuery("find").setParameter("idAnimal", cle).getSingleResult();
		em.remove(obj);
		em.getTransaction().commit();
		
	}

	@Override
	public void ajouter(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
	}
	
	public static void main(String []args) {
		AccesJPAImpl<CagePOJO> jp = null;
		CagePOJO tmp = null;
		tmp = new CagePOJO();
		GazellePOJO gp = new GazellePOJO();
		//l'animal
		tmp.setCle(15);
		tmp.setAge(10);
		tmp.setCodeAnimal("Singe");
		tmp.setNom("Lucie");
		tmp.setPoids(80);
		tmp.setX(500);
		tmp.setY(500);

		//la gazelle
		gp.setId(20);
		
		
		gp.setLgCornes(12);
		
		gp.setIdAnimal(tmp.getCle());
		
		tmp.setGaz(gp);
		
		jp = new AccesJPAImpl<>();
		//jp.ajouter(tmp);
		jp.effacer(15);
		//jp.effacer(tmp);
		//jp.modifier(tmp);
		
		jp.lireTous().forEach(System.out::println);
		
		
	}

	
	
}