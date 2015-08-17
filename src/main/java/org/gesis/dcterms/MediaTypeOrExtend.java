package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class MediaTypeOrExtend extends Concept
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	// relations

	// getter / setter

}