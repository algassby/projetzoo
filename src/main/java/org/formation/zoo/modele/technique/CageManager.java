/**
 * 
 */
package org.formation.zoo.modele.technique;

import java.util.ArrayList;
import java.util.List;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Mangeable;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;

import utilitaire.Conversion;

/**
 * @author algas
 *
 */
public final  class CageManager {
	
	public final static String IMAGES ="images/";

	private Cage controleur;
	private List<Cage> lesCages;
	private CagePOJO vue;
	private Dao<CagePOJO> modele;
	/**
	 * 
	 * @param pojo, cagePOJO 
	 * @param dao, le Dao
	 */
	
	public CageManager(CagePOJO pojo, Dao<CagePOJO> dao) {
		lesCages = new ArrayList<>();
		modele  =  dao;
		vue = pojo;
		controleur = Conversion.pojoToCage(pojo);
	}
	/**
	 * 
	 * @param m, interface mangeable
	 * @return
	 * @throws BeurkException
	 */
	public String faireManger(Mangeable mangeable) throws BeurkException {
		controleur = Conversion.pojoToCage(vue) ;
		String s = null;
			s = controleur.getOccupant().manger(mangeable);
			vue = Conversion.cageToPojo(controleur, vue.getCle());
			modele.modifier(vue.getCle(), vue);
		
		return s;
	}
	/**
	 * mise à jours de la vue
	 */
	public void refresh() {
		modele.modifier(vue.getCle(), this.getVue());
	}
	/**
	 * @return the vue
	 */
	public CagePOJO getVue() {
		String tmp = null;
		
		if(vue.getCodeAnimal()!=null) {	
			tmp = String.join(" ",vue.getNom(),Integer.toString(vue.getAge()),"ans",Double.toString(vue.getPoids()),"kg");
			vue.setPancarte(tmp);
			tmp = String.join("", IMAGES,vue.getCodeAnimal().toLowerCase(),".gif");
			vue.setImage(tmp);
		}
		else
		{
		vue.setPancarte("cage vide");
			tmp = String.join("", IMAGES,"cage.jpg");
			vue.setImage(tmp);
		}
		
				
		return vue;
	}
	/**
	 * @param vue the vue to set
	 */
	public void setVue(CagePOJO vue) {
		
				
	}
	/**
	 * faire entrer un a animal
	 * @param a
	 * @throws PorteException, si la porte est fermée 
	 * @throws CagePleineException, si la cage est pleine
	 */
	public void entrer(Animal a) throws PorteException, CagePleineException{
	
		controleur.ouvrir();
		controleur.entrer(a);
		//mettre à jours le pojo
		//modifier le pojo
		this.refresh();

	}
	/**
	 * nourrit l'animal
	 */
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
	/**
	 * @return the controleur
	 */
	public Cage getControleur() {
		return controleur;
	}
	/**
	 * @param controleur the controleur to set
	 */
	public void setControleur(Cage controleur) {
		this.controleur = controleur;
	}
	
	
}
