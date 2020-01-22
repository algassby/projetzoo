package org.formation.zoo.vue;

import java.util.List;
import java.util.Vector;

import org.formation.zoo.modele.*;
import org.formation.zoo.modele.technique.BeurkException;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.stockage.FichierAccess;

/**
 * Programme PRINCIPAL 
 * Contient le main
 * @author j.Vincensini
 *
 */
public final class Zoo {
	/**
	 * Vecteur de Cages. C'est la COMPOSITION.
	 */
	private List<Cage> lesCages;
	private FichierAccess acces;
		
	public Zoo() {
		lesCages = null;
		acces = new FichierAccess("zoo.data");
		init();		
		
		
	}
	/**
	 * Méthode privée qui charge le modèle.
	 * Pour l'instant elle instancie les animaux
	 */
	private void init()
	{
		lesCages = acces.lireTous();
	}
	public void afficher()
	{
		for (int i = 0; i < lesCages.size(); i++) {
			System.out.println(lesCages.get(i));
		}
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
	 * @return le texte sur ce qu'il s'est passé
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
	
	public void fermer() {
		acces.ecrireTous(lesCages);
	}
	
	public static void main(String[] args) {
		Zoo z = null;
		z = new Zoo();
					
		z.afficher(); 
		System.out.println("on fait manger tous les animaux");
		z.nourrir();
		z.afficher();
		System.out.println("on tente de faire manger un animal par un autre");
		System.out.println(z.devorer(1,0));
		z.afficher();
		System.out.println("on ferme le zoo");
		z.fermer();
	}

}
