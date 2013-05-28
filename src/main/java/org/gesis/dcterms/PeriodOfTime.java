package org.gesis.dcterms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class PeriodOfTime extends Resource
{

	// properties

	@Column
	private Date startDate;

	@Column
	private Date endDate;

	// relations

	// getter / setter

	public Date getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate( final Date startDate )
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return this.endDate;
	}

	public void setEndDate( final Date endDate )
	{
		this.endDate = endDate;
	}

}
