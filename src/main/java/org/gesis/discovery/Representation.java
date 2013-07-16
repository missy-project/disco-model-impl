package org.gesis.discovery;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Representation extends Union_RdfsDataTypeSkosOrderedCollection
{

	/**
	 *
	 */
	private static final long serialVersionUID = 5380796606719931171L;

	// properties

	// relations

	// getter / setter

}