package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.Pathogen;
import ch.zhaw.infm.springboottemplate.repositories.PathogenRepository;

@RestController
public class PathogenRestController {

	@Autowired
	private PathogenRepository repository;

	@RequestMapping(value = "infections/pathogens", method = RequestMethod.GET)
	public ResponseEntity<List<Pathogen>> getPathogens() {
		List<Pathogen> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Pathogen>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Pathogen>>(HttpStatus.NOT_FOUND);
		}
	}
}
