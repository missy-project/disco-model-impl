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

	public ResourcePackage( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Set<Identifiable> getIdentifiable() {
		return identifiable;
	}

	public void setIdentifiable(Set<Identifiable> identifiable) {
		this.identifiable = identifiable;
	}

}
