package org.gesis.rdfs;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.ddi.ontology.Representation;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class RdfsDatatype extends Representation
{

	public RdfsDatatype( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

}
