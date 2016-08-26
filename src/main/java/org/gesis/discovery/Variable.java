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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	protected RepresentedVariable basedOn;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "representation_id" )
	protected Representation representation;

	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "universe_id" )
	protected Universe universe;

	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable( name = "Variable_Question", joinColumns = @JoinColumn( name = "variable_id" ), inverseJoinColumns = @JoinColumn( name = "question_id" ) )
	protected List<Question> question;

	// getter/setter

	public LangString getDescription()
	{
		return description;
	}

	public Variable setDescription( final LangString description )
	{
		this.description = description;
		return this;
	}

	public AnalysisUnit getAnalysisUnit()
	{
		return analysisUnit;
	}

	public Variable setAnalysisUnit( final AnalysisUnit analysisUnit )
	{
		this.analysisUnit = analysisUnit;
		return this;
	}

	public Concept getConcept()
	{
		return concept;
	}

	public Variable setConcept( final Concept concept )
	{
		this.concept = concept;
		return this;
	}

	public RepresentedVariable getBasedOn()
	{
		return basedOn;
	}

	public Variable setBasedOn( final RepresentedVariable dataElement )
	{
		basedOn = dataElement;
		return this;
	}

	public Representation getRepresentation()
	{
		return representation;
	}

	public Variable setRepresentation( final Representation representation )
	{
		this.representation = representation;
		return this;
	}

	public Universe getUniverse()
	{
		return universe;
	}

	public Variable setUniverse( final Universe universe )
	{
		this.universe = universe;
		return this;
	}

	public List<Question> getQuestion()
	{
		return question;
	}

	public Variable setQuestion( final List<Question> questions )
	{
		question = questions;
		return this;
	}

	public Variable addQuestion( final Question question )
	{
		if ( this.question == null )
			this.question = new ArrayList<Question>();

		this.question.add( question );

		return this;
	}

	/**
	 * Factory-method for obtaining a Variable with predefined <i>notation</i>.
	 * 
	 * @param notation
	 *            May be null.
	 * @return
	 */
	public static Variable withNotation( final String notation )
	{
		Variable variable = new Variable();
		variable.setNotation( notation );

		return variable;
	}
}
