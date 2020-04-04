package org.formation.zoo.service;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@Table(name="animal")
@NamedQueries({@NamedQuery(name="findAll", query="SELECT a FROM AnimalPOJO a"),
		@NamedQuery(name="find", query="SELECT a FROM AnimalPOJO a WHERE a.idAnimal= :idAnimal")
})

public class AnimalPOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAnimal;

	private int age;

	private String codeAnimal;

	private String nom;

	private float poids;

	private int x;

	private int y;

	//bi-directional one-to-one association to Gazelle
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idAnimal", referencedColumnName="idAnimal", insertable=false, updatable=false)
	private Gazelle gazelle;

	public AnimalPOJO() {
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCodeAnimal() {
		return this.codeAnimal;
	}

	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPoids() {
		return this.poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Gazelle getGazelle() {
		return this.gazelle;
	}
	
	

	@Override
	public String toString() {
		return "AnimalPOJO [idAnimal=" + idAnimal + ", age=" + age + ", codeAnimal=" + codeAnimal + ", nom=" + nom
				+ ", poids=" + poids + ", x=" + x + ", y=" + y + ", gazelle=" + gazelle + "]";
	}

	public void setGazelle(Gazelle gazelle) {
		this.gazelle = gazelle;
	}
	
	

}