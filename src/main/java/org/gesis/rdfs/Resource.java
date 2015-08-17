package org.gesis.rdfs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.gesis.adms.Identifier;
import org.gesis.persistence.PersistableResource;
import org.gesis.rdf.LangString;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Resource extends PersistableResource
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@Column
	private String versionInfo;

	// relations

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "resource_id" )
	private List<Identifier> identifier;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString prefLabel;

	// getter/setter

	public Resource()
	{
		super();
	}

	/**
	 * Corresponds to skos:prefLabel. <br>
	 * <br>
	 * From the specification: <br>
	 * <i>"A lexical label is a string of UNICODE characters, such as "romantic
	 * love", in a given natural language, such as English or Japanese (written
	 * here in hiragana). <br>
	 * <br>
	 * The preferred and alternative labels are useful when generating or
	 * creating human-readable representations of a knowledge organization
	 * system. These labels provide the strongest clues as to the meaning of a
	 * SKOS concept."</i>
	 * 
	 * @return
	 */
	public LangString getPrefLabel()
	{
		return this.prefLabel;
	}

	public void setPrefLabel( final LangString skos_prefLabel )
	{
		this.prefLabel = skos_prefLabel;
	}

	/**
	 * Corresponds to owl:versionInfo
	 * 
	 * @return
	 */
	public String getVersionInfo()
	{
		return versionInfo;
	}

	public void setVersionInfo( final String versionInfo )
	{
		this.versionInfo = versionInfo;
	}

	public List<Identifier> getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier( final List<Identifier> identifier )
	{
		this.identifier = identifier;
	}
}
