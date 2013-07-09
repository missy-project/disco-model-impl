package org.gesis.skos;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString skos_definition;

	@Column
	private String skos_notation;

	@Column
	private boolean isValid;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Concept_ConceptScheme", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "inScheme_id" ) )
	protected Set<ConceptScheme> skos_inScheme;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Concept_Broader", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "broader_id" ) )
	protected Set<Concept> skos_broader;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Concept_Narrower", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "narrower_id" ) )
	protected Set<Concept> skos_narrower;

	// getter/setter

	public LangString getSkos_definition()
	{
		return this.skos_definition;
	}

	public void setSkos_definition( final LangString skos_definition )
	{
		this.skos_definition = skos_definition;
	}

	public String getSkos_notation()
	{
		return this.skos_notation;
	}

	public void setSkos_notation( final String skos_notation )
	{
		this.skos_notation = skos_notation;
	}

	public boolean isValid()
	{
		return this.isValid;
	}

	public void setValid( final boolean isValid )
	{
		this.isValid = isValid;
	}

	public Concept addSkos_inScheme( final ConceptScheme conceptScheme )
	{
		if ( this.skos_inScheme == null )
			this.skos_inScheme = new LinkedHashSet<ConceptScheme>();

		this.skos_inScheme.add( conceptScheme );

		return this;
	}

	public Set<ConceptScheme> getSkos_inScheme()
	{
		return this.skos_inScheme;
	}

	public void setSkos_inScheme( final Set<ConceptScheme> skos_inScheme )
	{
		this.skos_inScheme = skos_inScheme;
	}

	public Concept addSkos_broader( final Concept concept )
	{
		if ( this.skos_broader == null )
			this.skos_broader = new LinkedHashSet<Concept>();

		this.skos_broader.add( concept );

		return this;
	}

	public Set<Concept> getSkos_broader()
	{
		return this.skos_broader;
	}

	public void setSkos_broader( final Set<Concept> skos_broader )
	{
		this.skos_broader = skos_broader;
	}

	public Concept addSkos_narrower( final Concept concept )
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

	public void setSkos_narrower( final Set<Concept> skos_narrower )
	{
		this.skos_narrower = skos_narrower;
	}

}