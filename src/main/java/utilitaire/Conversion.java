/**
 * 
 */
package utilitaire;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;

import service.CagePOJO;

/**
 * classe boite � outils
 * @author algas
 *
 */
public final  class Conversion {
	public static final String MODELE = "org.formation.zoo.modele.metier";

	/**
	 * 
	 */
	private Conversion() {
		
	}
	public static Cage pojoToCage(CagePOJO cp) {
		Cage ret =  null;
		Animal bete = null;
		Class<?> laClasseDeLaBete = null;
		Class<?>lesTypes[] = null;
		Object lesValeurs[] =null;
		Constructor<?> construct =null;
		
		ret = new Cage(cp.getX(),cp.getY());
		if(cp.getCodeAnimal()!= null) {
			try {
//				laClasseDeLaBete = Class.forName(MODELE+cp.getCodeAnimal());
				laClasseDeLaBete = Class.forName(String.join(" ", MODELE, cp.getCodeAnimal()));
				lesTypes = new Class<?>[3];
				lesValeurs = new Object[3];
				/**
				 * les types
				 */
				lesTypes[0] = String.class;
				lesTypes[1] = int.class;
				lesTypes[2] = double.class;
				/**
				 * les valeurs
				 */
				lesValeurs[0] = cp.getNom();
				lesValeurs[1] = cp.getAge();
				lesValeurs[2] = cp.getPoids();
				construct = laClasseDeLaBete.getConstructor(lesTypes);
				bete = (Animal) construct.newInstance(lesValeurs);
				ret.ouvrir();
				ret.entrer(bete);
				ret.fermer();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PorteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CagePleineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ret;
		
	}

}
