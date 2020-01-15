package spring.session.exercice1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import com.example.demo.entities.Post;

@Entity
public class Societe {

@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id_societe;
 private String nom;
 @OneToMany(fetch = FetchType.EAGER,mappedBy = "societe")
 private List<Employe> listemp= new ArrayList<Employe>();

 
public int getId_societe() {
	return id_societe;
}
public void setId_societe(int id_societe) {
	this.id_societe = id_societe;
}
public String getNom() {
	return nom;
}
public Societe() {
	super();
}
public Societe(int id_societe, String nom, List<Employe> listemp) {
	super();
	this.id_societe = id_societe;
	this.nom = nom;
	this.listemp = listemp;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Societe(int id_societe, String nom) {
	super();
	this.id_societe = id_societe;
	this.nom = nom;
}
public void setEmpList(Employe emp ) {
	this.listemp.add(emp);
}
@Override
public String toString() {
	return "Societe [id_societe=" + id_societe + ", nom=" + nom + ", listemp=" + listemp + "]";
}

}
