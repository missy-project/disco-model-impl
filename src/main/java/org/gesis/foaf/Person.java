package org.gesis.foaf;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.gesis.org.Organization;

@MappedSuperclass
public class Person extends Agent {

	// properties

	// relations

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Organization org_memberOf;

	// getter/setter

	public Organization getOrg_memberOf() {
		return this.org_memberOf;
	}

	public void setOrg_memberOf(final Organization org_memberOf) {
		this.org_memberOf = org_memberOf;
	}

}
