/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;

import service.CagePOJO;

/**
 * @author algas
 *
 */
public interface Dao<T> {
	public List<CagePOJO> lireTous();
	public void ecrireTous(List<T> elt);
	public void modifier(int cle, T obj);
	public void effacer(T obj);
	public void effacer(int cle);
	public void ajouter(T obj);

}
