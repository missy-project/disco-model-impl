package org.gesis.skos;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Concept extends Resource
{

	// properties

	@OneToOne
	private LangString skos_definition;

	@Column
	private String skos_notation;

	// relations

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Concept_ConceptScheme",
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "inScheme_id" ) )
	protected Set<ConceptScheme> skos_inScheme;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Concept_Concept", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "broader_id" ) )
	protected Set<Concept> skos_broader;

	@ElementCollection
	@ManyToMany
	@JoinTable( 
			name = "Concept_Concept", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "narrower_id" ) )
	protected Set<Concept> skos_narrower;

	// getter/setter

	public Concept( String agencyId, String objectId, int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public LangString getSkos_definition()
	{
		return skos_definition;
	}

	public void setSkos_definition( LangString skos_definition )
	{
		this.skos_definition = skos_definition;
	}

	public String getSkos_notation()
	{
		return skos_notation;
	}

	public void setSkos_notation( String skos_notation )
	{
		this.skos_notation = skos_notation;
	}

	public Concept addSkos_inScheme(ConceptScheme conceptScheme)
	{
		this.skos_inScheme.add( conceptScheme );
		return this;
	}

	public Set<ConceptScheme> getSkos_inScheme()
	{
		return this.skos_inScheme;
	}

	public void setSkos_inScheme(Set<ConceptScheme> skos_inScheme)
	{
		this.skos_inScheme = skos_inScheme;
	}

	public Concept addSkos_broader(Concept concept)
	{
		if (this.skos_broader == null)
			this.skos_broader = new HashSet<Concept>();
		
		this.skos_broader.add( concept );
		return this;
	}

	public Set<Concept> getSkos_broader()
	{
		return this.skos_broader;
	}

	public void setSkos_broader(Set<Concept> skos_broader)
	{
		this.skos_broader = skos_broader;
	}

	public Concept addSkos_narrower(Concept concept)
	{
		if ( this.skos_narrower == null )
			this.skos_narrower = new LinkedHashSet<Concept>();

		this.skos_narrower.add( concept );
		return this;
	}

	public Set<Concept> getSkos_narrower()
	{
		return this.skos_narrower;
	}

	public void setSkos_narrower(Set<Concept> skos_narrower)
	{
		this.skos_narrower = skos_narrower;
	}

}