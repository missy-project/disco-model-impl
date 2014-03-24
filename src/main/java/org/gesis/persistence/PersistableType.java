package org.gesis.persistence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.util.IdentifierFactory;

/**
 * The most general class for types that should be persistable in the context of
 * this model package. It contains only an id of length of 40 characters. The id
 * is a UUID which is set while instantiating of the class.
 * 
 * @author matthaeus
 * 
 */
@MappedSuperclass
public abstract class PersistableType
{

	// properties

	@Column( length = 40 )
	@Id
	private String id;

	public PersistableType()
	{
		id = IdentifierFactory.getNextDefaultIdentifier();
	}

	// getter / setter

	public String getId()
	{
		return id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}
}
