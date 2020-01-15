package spring.session.exercice1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.session.exercice1.entities.Employe;

@Repository("EmployeRepository")
public interface EmpRepo extends JpaRepository<Employe,Integer>{
}
