package org.gesis.ddi;

import java.util.Set;

import javax.persistence.ManyToMany;


public class ResourcePackage extends Identifiable {

	@ManyToMany
	private Set<Identifiable> identifiable;

	public Set<Identifiable> getIdentifiable() {
		return identifiable;
	}

	public void setIdentifiable(Set<Identifiable> identifiable) {
		this.identifiable = identifiable;
	}

}
