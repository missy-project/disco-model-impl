package org.gesis.ddi;

import java.util.Set;

import javax.persistence.ManyToMany;


public class ResourcePackage extends Identifiable {

	// relations

	@ManyToMany
	private Set<Identifiable> identifiable;

	// getter/setter

	public Set<Identifiable> getIdentifiable() {
		return identifiable;
	}

	public void setIdentifiable(Set<Identifiable> identifiable) {
		this.identifiable = identifiable;
	}

}
