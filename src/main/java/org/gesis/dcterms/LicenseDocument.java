package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * License information is captured in a dcterms:LicenseDocument, which is a
 * subtype of dcterms:RightsStatements.
 * 
 * @author matthaeus
 * @see {@link RightsStatement}
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
