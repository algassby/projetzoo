/**
 * 
 */
package org.formation.zoo.stockage;

import org.formation.zoo.modele.metier.Cage;

/**
 * @author algas
 *
 */
public class DaoFactory {

	private static DaoFactory instance  = new DaoFactory();
	/**
	 * 
	 */
	public DaoFactory() {
		
	}
	/**
	 * @return the instance
	 */
	public static DaoFactory getInstance() {
		return instance;
	}
	
	public Dao<Cage>getDao(){
		return new FichierAccess<Cage>("zoo.data");
	}

}
