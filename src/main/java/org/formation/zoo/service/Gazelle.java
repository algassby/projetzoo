package org.formation.zoo.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the gazelle database table.
 * 
 */
@Entity
@NamedQuery(name = "Gazelle.findAll", query = "SELECT g FROM Gazelle g")
public class Gazelle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int idAnimal;

	private int lgCornes;

	// bi-directional one-to-one association to AnimalPOJO
//	@OneToOne(mappedBy="gazelle")

	// private AnimalPOJO animal;

	public Gazelle() {
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