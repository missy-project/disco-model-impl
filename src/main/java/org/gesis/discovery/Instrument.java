package org.gesis.discovery;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString description;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Instrument_Document",
			joinColumns = @JoinColumn( name = "instrument_id" ), 
			inverseJoinColumns = @JoinColumn( name = "document_id" ) )
	protected Set<Document> externalDocumentation;

	// getter/setter

	public LangString getDescription()
	{
		return this.description;
	}

	public void setDescription( final LangString description )
	{
		this.description = description;
	}

	public Set<Document> getExternalDocumentation()
	{
		return this.externalDocumentation;
	}

	public void setExternalDocumentation( final Set<Document> externalDocumentation )
	{
		this.externalDocumentation = externalDocumentation;
	}

	public Instrument addExternalDocumentation( final Document document )
	{
		if ( this.externalDocumentation == null )
			this.externalDocumentation = new HashSet<Document>();

		this.externalDocumentation.add( document );

		return this;
	}

}