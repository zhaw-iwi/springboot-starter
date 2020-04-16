package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Infection;
import ch.zhaw.springboot.entities.Person;
import ch.zhaw.springboot.repositories.InfectionRepository;

@RestController
public class InfectionRestController {

	@Autowired
	private InfectionRepository repository;

	@RequestMapping(value = "infections/infections", method = RequestMethod.GET)
	public ResponseEntity<List<Infection>> getInfections() {
		List<Infection> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Infection>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Infection>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "infections/infections/{location}/{icd10}", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getPersonsByInfectionByPathogen(@PathVariable("location") String location,
			@PathVariable("icd10") String icd10) {
		List<Person> result = this.repository.getPersonsByInfectionByPathogen(location, icd10);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Person>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
	}
}
