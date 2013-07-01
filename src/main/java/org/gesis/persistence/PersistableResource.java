package org.gesis.persistence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.gesis.ddi.util.Identifier;
import org.gesis.ddi.util.IdentifierFactory;

@MappedSuperclass
public abstract class PersistableResource
{

	@Column
	@Id
	private String id;

	@Column
	private String urn;

	@Transient
	private Identifier identifier;

	public PersistableResource()
	{
		this.id = IdentifierFactory.getNextDefaultIdentifier();
	}

	public PersistableResource( final Identifier identifier )
	{
		this.identifier = identifier;
		this.id = identifier.getUniqueId();
	}

	public String getId()
	{
		return this.id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}

	public Identifier getIdentifier()
	{
		return this.identifier;
	}

	public void setIdentifier( final Identifier identifier )
	{
		this.identifier = identifier;
	}

	public String getURN()
	{
		return this.urn;
	}

	public void setURN( final String urn )
	{
		this.urn = urn;
	}

}
