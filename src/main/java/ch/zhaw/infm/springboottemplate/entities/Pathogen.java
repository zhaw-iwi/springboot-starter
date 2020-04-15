package ch.zhaw.infm.springboottemplate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pathogen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String icd10;
	private int incubation;

	public Pathogen(String icd10, int incubation) {
		this.icd10 = icd10;
		this.incubation = incubation;
	}

	public Pathogen() {
	}

	public String getIcd10() {
		return this.icd10;
	}

	public int getIncubation() {
		return this.incubation;
	}
}