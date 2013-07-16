package org.gesis.rdfs;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.discovery.Union_DataTypeOrderedCollection;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Datatype extends Union_DataTypeOrderedCollection
{

	/**
	 *
	 */
	private static final long serialVersionUID = 8651712862586966754L;

}
