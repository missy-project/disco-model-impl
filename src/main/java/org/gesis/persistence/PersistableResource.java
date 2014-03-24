package org.gesis.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Extends {@link PersistableType} with Resource specific attributes, namely a
 * <i>URN</i>.
 * 
 * @author matthaeus
 * 
 */
@MappedSuperclass
public abstract class PersistableResource extends PersistableType
{

	// properties

	@Column( length = 100 )
	private String urn;

	// getter / setter

	public PersistableResource()
	{
		super();
	}

	public String getURN()
	{
		return urn;
	}

	public void setURN( final String urn )
	{
		this.urn = urn;
	}

}
