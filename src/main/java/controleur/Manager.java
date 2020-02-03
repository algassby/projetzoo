/**
 * 
 */
package controleur;

import java.util.List;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.modele.metier.Mangeable;
import org.formation.zoo.modele.technique.BeurkException;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.stockage.FichierAccess;

/**
 * @author algas
 *
 */
public final class Manager {
	
	private List<Cage> lesCages;
	private FichierAccess<Cage> acces;
	private static   Manager instance = new Manager();
	/**
	 * le constructeur doit etre privé
	 */
	private Manager() {
		lesCages = null;
		acces = new FichierAccess("zoo.data");
		init();		
		
	}
	
	
	/**
	 * @return instance, l'instance du singleton
	 */
	public static Manager getInstance() {
		
		return instance;
	}
	
	/**
	 * Méthode privé qui charge le modèle.
	 * Pour l'instant elle instancie les animaux
	 */
	private void init()
	{
		lesCages = acces.lireTous();
	}
	
	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir ()
	{
		for (int i = 0; i < lesCages.size(); i++) {
			if (lesCages.get(i).getOccupant() != null)
			{
				lesCages.get(i).getOccupant().manger();
			}
		}
	}
	
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passÃ©
	 */
	public String devorer(int mangeur, int mange)
	{
		Mangeable laBeteConvoitee = null;
		String s = "INCOMPATIBLE";
		if (lesCages.get(mange).getOccupant() != null && lesCages.get(mangeur).getOccupant() != null && lesCages.get(mange).getOccupant() instanceof Mangeable)
			{
				lesCages.get(mange).ouvrir();
				try {
					laBeteConvoitee = (Mangeable)lesCages.get(mange).sortir();
				} catch (PorteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try
				{
					s = lesCages.get(mangeur).getOccupant().manger(laBeteConvoitee);
				}
				catch (BeurkException e)
				{
					s = e.getMessage();
					try {
						lesCages.get(mange).entrer((Animal)laBeteConvoitee);
					} catch (PorteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CagePleineException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lesCages.get(mange).fermer();
				}
		}
		return s;
	}
	/**
	 * la methode qui permet de fermer la cage
	 */
	public void fermer() {
		acces.ecrireTous(lesCages);
	}
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
