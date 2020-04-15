package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
