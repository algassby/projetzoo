package org.formation.zoo.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the gazelle database table.
 * 
 */
@Entity
@NamedQuery(name="Gazelle.findAll", query="SELECT g FROM Gazelle g")
public class Gazelle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte id;

	private byte lgCornes;

	//bi-directional one-to-one association to AnimalPOJO
//	@OneToOne(mappedBy="gazelle")
//	private AnimalPOJO animal;
 
	public Gazelle() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public byte getLgCornes() {
		return this.lgCornes;
	}

	public void setLgCornes(byte lgCornes) {
		this.lgCornes = lgCornes;
	}

	@Override
	public String toString() {
		return "Gazelle [id=" + id + ", lgCornes=" + lgCornes + "]";
	}
	
	

//	public AnimalPOJO getAnimal() {
//		return this.animal;
//	}
//
//	public void setAnimal(AnimalPOJO animal) {
//		this.animal = animal;
//	}

}