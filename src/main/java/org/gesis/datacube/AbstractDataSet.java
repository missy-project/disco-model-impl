package org.gesis.datacube;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.Identifiable;
import org.gesis.ddi.ontology.AbstractVariable;

@MappedSuperclass
public abstract class AbstractDataSet<V extends AbstractVariable<?>> extends Identifiable {

	// relations

	@ManyToMany
	private Set<V> inputVariable;

	// getter/setter

	public Set<V> getInputVariable() {
		return inputVariable;
	}

	public void setInputVariable(Set<V> inputVariable) {
		this.inputVariable = inputVariable;
	}

}
