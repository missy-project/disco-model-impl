package org.gesis.ddi.ontology;

import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Variable extends Resource
{

	// properties

	@Column
	protected String skos_notation;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected LangString dcterms_description;

	// relations

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "analysisUnit_id" )
	protected AnalysisUnit analysisUnit;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "concept_id" )
	protected Concept concept;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "variableDefinition_id" )
	protected VariableDefinition basedOn;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "representation_id" )
	protected Representation representation;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( 
			name = "Variable_Question", 
			joinColumns = @JoinColumn( name = "variable_id" ), 
			inverseJoinColumns = @JoinColumn( name = "question_id" ) )
	protected Set<Question> question;

	// getter/setter

	private Variable()
	{
		super( null, null, 0 );
	}

	public Variable( final String agencyId, final String objectId, final int majorVersion )
	{
		super( agencyId, objectId, majorVersion );
	}

	public String getSkos_notation()
	{
		return this.skos_notation;
	}

	public void setSkos_notation(final String skos_notation)
	{
		this.skos_notation = skos_notation;
	}

	public LangString getDcterms_description()
	{
		return this.dcterms_description;
	}

	public void setDcterms_description( final LangString dcterms_description )
	{
		this.dcterms_description = dcterms_description;
	}

	public AnalysisUnit getAnalysisUnit()
	{
		return this.analysisUnit;
	}

	public void setAnalysisUnit(final AnalysisUnit analysisUnit)
	{
		this.analysisUnit = analysisUnit;
	}

	public Concept getConcept()
	{
		return this.concept;
	}

	public void setConcept(final Concept concept)
	{
		this.concept = concept;
	}

	public VariableDefinition getBasedOn()
	{
		return this.basedOn;
	}

	public void setBasedOn(final VariableDefinition dataElement)
	{
		this.basedOn = dataElement;
	}

	public Representation getRepresentation()
	{
		return this.representation;
	}

	public void setRepresentation(final Representation representation)
	{
		this.representation = representation;
	}

	public Universe getUniverse()
	{
		return this.universe;
	}

	public void setUniverse(final Universe universe)
	{
		this.universe = universe;
	}

	public Set<Question> getQuestion()
	{
		return this.question;
	}

	public void setQuestion(final Set<Question> questions)
	{
		this.question = questions;
	}

	public Variable addQuestion( final Question question )
	{
		if ( this.question == null )
			this.question = new HashSet<Question>();

		this.question.add( question );

		return this;
	}
}
