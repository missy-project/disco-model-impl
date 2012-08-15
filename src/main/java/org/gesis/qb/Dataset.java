package org.gesis.qb;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.ontology.Variable;

@MappedSuperclass
public class Dataset {

	// relations

	@ManyToMany
	private Set<Variable> inputVariable;

	// getter/setter

	public Set<Variable> getInputVariable() {
		return inputVariable;
	}

	public void setInputVariable(Set<Variable> inputVariable) {
		this.inputVariable = inputVariable;
	}

}
