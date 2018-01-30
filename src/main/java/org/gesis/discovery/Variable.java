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
import org.gesis.skos.ConceptScheme;

/**
 * <p>
 * Variables provide a definition of the column in a rectangular data file. A
 * Variable is a characteristic of a unit being observed and might be the answer
 * of a question, have an administrative source, or be derived from other
 * variables (e.g. age group derived from age).
 * </p>
 * <p>
 * A Variable is a {@link Concept}.
 * </p>
 * 
 * @author matthaeus
 * @see {@link http://rdf-vocabulary.ddialliance.org/discovery.html#variable}
 */
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

	/**
	 * Variables can be described (dcterms:description), skos:notation is used to
	 * associate names to variables and labels can be assigned to variables via the
	 * datatype property skos:prefLabel.
	 * 
	 * @return The description of this Variable
	 * @see {@link Concept.setNotation()}
	 * @see {@link Resource.setPrefLabel()}
	 */
	public LangString getDescription()
	{
		return description;
	}

	/**
	 * Sets the description for this Variable.
	 * 
	 * @param description
	 * @return This Variable object.
	 * @see {@link getDescription()}
	 */
	public Variable setDescription( final LangString description )
	{
		this.description = description;
		return this;
	}

	/**
	 * For example, if the adult population of Finland is being studied, the
	 * AnalysisUnit would be individuals or persons.
	 * 
	 * @return The AnalysisUnit of this Variable.
	 * @see {@link AnalysisUnit}
	 */
	public AnalysisUnit getAnalysisUnit()
	{
		return analysisUnit;
	}

	/**
	 * Sets the AnalysisUnit for this Variable.
	 * 
	 * @param analysisUnit
	 * @return This Variable object.
	 * @see {@link getAnalysisUnit()}
	 */
	public Variable setAnalysisUnit( final AnalysisUnit analysisUnit )
	{
		this.analysisUnit = analysisUnit;
		return this;
	}

	/**
	 * Points to the DDI concept of a RepresentedVariable, a Variable, or a
	 * Question.
	 * 
	 * @return The Concept of this Variable.
	 * @see {@link Concept}
	 */
	public Concept getConcept()
	{
		return concept;
	}

	/**
	 * Sets the Concept for this Variable.
	 * 
	 * @param concept
	 * @return This Variable object.
	 * @see {@link getConcept()}
	 */
	public Variable setConcept( final Concept concept )
	{
		this.concept = concept;
		return this;
	}

	/**
	 * {@link RepresentedVariable}s encompasse study-independent, re-usable parts of
	 * Variables, like occupation classification.
	 * 
	 * @return The RepresentedVariable this Variable bases on.
	 * @see {@link RepresentedVariable}
	 */
	public RepresentedVariable getBasedOn()
	{
		return basedOn;
	}

	/**
	 * Sets the {@link RepresentedVariable} this Variable bases on.
	 * 
	 * @param dataElement
	 * @return This Variable object.
	 * @see {@link getBasedOn()}
	 */
	public Variable setBasedOn( final RepresentedVariable dataElement )
	{
		basedOn = dataElement;
		return this;
	}

	/**
	 * The {@link Representation} of a variable is the combination of a value
	 * domain, datatype, and, if necessary, a unit of measure or a character set.
	 * 
	 * @return The Representation of this Variable.
	 * @see {@link Representation}
	 * @see {@link ConceptScheme}
	 */
	public Representation getRepresentation()
	{
		return representation;
	}

	/**
	 * Sets the Representation which is one of a set of values to which a numerical
	 * measure or a category from a classification can be assigned (e.g. income,
	 * age, and sex: male coded as 1).
	 * 
	 * @param representation
	 * @return This Variable object.
	 * @see {@link getRepresentation()}
	 */
	public Variable setRepresentation( final Representation representation )
	{
		this.representation = representation;
		return this;
	}

	/**
	 * Indicates the particular {@link Universe}(s) that may be connected to this
	 * Variable. Any universe of a Variable definition is a subset of the Universe
	 * of the entire {@link Study}.
	 * 
	 * @return The Universe of this Variable.
	 * @see {@link Universe}
	 * @see {@link Concept}
	 */
	public Universe getUniverse()
	{
		return universe;
	}

	/**
	 * Sets the Universe for this Variable. Any universe of a Variable definition is
	 * a subset of the Universe of the entire {@link Study}.
	 * 
	 * @param universe
	 * @return This Variable object.
	 * @see {@link getUniverse()}
	 */
	public Variable setUniverse( final Universe universe )
	{
		this.universe = universe;
		return this;
	}

	/**
	 * A Question is designed to get information upon a subject, or sequence of
	 * subjects, from a respondent.
	 * 
	 * @return The list of Questions to which this individual Variable may be
	 *         linked.
	 * @see {@link Question}
	 * @see {@link Concept}
	 */
	public List<Question> getQuestion()
	{
		return question;
	}

	/**
	 * A Question is designed to get information upon a subject, or sequence of
	 * subjects, from a respondent.
	 * 
	 * @param questions
	 * @return This Variable object.
	 * @see {@link getQuestion()}
	 */
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
	 * Factory-method to create a Variable with the given <i>notation</i>.
	 * 
	 * @param notation
	 * @return A Variable object with the given notation.
	 */
	public static Variable withNotation( final String notation )
	{
		return Concept.withNotation( Variable.class, notation );
	}
}
