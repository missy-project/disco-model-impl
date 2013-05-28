package org.gesis.ddi;

import java.util.Set;

import javax.persistence.ManyToMany;

import org.gesis.rdfs.Resource;


public class ResourcePackage extends Resource
{

	// relations

	@ManyToMany
	private Set<Identifiable> identifiable;

	// getter/setter

	public Set<Identifiable> getIdentifiable() {
		return this.identifiable;
	}

	public void setIdentifiable(final Set<Identifiable> identifiable) {
		this.identifiable = identifiable;
	}

}
