package spring.session.exercice1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.exercice1.entities.Contrat;

@Repository("contratRepository")
public interface ContratRepo  extends JpaRepository<Contrat, Integer >{
}
