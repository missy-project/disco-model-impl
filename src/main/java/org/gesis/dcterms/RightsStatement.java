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

	public List<Document> getSeeAlso()
	{
		return this.seeAlso;
	}

	public void setSeeAlso( final List<Document> rdfs_seeAlso )
	{
		this.seeAlso = rdfs_seeAlso;
	}

	public LangString getDescription()
	{
		return this.description;
	}

	public void setDescription( final LangString dcterms_description )
	{
		this.description = dcterms_description;
	}

}
