package spring.session.exercice1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_mission;
	private String nom_mission;
	
	@ManyToMany(mappedBy = "listMission")
	private List<Employe> listemp= new ArrayList<Employe>();

	
	public int getId_mission() {
		return id_mission;
	}
	public void setId_mission(int id_mission) {
		this.id_mission = id_mission;
	}
	public String getNom_mission() {
		return nom_mission;
	}
	public void setNom_mission(String nom_mission) {
		this.nom_mission = nom_mission;
	}
	
	public Mission(int id_mission, String nom_mission, List<Employe> listemp) {
		super();
		this.id_mission = id_mission;
		this.nom_mission = nom_mission;
		this.listemp = listemp;
	}
	@Override
	public String toString() {
		return "Mission [id_mission=" + id_mission + ", nom_mission=" + nom_mission + ", listemp=" + listemp + "]";
	}
	
}
