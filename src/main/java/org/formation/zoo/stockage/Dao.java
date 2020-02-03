/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;

/**
 * @author algas
 *
 */
public interface Dao<T> {
	public List<T> lireTous();
	public void ecrireTous(List<T> elt);

}
