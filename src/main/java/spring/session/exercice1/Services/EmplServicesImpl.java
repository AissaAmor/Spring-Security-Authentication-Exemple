package spring.session.exercice1.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;



import spring.session.exercice1.entities.Employe;
//import spring.session.exercice1.entities.Mission;
//import spring.session.exercice1.entities.Societe;
import spring.session.exercice1.repositories.EmpRepo;
import spring.session.exercice1.repositories.MissionRepo;
import spring.session.exercice1.Services.EmplServices;

@Service("employeservices")
public class EmplServicesImpl implements EmplServices {

	@Autowired
	EmpRepo emprepository;
	
	@Autowired
	MissionRepo missrepository;
	
	@PersistenceContext
	EntityManager em;
	
//	@Override
//	@Transactional
//	public Employe findbyUsername(String usernameOrEmail) {
//		Employe emp = null;
//		try {
//			emp=emprepository.findbyUsername(usernameOrEmail);
//		}catch(Exception e) {
//			throw e;
//		}
//		return emp;
//	}
	@Override
	public  List<Employe> getAll() {

		 return emprepository.findAll();
	}

	@Override
	public Employe getEmpById(Integer id) {
		
		  return emprepository.getOne(id);
	}

	@Override
	public void AjouterEmploye(Employe emp) {
		emprepository.save(emp);
	}

	@Override
	public void DeleteEmp(Employe emp) {
		emprepository.delete(emp);
		
	}
	@Override
	public Employe loadByUsername(String username) {
		System.out.println(username);
		TypedQuery<Employe> query = (TypedQuery<Employe>) em.createQuery("SELECT u FROM Employe u WHERE u.username = :username" ,Employe.class);
		Employe emp=query.setParameter("username", username).getSingleResult();
			return  emp;
		
	}
	@Override
	public Employe getConnectedEmploye(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe findbyUsername(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return null;
	}
}
