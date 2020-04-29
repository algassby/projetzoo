/**
 * 
 */
package org.formation.zoo.modele.technique;

import java.util.ArrayList;
import java.util.List;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
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
	
	public CageManager(CagePOJO pojo, Dao<CagePOJO> dao) {
		lesCages = new ArrayList<>();
		modele  =  dao;
		vue = pojo;
		controleur = Conversion.pojoToCage(pojo);
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
	public void entrer(Animal a) throws PorteException, CagePleineException{
	
		controleur.ouvrir();
		controleur.entrer(a);
		//mettre à jours le pojo
		//modifier le pojo

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
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
//	public String devorer(int mangeur, int mange) {
//		Mangeable laBeteConvoitee = null;
//		String s = "INCOMPATIBLE";
//		if (lesCages.get(mange).getOccupant() != null && lesCages.get(mangeur).getOccupant() != null && lesCages.get(mange).getOccupant() instanceof Mangeable)
//			{
//				lesCages.get(mange).ouvrir();
//				try {
//					laBeteConvoitee = (Mangeable)lesCages.get(mange).sortir();
//				} catch (PorteException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
//				try
//				{
//					s = lesCages.get(mangeur).getOccupant().manger(laBeteConvoitee);
//				}
//				catch (BeurkException e)
//				{
//					s = e.getMessage();
//					try {
//						lesCages.get(mange).entrer((Animal)laBeteConvoitee);
//					} catch (PorteException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (CagePleineException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
////					lesCages.get(mange).fermer();
//				}
//		}
//		return s;
		
	//}
	
	
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
