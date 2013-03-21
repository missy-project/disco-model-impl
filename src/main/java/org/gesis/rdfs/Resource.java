package org.gesis.rdfs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.ddi.Identifiable;
import org.gesis.rdf.LangString;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Resource extends Identifiable
{

	// properties

	@Column
	private String ddi2_1Identifier;

	@Column
	private String ddi2_5Identifier;

	@Column
	private String ddi3_0Identifier;

	@Column
	private String ddi3_1Identifier;

	@Column
	private String ddi3_2Identifier;

	@OneToOne
	private LangString skos_prefLabel;

	// relations

	// getter/setter

	public Resource( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public String getDdi2_1Identifier()
	{
		return ddi2_1Identifier;
	}

	public void setDdi2_1Identifier( String ddi2_1Identifier )
	{
		this.ddi2_1Identifier = ddi2_1Identifier;
	}

	public String getDdi2_5Identifier()
	{
		return ddi2_5Identifier;
	}

	public void setDdi2_5Identifier( String ddi2_5Identifier )
	{
		this.ddi2_5Identifier = ddi2_5Identifier;
	}

	public String getDdi3_0Identifier()
	{
		return ddi3_0Identifier;
	}

	public void setDdi3_0Identifier( String ddi3_0Identifier )
	{
		this.ddi3_0Identifier = ddi3_0Identifier;
	}

	public String getDdi3_1Identifier()
	{
		return ddi3_1Identifier;
	}

	public void setDdi3_1Identifier( String ddi3_1Identifier )
	{
		this.ddi3_1Identifier = ddi3_1Identifier;
	}

	public String getDdi3_2Identifier()
	{
		return ddi3_2Identifier;
	}

	public void setDdi3_2Identifier( String ddi3_2Identifier )
	{
		this.ddi3_2Identifier = ddi3_2Identifier;
	}

	public LangString getSkos_prefLabel()
	{
		return skos_prefLabel;
	}

	public void setSkos_prefLabel( LangString skos_prefLabel )
	{
		this.skos_prefLabel = skos_prefLabel;
	}

}
