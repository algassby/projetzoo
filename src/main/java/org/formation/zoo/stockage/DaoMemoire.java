/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;
import java.util.Vector;

import service.CagePOJO;
import service.GazellePOJO;

/**
 * @author algas
 *
 */
public class DaoMemoire implements Dao<CagePOJO> {

	private List<CagePOJO> elts;
	/**
	 * 
	 */
	public DaoMemoire() {
		init();
	}

	@Override
	public List<CagePOJO> lireTous() {
		
		return elts;
	}

	@Override
	public void ecrireTous(List<CagePOJO> elt) {
		// TODO Auto-generated method stub
		
	}
	private void init()
	{
		CagePOJO tmp = null;
		elts = new Vector<>();
	
			tmp = new CagePOJO();
			tmp.setCodeAnimal("Singe");
			tmp.setCle(0);
			tmp.setX(100);
			tmp.setY(400);
			tmp.setAge(20);
			tmp.setPoids(75.0);
			tmp.setNom("baloo");
			elts.add(tmp);
			
			tmp = new CagePOJO();
			tmp.setX(150);
			tmp.setY(400);
			tmp.setCle(1);
			elts.add(tmp);
			
//			tmp = new CagePOJO();
//			tmp.setCodeAnimal("Gazelle");
//			tmp.setCle(2);
//			tmp.setX(100);
//			tmp.setY(500);
//			tmp.setAge(25);
//			tmp.setPoids(100);
//			tmp.setGaz(new GazellePOJO());
//			elts.add(tmp);
			
	}

	@Override
	public void modifier(int cle, CagePOJO obj) {
		elts.set(cle, obj);
		
	}

	@Override
	public void effacer(CagePOJO obj) {
		elts.remove(obj);
	}

	@Override
	public void ajouter(CagePOJO obj) {
		elts.add(obj);
		
	}

	@Override
	public void effacer(int cle) {
		elts.remove(cle);
		
	}

	


}
