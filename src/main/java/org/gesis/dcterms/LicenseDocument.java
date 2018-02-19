package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * License information is captured in a LicenseDocument (corresponds to
 * dcterms:LicenseDocument), which is a subtype of RightsStatements (corresponds
 * to dcterms:RightsStatement).
 * 
 * @author matthaeus
 * @see org.gesis.dcterms.RightsStatement
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class LicenseDocument extends RightsStatement
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
