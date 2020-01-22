/**
 * 
 */
package controleur;

/**
 * @author algas
 *
 */
public final class Manager {
	
	private static   Manager instance = null;
	/**
	 * le constructeur doit etre privé
	 */
	private Manager() {
		
	}
	/**
	 * @return the instance
	 */
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	

}
