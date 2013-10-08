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
	private Boolean isValid = false;

	// relations

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Concept_ConceptScheme",
			joinColumns = @JoinColumn( name = "concept_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "inScheme_id" ) )
	private Set<ConceptScheme> inScheme;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Concept_ConceptBroader",
			joinColumns = @JoinColumn( name = "concept_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "broader_id" ) )
	private Set<Concept> broader;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name = "Concept_ConceptNarrower",
			joinColumns = @JoinColumn( name = "concept_id", referencedColumnName = "id" ),
			inverseJoinColumns = @JoinColumn( name = "narrower_id" ) )
	private Set<Concept> narrower;

	// getter/setter

	/**
	 * Corresponds to skos:definition. <br>
	 * <br>
	 * A skos:definition is a "documentation property (note property)", which in
	 * skos refers to <i>"... information relating to SKOS concepts. There is no
	 * restriction on the nature of this information, e.g., it could be plain
	 * text, hypertext, or an image; it could be a definition, information about
	 * the scope of a concept, editorial information, or any other type of
	 * information."</i> (from the specification).
	 * 
	 * @return
	 */
	public LangString getDefinition()
	{
		return definition;
	}

	public void setDefinition( final LangString skos_definition )
	{
		definition = skos_definition;
	}

	public String getNotation()
	{
		return notation;
	}

	public void setNotation( final String skos_notation )
	{
		notation = skos_notation;
	}

	public Boolean isValid()
	{
		return isValid;
	}

	public void setValid( final Boolean isValid )
	{
		this.isValid = isValid;
	}

	public Concept addInScheme( final ConceptScheme conceptScheme )
	{
		if ( inScheme == null )
			inScheme = new LinkedHashSet<ConceptScheme>();

		inScheme.add( conceptScheme );

		return this;
	}

	public Set<ConceptScheme> getInScheme()
	{
		return inScheme;
	}

	public void setInScheme( final Set<ConceptScheme> skos_inScheme )
	{
		inScheme = skos_inScheme;
	}

	public Concept addBroader( final Concept concept )
	{
		if ( broader == null )
			broader = new LinkedHashSet<Concept>();

		broader.add( concept );

		return this;
	}

	public Set<Concept> getBroader()
	{
		return broader;
	}

	public void setBroader( final Set<Concept> skos_broader )
	{
		broader = skos_broader;
	}

	public Concept addNarrower( final Concept concept )
	{
		if ( narrower == null )
			narrower = new LinkedHashSet<Concept>();

		narrower.add( concept );

		return this;
	}

	public Set<Concept> getNarrower()
	{
		return narrower;
	}

	public void setNarrower( final Set<Concept> skos_narrower )
	{
		narrower = skos_narrower;
	}

}