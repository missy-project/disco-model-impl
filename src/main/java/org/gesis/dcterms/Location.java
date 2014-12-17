package org.gesis.dcterms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;

import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Location extends Resource
{

	// properties

	@Column
	@Lob
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
