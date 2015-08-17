package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class LicenseDocument extends RightsStatement
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
