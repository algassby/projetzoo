/**
 * 
 */
package org.formation.zoo.modele.technique;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.stockage.Dao;


import service.CagePOJO;
import utilitaire.Conversion;

/**
 * @author algas
 *
 */
public final class CageManager {

	private Cage controleur;
	private CagePOJO vue;
	private Dao<CagePOJO> modele;
	
	public CageManager(CagePOJO pojo, Dao<CagePOJO> dao) {
		modele  =  dao;
		vue = pojo;
		controleur = Conversion.pojoToCage(pojo);
	}
	public void entrer(Animal a) throws PorteException, CagePleineException{
	
		controleur.entrer(a);
		//mettre à jours le pojo
		//modifier le pojo

	}
	
	public void nourrir() {
		controleur.nourrir();
		if(controleur.getOccupant()!=null) {
			vue.setPoids(controleur.getOccupant().getPoids());
			modele.modifier(vue.getCle(), vue);
		}
		
	}
	@Override
	public String toString() {
		return controleur.toString();
	}
	
	

	
	
}
