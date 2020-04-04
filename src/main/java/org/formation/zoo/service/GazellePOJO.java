/**
 * 
 */
package org.formation.zoo.service;

/**
 * @author algas
 *
 */
public class GazellePOJO {

	private static final long serialversionUID = 1L;
	private int id;
	private int idAnimal;
	private int lgCornes;
	
	public GazellePOJO() {
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the idAnimal
	 */
	public int getIdAnimal() {
		return idAnimal;
	}
	/**
	 * @param idAnimal the idAnimal to set
	 */
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	/**
	 * @return the lgCornes
	 */
	public int getLgCornes() {
		return lgCornes;
	}
	/**
	 * @param lgCornes the lgCornes to set
	 */
	public void setLgCornes(int lgCornes) {
		this.lgCornes = lgCornes;
	}
	@Override
	public String toString() {
		return "GazellePOJO [id=" + id + ", idAnimal=" + idAnimal + ", lgCornes=" + lgCornes + "]";
	}
	
	
	
}
