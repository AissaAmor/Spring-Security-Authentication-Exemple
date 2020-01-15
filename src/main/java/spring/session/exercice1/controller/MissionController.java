package spring.session.exercice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import spring.session.exercice1.Services.MissionServices;
import spring.session.exercice1.entities.Mission;
import spring.session.exercice1.repositories.MissionRepo;

@RestController
@RequestMapping("/Mission")

public class MissionController {
	
	@Autowired
	MissionRepo missionrepo;
	
//	@Autowired
//	MissionServices missionservices;
	
    @RequestMapping(path ="add", method = RequestMethod.POST)
    public void addmission(@RequestBody Mission miss) {
    	missionrepo.save(miss);
    }
    
//    @RequestMapping(value = "/delete/{idMission}", method = RequestMethod.DELETE)
//   	public void deleteMission(@PathVariable("idMission") Integer id ) {
//    	
//    	Mission mission = missionservices.getMissionById(id);
//    	missionservices.DeleteMission(mission);  	
//   	}
}
