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
	private LangString definition;

	@Column
	private String notation;

	@Column
	private boolean isValid;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Concept_ConceptScheme", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "inScheme_id" ) )
	protected Set<ConceptScheme> inScheme;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Concept_Broader", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "broader_id" ) )
	protected Set<Concept> broader;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Concept_Narrower", 
			joinColumns = @JoinColumn( name = "concept_id" ), 
			inverseJoinColumns = @JoinColumn( name = "narrower_id" ) )
	protected Set<Concept> narrower;

	// getter/setter

	public LangString getDefinition()
	{
		return this.definition;
	}

	public void setDefinition( final LangString skos_definition )
	{
		this.definition = skos_definition;
	}

	public String getNotation()
	{
		return this.notation;
	}

	public void setNotation( final String skos_notation )
	{
		this.notation = skos_notation;
	}

	public boolean isValid()
	{
		return this.isValid;
	}

	public void setValid( final boolean isValid )
	{
		this.isValid = isValid;
	}

	public Concept addInScheme( final ConceptScheme conceptScheme )
	{
		if ( this.inScheme == null )
			this.inScheme = new LinkedHashSet<ConceptScheme>();

		this.inScheme.add( conceptScheme );

		return this;
	}

	public Set<ConceptScheme> getInScheme()
	{
		return this.inScheme;
	}

	public void setInScheme( final Set<ConceptScheme> skos_inScheme )
	{
		this.inScheme = skos_inScheme;
	}

	public Concept addBroader( final Concept concept )
	{
		if ( this.broader == null )
			this.broader = new LinkedHashSet<Concept>();

		this.broader.add( concept );

		return this;
	}

	public Set<Concept> getBroader()
	{
		return this.broader;
	}

	public void setBroader( final Set<Concept> skos_broader )
	{
		this.broader = skos_broader;
	}

	public Concept addNarrower( final Concept concept )
	{
		if ( this.narrower == null )
			this.narrower = new LinkedHashSet<Concept>();

		this.narrower.add( concept );

		return this;
	}

	public Set<Concept> getNarrower()
	{
		return this.narrower;
	}

	public void setNarrower( final Set<Concept> skos_narrower )
	{
		this.narrower = skos_narrower;
	}

}