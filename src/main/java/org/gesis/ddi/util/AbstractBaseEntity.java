package org.gesis.ddi.util;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


@MappedSuperclass
public class AbstractBaseEntity
{

	@Column
	@Id
	private String id;

	@Transient
	private Identifier identifier;

	public AbstractBaseEntity()
	{
		this.id = IdentifierFactory.getNextDefaultIdentifier();
	}

	public AbstractBaseEntity( final Identifier identifier )
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

}
