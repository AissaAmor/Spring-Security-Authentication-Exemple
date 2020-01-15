package spring.session.exercice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.exercice1.Services.ContratServices;
import spring.session.exercice1.Services.EmplServices;
import spring.session.exercice1.entities.Contrat;
import spring.session.exercice1.entities.Employe;
//import spring.session.exercice1.entities.Societe;
//import spring.session.exercice1.entities.Employe;
//import spring.session.exercice1.entities.Societe;
import spring.session.exercice1.repositories.ContratRepo;

@RestController
@RequestMapping("/Contrat")
public class ContratController {

	@Autowired
	ContratRepo contratrepo;

	@Autowired
	ContratServices contratservices;

	@Autowired
	EmplServices emplservices;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addcontrat(@RequestBody Contrat con) {
		contratrepo.save(con);
	}

	
	
////    Ajouter un contrat par Id
//	
	@RequestMapping(path ="add/{employeId}" , method = RequestMethod.POST)
	public void AjoutEmploye(@RequestBody Contrat ctr , @PathVariable("employeId") Integer id) {
		Employe emp = emplservices.getEmpById(id);
//		emp.setContrat(ctr);
//		
//		
//		emplservices.AjouterEmploye(emp);
		ctr.setEmploye(emp);
		contratservices.ajoutContrat(ctr);
	}
//
//	
//	
//	
//   delete un contrat
	
	@RequestMapping(path = "/delete/{id}")
	public void deleteContrat(@PathVariable("id") Integer id) {
		Contrat contrat = contratservices.getContratById(id);
		contratservices.deleteContrat(contrat);
	}
}
