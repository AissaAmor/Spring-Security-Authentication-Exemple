package spring.session.exercice1.Services;

import java.util.List;


import spring.session.exercice1.entities.Employe;
import spring.session.exercice1.entities.Mission;

public interface MissionServices {
	
	public List<Employe> getAll();
	
	public Mission getMissionById(Integer id);
	
	public void  AjouterMission(Mission mission);
	
	public void DeleteMission (Mission mission );

}
