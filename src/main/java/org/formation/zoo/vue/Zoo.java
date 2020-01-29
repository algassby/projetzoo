package org.formation.zoo.vue;

import java.util.List;
import java.util.Vector;


import org.formation.zoo.modele.technique.BeurkException;
import org.formation.zoo.modele.technique.CagePleineException;
import org.formation.zoo.modele.technique.PorteException;
import org.formation.zoo.stockage.FichierAccess;

import controleur.Manager;

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
//	private List<Cage> lesCages;
//	private FichierAccess acces;
		
	public Zoo() {
		
		
	}
	/**
	 * Méthode privée qui charge le modèle.
	 * Pour l'instant elle instancie les animaux
	 */
	
	public void afficher()
	{
		Manager.getInstance().afficher();
	}
	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir ()
	{
		Manager.getInstance().nourrir();
	}
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
	public String devorer(int mangeur, int mange)
	{
		return Manager.getInstance().devorer(mangeur, mange);
	}
	
	public void fermer() {
		Manager.getInstance().fermer();
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
