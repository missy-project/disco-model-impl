package org.gesis.ddi.ontology;

import java.util.Set;

import javax.persistence.ElementCollection;
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
public class Instrument extends Resource
{

	// properties

	@OneToOne
	private LangString dcterms_description;

	// relations

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Instrument_Document",
			joinColumns = @JoinColumn( name = "instrument_id" ), 
			inverseJoinColumns = @JoinColumn( name = "document_id" ) )
	protected Set<Document> externalDocumentation;

	// getter/setter

	public Instrument( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public LangString getDcterms_description()
	{
		return dcterms_description;
	}

	public void setDcterms_description( LangString dcterms_description )
	{
		this.dcterms_description = dcterms_description;
	}

	public Set<Document> getExternalDocumentation()
	{
		return this.externalDocumentation;
	}

	public void setExternalDocumentation( Set<Document> externalDocumentation )
	{
		this.externalDocumentation = externalDocumentation;
	}

}