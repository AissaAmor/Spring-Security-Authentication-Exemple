package spring.session.exercice1.Services;

import java.util.List;


//import spring.session.exercice1.entities.Employe;
import spring.session.exercice1.entities.Societe;

public interface SocieteServices {

public List<Societe> getAll();
	
	public Societe getSocieteById(Integer id);
	
	public void  AjouterSociete(Societe societe);
	
	public void DeleteSociete(Societe societe );

}
