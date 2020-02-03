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
	
	/**
	 * 
	 */
	public CagePOJO() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
		cle = 0;
		codeAnimal = null;
		nom = null;
		age = 0;
		poids = 0;
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
	

}
