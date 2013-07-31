package org.gesis.adms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.persistence.PersistableResource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Identifier extends PersistableResource
{

	// properties

	@Column
	private String notation;

	@Column
	private String creator;

	@Column
	private String schema_agency;

	@Column
	private Date issued;

	// relations

	// getter / setter

	public String getNotation()
	{
		return notation;
	}

	public void setNotation( final String notation )
	{
		this.notation = notation;
	}

	public String getCreator()
	{
		return creator;
	}

	public void setCreator( final String creator )
	{
		this.creator = creator;
	}

	public String getSchema_agency()
	{
		return schema_agency;
	}

	public void setSchema_agency( final String schema_agency )
	{
		this.schema_agency = schema_agency;
	}

	public Date getIssued()
	{
		return issued;
	}

	public void setIssued( final Date issued )
	{
		this.issued = issued;
	}

}
