package org.gesis.ddi.ontology;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Question extends Resource
{

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private LangString questionText;

	// relations

	@ElementCollection
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Question_Representation",
			joinColumns=@JoinColumn( name = "question_id" ),
			inverseJoinColumns=@JoinColumn( name = "representation_id" ) )
	protected Set<Representation> responseDomain;

	@ElementCollection
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(
			name="Question_Concept",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn( name = "concept_id" ))
	protected Set<Concept> concept;

	@ElementCollection
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	// getter/setter

	private Question()
	{
		super( null, null, 0 );
	}

	public Question( final String agencyId, final String objectId, final int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public Object getQuestionText()
	{
		return this.questionText;
	}

	public void setQuestionText( final LangString questionText )
	{
		this.questionText = questionText;
	}

	public Set<Representation> getResponseDomain()
	{
		return this.responseDomain;
	}

	public void setResponseDomain( final Set<Representation> responseDomain )
	{
		this.responseDomain = responseDomain;
	}

	public Question addResponseDomain( final Representation responseDomain )
	{
		if ( this.responseDomain == null )
			this.responseDomain = new HashSet<Representation>();

		this.responseDomain.add( responseDomain );

		return this;
	}

	public Set<Concept> getConcept() {
		return this.concept;
	}

	public void setConcept(final Set<Concept> concept) {
		this.concept = concept;
	}

	public Question addConcept( final Concept concept )
	{
		if ( this.concept == null )
			this.concept = new HashSet<Concept>();

		this.concept.add( concept );

		return this;
	}

	public Universe getUniverse()
	{
		return this.universe;
	}

	public void setUniverse( final Universe universe )
	{
		this.universe = universe;
	}

}