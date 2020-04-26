/**
 * 
 */
package org.formation.zoo.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.formation.zoo.modele.technique.CageManager;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;

/**
 * @author algas
 *
 */
public final class Manager {
	
	private List<CageManager> lesCages;
	private Dao<CagePOJO> acces;
	private Logger logger;

	
	private static   Manager instance = new Manager();
	/**
	 * le constructeur doit etre priv�
	 */
	private Manager() {
		lesCages = null;
		//acces = DaoFactory.getInstance().getDao();
		acces = DaoFactory.getInstance().getClassDao();
		logger = Logger.getLogger("Level");

		init();
	}
	/**
	 * @return instance, l'instance du singleton
	 */
	public static Manager getInstance() {
		
		return instance;
	}
	
	public List<CagePOJO> getAnimaux(){
		List<CagePOJO> ret = null;
		ret = new Vector<>();
		for(CageManager cm: lesCages ) {
			ret.add(cm.getVue());
		}
		
		return ret;
	}
	
	public void ajouter() {
		
	}
	
	/**
	 * M�thode priv� qui charge le mod�le.
	 * Pour l'instant elle instancie les animaux
	 */
	public void init()
	{
		//lesCages = acces.lireTous();
		List<CagePOJO> tmp  = null;
		tmp = new Vector<>();
		tmp= acces.lireTous();
		//this.acces.ecrireTous(tmp);
		
		//tmp = classe.getClass().getM
		lesCages = new ArrayList<>();
		for (CagePOJO cagePOJO : tmp) {
			lesCages.add(new CageManager(cagePOJO, acces));
			
		}
		this.acces.lireTous();
		//this.acces.ecrireTous(tmp);
		//this.acces.ecrireTous(tmp);
		
	
		
	}
	
	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir ()
	{
		for (CageManager cageManager : lesCages) {
			cageManager.nourrir();
			
		}
	}
	
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
//	public String devorer(int mangeur, int mange)
//	{
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
//	}
	
//	public void devorer(int mangeur, int mange) {
//		for (CageManager cageManager : lesCages) {
//			logger.log(Level.INFO, cageManager.devorer(mangeur, mange) );
//			
//		}
//		//lesCages.forEach(item->devorer(mangeur, mange)); 
//	}
	/**
	 * la methode qui permet de fermer la cage
	 */
//	public void fermer() {
//		acces.ecrireTous(lesCages);
//	}
	public String[] afficher()
	{
		String res [];
		
		res = new String[lesCages.size()];
		for(int i = 0; i < lesCages.size();i++)
		{
			res[i] = lesCages.get(i).toString();
		}
		return res;
	}

}
