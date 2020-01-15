package spring.session.exercice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.

import spring.session.exercice1.config.JwtTokenUtil;
import spring.session.exercice1.entities.JwtResponse;
import spring.session.exercice1.entities.Employe;
//import com.example.demo.entities.User;
//import spring.session.exercice1.entities.JwtRequest;
import spring.session.exercice1.Services.EmplServices;
import spring.session.exercice1.Services.EmplServicesImpl;
//import spring.session.exercice1.Services.JwtUserDetailsService;
import spring.session.exercice1.Services.SocieteServices;
import spring.session.exercice1.entities.Societe;
import spring.session.exercice1.repositories.EmpRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Employe")
public class EmployeController {

	@Autowired
	EmpRepo emprepo;
	
	@Autowired
	EmplServices empservices;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	SocieteServices societeservices;
	
//	@Autowired
//	private JwtUserDetailsService userDetailsService;
	
//	@RequestMapping(path = "add" , method = RequestMethod.POST)
//			public void addEmploye(@RequestBody Employe emp) {
//				empservices.AjouterEmploye(emp);
//	}
	@RequestMapping(path ="/all", method = RequestMethod.GET)
	public List<Employe> getAll(){
		return empservices.getAll();
	}
	@RequestMapping(path ="/add/{employeId}" , method = RequestMethod.POST)
	public void AjoutEmploye(@RequestBody Employe emp , @PathVariable("employeId") Integer id) {
		System.out.println(emp);
		Societe soc = societeservices.getSocieteById(id);
		soc.setEmpList(emp);
		 emp.setSociete(soc);
		empservices.AjouterEmploye(emp);
		 societeservices.AjouterSociete(soc);
		
		
	}
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
   	public void deleteEpmloye(@PathVariable("id") Integer id ) {
    	
    	Employe emp = empservices.getEmpById(id);
    	empservices.DeleteEmp(emp);    	
   	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody Employe credentials) throws Exception {
//		final Employe emp = empservices.loadByUsername(credentials.getUsername());
//		final String token = jwtTokenUtil.generateToken(emp);
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createToken(@RequestBody Employe employe) throws Exception {
		Employe emp = empservices.loadByUsername(employe.getUsername());
		final String token = jwtTokenUtil.generateToken(emp);

		return ResponseEntity.ok(new JwtResponse(token));
	}

//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
}
