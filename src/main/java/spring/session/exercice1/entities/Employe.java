package spring.session.exercice1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import spring.session.exercice1.config.BCryptManagerUtil;

@Entity
public class Employe implements Serializable{

	private static final long serialVersionUID = 5926468583005150707L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_employe;
	private String nom;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_societe")
	private Societe societe;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Mission> listMission = new ArrayList<Mission>();

	@OneToOne(mappedBy = "employe", cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contrat")
	private Contrat contrat;
	@NotNull
	private String username;
	private String password;

	public Employe() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public Employe(int id_employe, String nom, Societe societe, List<Mission> listMission, Contrat contrat,
			String username, String password) {
		super();
		this.id_employe = id_employe;
		this.nom = nom;
		this.societe = societe;
		this.listMission = listMission;
		this.contrat = contrat;
		this.username = username;
		this.password = BCryptManagerUtil.passwordEncoder().encode(password);
	}
	public Employe(String nom, String username, String password) {
		super();
		this.nom = nom;
		this.username = username;
		this.password = BCryptManagerUtil.passwordEncoder().encode(password);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public List<Mission> getListMission() {
		return listMission;
	}

	public void setListMission(List<Mission> listMission) {
		this.listMission = listMission;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

//	public void setContratList(Contrat ctr) {
//		this.listContrat.add(ctr);
//	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCryptManagerUtil.passwordEncoder().encode(password);
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}
