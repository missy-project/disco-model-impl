package org.gesis.dcterms;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.gesis.foaf.Document;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;

/**
 * Access rights are defined in a dcterms:RightsStatement object, which may
 * reference an external document stating the access rights in more detail.
 * 
 * @author matthaeus
 * @see org.gesis.dcterms.LicenseDocument
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class RightsStatement extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties

	@OneToOne
	private LangString description;

	// relations

	@ManyToMany
	@JoinTable(
			name = "RightsStatement_Document",
			joinColumns = @JoinColumn( name = "rightsStatement_id" ),
			inverseJoinColumns = @JoinColumn( name = "document_id" ) )
	protected List<Document> seeAlso;

	// getter/setter

	/**
	 * @return The list of Documents this RightsStatements has attached.
	 * @see org.gesis.foaf.Document
	 */
	public List<Document> getSeeAlso()
	{
		return this.seeAlso;
	}

	/**
	 * Corresponds to rdfs:seeAlso.
	 * 
	 * @param seeAlso
	 * @return This RightsStatement object.
	 * @see #getSeeAlso()
	 */
	public RightsStatement setSeeAlso( final List<Document> seeAlso )
	{
		this.seeAlso = seeAlso;
		return this;
	}

	/**
	 * @return The description of this RightsStatement.
	 */
	public LangString getDescription()
	{
		return this.description;
	}

	/**
	 * Corresponds to dcterms:description. For a RightsStatement descriptions and
	 * labels (skos:prefLabel) may be given.
	 * 
	 * @param description
	 * @return This RightsStatement object.
	 * @see #getDescription()
	 * @see org.gesis.rdfs.Resource
	 */
	public RightsStatement setDescription( final LangString description )
	{
		this.description = description;
		return this;
	}

}
