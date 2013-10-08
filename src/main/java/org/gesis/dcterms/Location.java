package org.gesis.dcterms;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Location extends Resource
{

	// properties

	private String label;

	// getter/setter

	/**
	 * Corresponds to rdfs:label.
	 * 
	 * @return
	 */
	public String getLabel()
	{
		return label;
	}

	public void setLabel( final String label )
	{
		this.label = label;
	}

}
