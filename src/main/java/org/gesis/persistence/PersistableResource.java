package org.gesis.persistence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.gesis.ddi.util.IdentifierFactory;

/**
 * @author matthaeus
 * 
 */
@MappedSuperclass
public abstract class PersistableResource implements IPersistableResource
{

	@Column
	@Id
	private String id;

	@Column
	private String urn;

	public PersistableResource()
	{
		id = IdentifierFactory.getNextDefaultIdentifier();
	}

	/* (non-Javadoc)
	 * @see org.gesis.persistence.IPersistableResource#getId()
	 */
	@Override
	public String getId()
	{
		return id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.gesis.persistence.IPersistableResource#getURN()
	 */
	@Override
	public String getURN()
	{
		return urn;
	}

	public void setURN( final String urn )
	{
		this.urn = urn;
	}

}
