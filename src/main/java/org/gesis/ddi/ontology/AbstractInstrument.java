package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;

@MappedSuperclass
public abstract class AbstractInstrument<Q extends AbstractQuestion<?>> extends Identifiable {

	// relations

	@ManyToMany
	private Set<Q> usesQuestion;

	// getter/setter

	public Set<Q> getUsesQuestion() {
		return usesQuestion;
	}

	public void setUsesQuestion(Set<Q> usesQuestion) {
		this.usesQuestion = usesQuestion;
	}



}
