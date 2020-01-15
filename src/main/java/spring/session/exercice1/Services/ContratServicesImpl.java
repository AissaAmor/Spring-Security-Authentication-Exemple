package spring.session.exercice1.Services;

import javax.persistence.EntityManager;
//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import spring.session.exercice1.entities.Contrat;
import spring.session.exercice1.repositories.ContratRepo;



@Service("contratservices")

public class ContratServicesImpl implements ContratServices  {
	
	@Autowired
	ContratRepo contratrepo;
	
	@Autowired
	EntityManager em ;
	@Override
	public void ajoutContrat(Contrat contrat) {
		contratrepo.save(contrat);

	}

	@Override
	public void deleteContrat(Contrat contrat) {
		contratrepo.delete(contrat);
	}

	@Override
	public Contrat getContratById(Integer id) {
		  return contratrepo.getOne(id);

	}

}
