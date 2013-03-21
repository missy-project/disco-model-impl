package org.gesis.org;

import javax.persistence.MappedSuperclass;

import org.gesis.foaf.Agent;

@MappedSuperclass
public class Organization extends Agent {

	public Organization( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

}
