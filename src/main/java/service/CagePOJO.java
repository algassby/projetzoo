/**
 * 
 */
package service;

/**
 * @author algas
 *
 */
public class CagePOJO {

	private int x;
	private int y;
	private int cle;
	private String codeAnimal;//type de l'animal
	private String nom;
	private int age;
	private double poids;
	private GazellePOJO gaz;
	
	
	private String pancarte;
	private String image;
	
	/**
	 * initialise  les attributs à null
	 */
	public CagePOJO() {
		x = 0;
		y = 0;
		cle = 0;
		codeAnimal = null;
		nom = null;
		age = 0;
		poids = 0;
		gaz = null;
	}
	

	/**
	 * @return the gaz
	 */
	public GazellePOJO getGaz() {
		return gaz;
	}


	/**
	 * @param gaz the gaz to set
	 */
	public void setGaz(GazellePOJO gaz) {
		this.gaz = gaz;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the cle
	 */
	public int getCle() {
		return cle;
	}

	/**
	 * @param cle the cle to set
	 */
	public void setCle(int cle) {
		this.cle = cle;
	}

	/**
	 * @return the codeAnimal
	 */
	public String getCodeAnimal() {
		return codeAnimal;
	}

	/**
	 * @param codeAnimal the codeAnimal to set
	 */
	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}


	@Override
	public String toString() {
		return "CagePOJO [x=" + x + ", y=" + y + ", cle=" + cle + ", codeAnimal=" + codeAnimal + ", nom=" + nom
				+ ", age=" + age + ", poids=" + poids + ", gaz=" + gaz + "]";
	}


	/**
	 * @return the pancarte
	 */
	public String getPancarte() {
		return pancarte;
	}


	/**
	 * @param pancarte the pancarte to set
	 */
	public void setPancarte(String pancarte) {
		this.pancarte = pancarte;
	}


	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
