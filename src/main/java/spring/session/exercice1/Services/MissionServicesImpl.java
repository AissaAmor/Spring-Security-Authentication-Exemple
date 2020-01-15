package spring.session.exercice1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.exercice1.entities.Employe;
import spring.session.exercice1.entities.Mission;
import spring.session.exercice1.repositories.EmpRepo;
import spring.session.exercice1.repositories.MissionRepo;

@Service("missionservice")
public class MissionServicesImpl  implements MissionServices{

	@Autowired
	MissionRepo missionrepo;
	
	@Autowired
	EmpRepo emprepo;
	@Override
	public List<Employe> getAll() {
		
		 return emprepo.findAll();
	}

	@Override
	public Mission getMissionById(Integer id) {
		
		  return missionrepo.getOne(id);

	}

	@Override
	public void AjouterMission(Mission mission) {
		missionrepo.save(mission);
		
	}

	@Override
	public void DeleteMission(Mission mission) {
		
		missionrepo.delete(mission);
		
	}

}
