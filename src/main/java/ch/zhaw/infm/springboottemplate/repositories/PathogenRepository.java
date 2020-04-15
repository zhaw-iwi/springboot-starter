package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Pathogen;

public interface PathogenRepository extends JpaRepository<Pathogen, Long> {

}
