/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;

import org.formation.zoo.service.CagePOJO;

/**
 * @author algas
 *
 */
public interface Dao<T> {
	public List<T> lireTous();
	public void ecrireTous(List<T> elt);
	public void modifier(int cle, T obj);
	public void modifier(T obj);
	public void effacer(T obj);
	public void effacer(int cle);
	public void ajouter(T obj);

}
