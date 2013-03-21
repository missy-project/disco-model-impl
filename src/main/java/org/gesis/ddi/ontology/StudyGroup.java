package org.gesis.ddi.ontology;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.ddi.Identifiable;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class StudyGroup extends Identifiable
{

	public StudyGroup( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

}
