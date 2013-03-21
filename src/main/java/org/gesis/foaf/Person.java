package org.gesis.foaf;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.gesis.org.Organization;

@MappedSuperclass
public class Person extends Agent {

	// properties

	// relations

	@OneToOne
	private Organization org_memberOf;

	// getter/setter

	public Person( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Organization getOrg_memberOf() {
		return org_memberOf;
	}

	public void setOrg_memberOf(Organization org_memberOf) {
		this.org_memberOf = org_memberOf;
	}

}
