/**
 * 
 */
package org.formation.zoo.stockage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author algas
 *
 */
public abstract class DaoORB  {
	Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost:3306/zoo";
	private final static String LOGIN = "root";
	private final static String PSWD = "";
	
	public DaoORB() {
		 try {
			connection = DriverManager.getConnection(URL, LOGIN,PSWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
