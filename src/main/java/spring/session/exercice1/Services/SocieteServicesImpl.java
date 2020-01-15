package spring.session.exercice1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.exercice1.entities.Societe;
import spring.session.exercice1.repositories.SocieteRepo;

@Service("societeservices")
public class SocieteServicesImpl implements SocieteServices{

	@Autowired
	SocieteRepo societerepo;
	@Override
	public List<Societe> getAll() {
		
		return societerepo.findAll();
	}

	@Override
	public Societe getSocieteById(Integer id) {
		return societerepo.getOne(id);
		
	}

	@Override
	public void AjouterSociete(Societe societe) {
		societerepo.save(societe);
	}

	@Override
	public void DeleteSociete(Societe societe) {
		societerepo.delete(societe);
		
	}

}
