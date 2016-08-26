package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class ProvenanceStatement extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
