/**
 * 
 */
package utilitaire;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Gazelle;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

/**
 * classe boite à outils
 * @author algas
 *
 */
public final  class Conversion {
	public static final String MODELE = "org.formation.zoo.modele.metier.";
	private static Logger logger;

	/**
	 * 
	 */
	private Conversion() {
		
	}
	/**
	 * transforme la cagePojo en cage
	 * @param cp, la cage pojo
	 * @return
	 */
	public static Cage pojoToCage(CagePOJO cp) {
		logger = Logger.getLogger("Level");
		Cage ret =  null;
		Animal bete = null;
		Class<?> laClasseDeLaBete = null;
		Class<?>lesTypes[] = null;
		Object lesValeurs[] =null;
		Constructor<?> construct =null;
		
		ret = new Cage(cp.getX(),cp.getY());
		//on teste si il ya un occupant
		if(cp.getCodeAnimal()!= null) {
			//si on a une gazelle
			if(cp.getCodeAnimal().equals("Gazelle")) {
				lesTypes = new Class<?>[4];
				lesValeurs = new Object[4];
				lesTypes[3] = int.class;
				lesValeurs[3] = cp.getGaz().getLgCornes();
			}
			else {
				lesTypes = new Class<?>[3];
				lesValeurs = new Object[3];
				
			}

			lesTypes[0] = String.class;
			lesTypes[1] = int.class;
			lesTypes[2] = double.class;
			/**
			 * les valeurs
			 */
			lesValeurs[0] = cp.getNom();
			lesValeurs[1] = cp.getAge();
			lesValeurs[2] = cp.getPoids();
			try {

				laClasseDeLaBete = Class.forName(String.join("", MODELE, cp.getCodeAnimal()));
				
				construct = laClasseDeLaBete.getConstructor(lesTypes);

				bete = (Animal) construct.newInstance(lesValeurs);
				ret.ouvrir();
				ret.entrer(bete);
				ret.fermer();
			} catch (ClassNotFoundException e) {
				
				
				logger.log(Level.SEVERE, e.getMessage());
			} catch (NoSuchMethodException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} catch (SecurityException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} catch (InstantiationException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} catch (IllegalAccessException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} catch (IllegalArgumentException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} catch (InvocationTargetException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} catch (PorteException e) {
				logger.log(Level.SEVERE, e.getMessage());
				
			} catch (CagePleineException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
			
		}
		return ret;
		
	}
	/**
	 * covertit une Cage en POJO
	 * @param c 
	 * @param cle
	 * @return Un objet cagePOJO
	 */
	public static CagePOJO cageToPojo(Cage c, int cle) {
		CagePOJO tmp = null;

			tmp = new CagePOJO();
			tmp.setCle(cle);
			tmp.setX(c.getX());
			tmp.setY(c.getY());
			// si la cage a un occcupants
			if(c.getOccupant() != null) {
				tmp.setCodeAnimal(c.getOccupant().getClass().getSimpleName());
				tmp.setNom(c.getOccupant().getNom());
				tmp.setAge(c.getOccupant().getAge());
				tmp.setPoids(c.getOccupant().getPoids());
			}
			
			// si la cage a une gazelle
			if (c.getOccupant() instanceof Gazelle){
				Gazelle g = (Gazelle) c.getOccupant();
				GazellePOJO gaz = new GazellePOJO();
				tmp.setGaz(gaz);
			}
			
		return tmp;
	}

}
