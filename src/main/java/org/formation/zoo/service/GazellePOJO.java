package org.formation.zoo.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the gazelle database table.
 * 
 */
@Entity
@Table(name = "gazelle")
@NamedQuery(name = "GazellePOJO.findAll", query = "SELECT g FROM GazellePOJO g")
public class GazellePOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int idAnimal;

	private int lgCornes;

	// bi-directional one-to-one association to AnimalPOJO
//	@OneToOne(mappedBy="gazelle")

	// private AnimalPOJO animal;

	public GazellePOJO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLgCornes() {
		return this.lgCornes;
	}

	public void setLgCornes(int lgCornes) {
		this.lgCornes = lgCornes;
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

	@Override
	public String toString() {
		return "Gazelle [id=" + id + ", idAnimal=" + idAnimal + ", lgCornes=" + lgCornes + "]";
	}
	
	

	
//	public AnimalPOJO getAnimal() {
//		return this.animal;
//	}
//
//	public void setAnimal(AnimalPOJO animal) {
//		this.animal = animal;
//	}

}