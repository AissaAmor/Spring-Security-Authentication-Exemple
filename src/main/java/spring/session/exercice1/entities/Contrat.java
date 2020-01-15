package spring.session.exercice1.entities;

import javax.persistence.GenerationType;
//
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity
public class Contrat {
	@Override
	public String toString() {
		return "Contrat [id_contrat=" + id_contrat + ", nom_contrat=" + nom_contrat + ", employe=" + employe + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_contrat;
	private String nom_contrat;
	public String getNom_contrat() {
		return nom_contrat;
	}

	public void setNom_contrat(String nom_contrat) {
		this.nom_contrat = nom_contrat;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@OneToOne
	private Employe employe;

	public Contrat(int id_contrat, String nom_contrat) {
		super();
		this.id_contrat = id_contrat;
		this.nom_contrat = nom_contrat;
	}

	public Contrat() {
		super();
	}

	public int getId_contrat() {
		return id_contrat;
	}

	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}

	public String getNom() {
		return nom_contrat;
	}

	public void setNom(String nom) {
		this.nom_contrat = nom;
	}


}
