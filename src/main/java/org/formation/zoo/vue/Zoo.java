package org.formation.zoo.vue;

import java.util.Arrays;

import org.formation.zoo.controleur.Manager;
import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.service.CagePOJO;

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
	 * Methode privé qui charge le modele.
	 * Pour l'instant elle instancie les animaux
	 */
	
	public void afficher()
	{
	
		Arrays.asList(Manager.getInstance().afficher()).stream().forEach(System.out::println);
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
	 * @return le texte sur ce qu'il s'est passÃ©
	 */
	public void devorer(int mangeur, int mange)
	{
		 System.out.println(Manager.getInstance().devorer(mangeur, mange));
	}
	public void effacer(int cle) {
		Manager.getInstance().supprimer(cle);
		
	}
	
//	public void fermer() {
//		Manager.getInstance().fermer();
//	}
	
	public static void main(String[] args) {
		
		Zoo z = null;
		z = new Zoo();
		CagePOJO tmp = null;
		tmp = new CagePOJO();
		tmp.setCle(7);
		tmp.setAge(12);
		tmp.setCodeAnimal("Lion");
		tmp.setNom("lil");
		tmp.setPoids(98);
		tmp.setX(700);
		tmp.setY(310);
		Manager.getInstance().ajouter(tmp);
					
		
		z.afficher(); 
		System.out.println("on fait manger tous les animaux");
		z.nourrir();
		z.afficher();
		System.out.println("on tente de faire manger un animal par un autre");
//		System.out.println(z.devorer(1,0));
		z.devorer(0,1 );
		z.afficher();
		System.out.println("on supprime un animal");
		z.effacer(7);
		z.afficher();
		
		System.out.println("on ferme le zoo");
//		z.fermer();
	}

}
