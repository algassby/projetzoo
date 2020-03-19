package org.formation.zoo.stockage;
import java.io.*;
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
 * Classe technique qui gère les accès fichier pour la sauvegarde des animaux du zoo.
 * @author jacques
 *
 */
public class FichierAccess<T> implements Dao<T>{

	/**
	 * nom du fichier
	 */
	private String fichier;
	/**
	 * Collection des animaux lus
	 */
	private List<T> elts;
	/**
	 * constructeur
	 * @param f nom du fichier à lire et écrire
	 */
	public FichierAccess(String f)
	{
		fichier = f;
		elts = null;
		read();
	}

	/**
	 * méthode privée d'écriture de la collection
	 */
	private void write()
	{
	      ObjectOutputStream fic = null;
	      try {
	             fic= new ObjectOutputStream(new FileOutputStream(fichier));
	             fic.writeObject(elts);
	             fic.close();
	        } catch (IOException e) {
	          System.out.println(" erreur :" + e.getMessage());
	        }			
	}
	/**
	 * méthode privée de lecture de la collection dans, le fichier
	 */
	private void read() {
	    ObjectInputStream fic = null;
		File f = new File(fichier);
		try {
			fic= new ObjectInputStream(new FileInputStream(fichier));
			elts = (Vector<T>)fic.readObject();
			fic.close();
		}
		catch (IOException e) {
			//fichier inexistant tout remplir à la main en appelant init
//			init();
			DaoMemoire dm = new DaoMemoire();
			elts = (List<T>)dm.lireTous();
			
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	/**
	 * methode qui  qui rempli la liste si aucun fichier n'est trouv�
	 */
		public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	/**
	 *methode qui permet l'acces et la  lecture � l'information (fait partie de l'api)
	 * @return la collection lue
	 */
	@Override
	public List<CagePOJO> lireTous(){
		if (elts == null){
			read();
		}
		return (List<CagePOJO>) elts;
	}
	/**
	 * méthode qui permet l'accès en écriture à l'information (fait partie de l'api)
	 * @param lesCages la collection à persister
	 */
	@Override
	public void ecrireTous(List<T> lesCages) {
		elts = (List<T>) lesCages;
		write();
	}

	@Override
	public void modifier(int cle, T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(int cle) {
		// TODO Auto-generated method stub
		
	}


	

	
}
