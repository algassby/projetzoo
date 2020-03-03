/**
 * 
 */
package org.formation.zoo.stockage;

import org.formation.zoo.modele.metier.Cage;

import service.CagePOJO;

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
	
	public Dao<CagePOJO>getDao(){
		return new DaoJDBCImpl();
	}

}
