package spring.session.exercice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.exercice1.Services.SocieteServices;
//import spring.session.exercice1.entities.Employe;
//import spring.session.exercice1.Services.SocieteServices;
import spring.session.exercice1.entities.Societe;
import spring.session.exercice1.repositories.SocieteRepo;

@RestController
@RequestMapping("/Societe")
public class SocieteController {
	
	@Autowired
	SocieteRepo societerep;
	
	@Autowired
	SocieteServices societeservices;
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addSociete(@RequestBody Societe soc) {
		societerep.save(soc);
	}
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
   	public void deleteEpmloye(@PathVariable("id") Integer id ) {
    	
    	Societe soc = societeservices.getSocieteById(id);
    	societeservices.DeleteSociete(soc);    	
   	}

}
