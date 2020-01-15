package spring.session.exercice1.Services;

import java.util.List;


//import org.springframework.stereotype.Service;

import spring.session.exercice1.entities.Employe;
//import spring.session.exercice1.entities.Societe;
//import spring.session.exercice1.entities.Mission;

public interface EmplServices {
	
	Employe findbyUsername(String usernameOrEmail);
	public List<Employe> getAll();
	public Employe getEmpById(Integer id);
	public void  AjouterEmploye(Employe emp);
	public void DeleteEmp(Employe emp);
	public Employe loadByUsername(String username);
	public Employe getConnectedEmploye(String username);
}
