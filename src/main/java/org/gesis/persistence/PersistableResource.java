package org.gesis.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.util.IdentifierFactory;

/**
 * The most general class for types that should be persistable in the context of
 * this model package. It contains only an id of length of 40 characters and a
 * urn of length of 100 characters. The id is a UUID which is set while
 * instantiating of the class.
 * 
 * @author matthaeus
 */
@MappedSuperclass
public abstract class PersistableResource implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column( length = 40 )
	@Id
	private String id;

	@Column( length = 100 )
	private String urn;

	// getter / setter

	public PersistableResource()
	{
		id = IdentifierFactory.getNextDefaultIdentifier();
	}

	public String getId()
	{
		return id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}

	public String getURN()
	{
		return urn;
	}

	public PersistableResource setURN( final String urn )
	{
		this.urn = urn;
		return this;
	}

}
