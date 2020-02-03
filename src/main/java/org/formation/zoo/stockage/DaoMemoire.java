/**
 * 
 */
package org.formation.zoo.stockage;

import java.util.List;
import java.util.Vector;

import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Gazelle;
import org.formation.zoo.modele.metier.Lion;
import org.formation.zoo.modele.metier.Singe;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;

import service.CagePOJO;

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
		elts = new Vector<CagePOJO>();
	
			tmp = new CagePOJO();
			tmp.setCodeAnimal("Singe");
			tmp.setCle(0);
			tmp.setX(100);
			tmp.setY(200);
			tmp.setAge(20);
			tmp.setPoids(75);
			elts.add(tmp);
			
			tmp = new CagePOJO();
			tmp.setX(234);
			tmp.setY(654);
			tmp.setCle(1);
			elts.add(tmp);
			
	}



}
