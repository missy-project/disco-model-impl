package org.gesis.discovery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import org.gesis.skos.Concept;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Variable extends Concept
{

	// properties

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	protected LangString description;

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
	protected List<Question> question;

	// getter/setter

	public LangString getDescription()
	{
		return description;
	}

	public void setDescription( final LangString dcterms_description )
	{
		this.description = dcterms_description;
	}

	public AnalysisUnit getAnalysisUnit()
	{
		return analysisUnit;
	}

	public void setAnalysisUnit(final AnalysisUnit analysisUnit)
	{
		this.analysisUnit = analysisUnit;
	}

	public Concept getConcept()
	{
		return concept;
	}

	public void setConcept(final Concept concept)
	{
		this.concept = concept;
	}

	public VariableDefinition getBasedOn()
	{
		return basedOn;
	}

	public void setBasedOn(final VariableDefinition dataElement)
	{
		basedOn = dataElement;
	}

	public Representation getRepresentation()
	{
		return representation;
	}

	public void setRepresentation( final Representation representation )
	{
		this.representation = representation;
	}

	public Universe getUniverse()
	{
		return universe;
	}

	public void setUniverse(final Universe universe)
	{
		this.universe = universe;
	}

	public List<Question> getQuestion()
	{
		return question;
	}

	public void setQuestion(final List<Question> questions)
	{
		question = questions;
	}

	public Variable addQuestion( final Question question )
	{
		if ( this.question == null )
			this.question = new ArrayList<Question>();

		this.question.add( question );

		return this;
	}
}
