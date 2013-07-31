package org.gesis.rdfs;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.gesis.adms.Identifier;
import org.gesis.persistence.PersistableResource;
import org.gesis.rdf.LangString;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Resource extends PersistableResource
{

	// properties

	@Column
	private String versionInfo;

	// relations

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Identifier identifier;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString prefLabel;

	// getter/setter

	public Resource()
	{
		super();
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
