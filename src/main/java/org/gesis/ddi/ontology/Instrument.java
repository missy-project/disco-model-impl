package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public class Instrument extends Identifiable {

	// relations

	@ManyToMany
	private Set<Instrument> usesQuestion;

	// getter/setter

	public Set<Instrument> getUsesQuestion() {
		return usesQuestion;
	}

	public void setUsesQuestion(Set<Instrument> usesQuestion) {
		this.usesQuestion = usesQuestion;
	}



}
