package spring.session.exercice1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.exercice1.entities.Mission;

@Repository("MissionRepository")
public interface MissionRepo extends JpaRepository<Mission,Integer>{

}
