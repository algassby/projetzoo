/**
 * 
 */
package org.formation.zoo.stockage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	Properties properties;
	/**
	 * 
	 */
	private DaoFactory() {
		properties = new Properties();
		charger();
		try {
			classe = classe.forName(properties.getProperty("CLASS1"));
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
	
	public Dao<CagePOJO>getDao(){
		charger();
		Class<?> maClass = null;
		try {
			maClass = Class.forName(this.getProperties().getProperty("CLASS1"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return new DaoJDBCImpl();
//		return new DaoMemoire();
	}

}
