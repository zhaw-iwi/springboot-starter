package ch.zhaw.infm.springboottemplate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.infm.springboottemplate.entities.Infection;
import ch.zhaw.infm.springboottemplate.entities.Person;

public interface InfectionRepository extends JpaRepository<Infection, Long> {

	@Query("SELECT pe FROM Person pe, Infection i, Pathogen pa WHERE pe.id = i.person AND i.pathogen = pa.id AND i.location = ?1 AND pa.icd10 = ?2")
	public List<Person> getPersonsByInfectionByPathogen(String location, String icd10);
}
