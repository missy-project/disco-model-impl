package org.gesis.rdfs;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.gesis.persistence.PersistableResource;
import org.gesis.rdf.LangString;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Resource extends PersistableResource
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

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString prefLabel;

	@Column
	private String versionInfo;

	// relations

	// getter/setter

	public Resource()
	{
		super();
	}

	public String getDdi2_1Identifier()
	{
		return this.ddi2_1Identifier;
	}

	public void setDdi2_1Identifier( final String ddi2_1Identifier )
	{
		this.ddi2_1Identifier = ddi2_1Identifier;
	}

	public String getDdi2_5Identifier()
	{
		return this.ddi2_5Identifier;
	}

	public void setDdi2_5Identifier( final String ddi2_5Identifier )
	{
		this.ddi2_5Identifier = ddi2_5Identifier;
	}

	public String getDdi3_0Identifier()
	{
		return this.ddi3_0Identifier;
	}

	public void setDdi3_0Identifier( final String ddi3_0Identifier )
	{
		this.ddi3_0Identifier = ddi3_0Identifier;
	}

	public String getDdi3_1Identifier()
	{
		return this.ddi3_1Identifier;
	}

	public void setDdi3_1Identifier( final String ddi3_1Identifier )
	{
		this.ddi3_1Identifier = ddi3_1Identifier;
	}

	public String getDdi3_2Identifier()
	{
		return this.ddi3_2Identifier;
	}

	public void setDdi3_2Identifier( final String ddi3_2Identifier )
	{
		this.ddi3_2Identifier = ddi3_2Identifier;
	}

	public LangString getPrefLabel()
	{
		return this.prefLabel;
	}

	public void setPrefLabel( final LangString skos_prefLabel )
	{
		this.prefLabel = skos_prefLabel;
	}

	public String getVersionInfo()
	{
		return versionInfo;
	}

	public void setVersionInfo( final String versionInfo )
	{
		this.versionInfo = versionInfo;
	}

}
