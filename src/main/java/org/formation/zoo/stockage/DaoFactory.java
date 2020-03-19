/**
 * 
 */
package org.formation.zoo.stockage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import org.formation.zoo.modele.metier.Cage;
import service.CagePOJO;

/**
 * @author algas
 *
 */
public class DaoFactory {

	private static DaoFactory instance  = new DaoFactory();
	Class<?> classe;
	Dao<CagePOJO> dao;
	Properties properties;
	/**
	 * initialise les attributs Dao,properties
	 */

	private DaoFactory() {
		properties = new Properties();
		charger();
		try {
			try {
				try {
					//classe = (Class<CagePOJO>) classe.forName(properties.getProperty("CLASS")).getConstructor().newInstance(null);
					classe = (Class<?>) Class.forName(properties.getProperty("CLASS"));
					dao = (Dao<CagePOJO>) classe.getConstructor(null).newInstance(null);
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}
/**
 * charge le fichier classConfig.properties qui contient le chemin de la classe à instancier
 * en se servant de la reflexion 
 */
	public void charger() {
		try {
			properties.load(new FileInputStream("classConfig.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the instance
	 */
	public static DaoFactory getInstance() {
		return instance;
	}
	
	/*public Dao<CagePOJO>getDao(){
	
		return new DaoJDBCImpl();
		return new DaoMemoire();
	}*/
	
	/**
	 * 
	 * @return dao, retourne le Dao souhaitez, DaoMemoire, DaoJDBCImpl...
	 */
	public Dao<CagePOJO>getClassDao(){
			return dao;
		
	}

}
